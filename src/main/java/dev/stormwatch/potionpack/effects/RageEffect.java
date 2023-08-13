package dev.stormwatch.potionpack.effects;

import dev.stormwatch.potionpack.registry.ModEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

import java.util.UUID;

public class RageEffect extends MobEffect {

    public static final String ATTRIBUTE_NAME = "potionpack_rage_attackspeed";
    public static final UUID ATTRIBUTE_UUID = UUID.fromString("d3a733b5-5daa-4787-aa1b-0283efec05a0");

    private static final double EFFECT_STRENGTH = 0.05;

    public RageEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xff4d00);
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();
        if (player.level.isClientSide()) return;
        if (!(player.hasEffect(ModEffects.RAGE.get()))) return;
        MobEffectInstance instance = player.getEffect(ModEffects.RAGE.get());
        int amplifier = instance.getAmplifier();
        AttributeInstance attackSpeed = player.getAttribute(Attributes.ATTACK_SPEED);
        if (attackSpeed == null) return;
        AttributeModifier modifier = attackSpeed.getModifier(ATTRIBUTE_UUID);
        double value = 0;
        if (modifier != null) {
            value = modifier.getAmount();
            attackSpeed.removeModifier(ATTRIBUTE_UUID);
        }
        value += amplifier > 0 ? EFFECT_STRENGTH * amplifier * 4 : EFFECT_STRENGTH;
        attackSpeed.addTransientModifier(new AttributeModifier(ATTRIBUTE_UUID, ATTRIBUTE_NAME, value, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.CLIENT) return;
        Player player = event.player;
        AttributeInstance attackSpeed = player.getAttribute(Attributes.ATTACK_SPEED);
        if (attackSpeed == null) return;
        AttributeModifier modifier = attackSpeed.getModifier(ATTRIBUTE_UUID);
        if (modifier == null) return;
        if (!player.hasEffect(ModEffects.RAGE.get())) attackSpeed.removeModifier(ATTRIBUTE_UUID);
    }
}
