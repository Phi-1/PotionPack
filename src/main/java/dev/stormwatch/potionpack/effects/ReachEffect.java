package dev.stormwatch.potionpack.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;

public class ReachEffect extends MobEffect {

    public static final String ATTRIBUTE_NAME = "potionpack_reach";
    public static final String ATTRIBUTE_UUID = "ec443e52-876a-4b79-87f9-3d5c8e3f83b3";

    private static final double EFFECT_STRENGTH = 0.2;

    public ReachEffect() {
        super(MobEffectCategory.BENEFICIAL, 12404736);
        this.addAttributeModifier(ForgeMod.BLOCK_REACH.get(), ATTRIBUTE_UUID, EFFECT_STRENGTH, AttributeModifier.Operation.MULTIPLY_BASE);
    }

}
