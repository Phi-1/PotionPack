package dev.stormwatch.potionpack.effects;

import dev.stormwatch.potionpack.registry.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HasteEffect extends MobEffect {

    private static final double MINE_SPEED_MODIFIER = 0.4;

    public HasteEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x80649c);
    }

    @SubscribeEvent
    public static void onPlayerMine(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (player.hasEffect(ModEffects.HASTE.get())) {
            int amplifier = player.getEffect(ModEffects.HASTE.get()).getAmplifier();
            event.setNewSpeed((float) (event.getOriginalSpeed() * (1 + (MINE_SPEED_MODIFIER * (1 + amplifier)))));
        }
    }

}
