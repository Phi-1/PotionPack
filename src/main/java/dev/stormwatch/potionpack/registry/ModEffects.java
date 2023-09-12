package dev.stormwatch.potionpack.registry;

import dev.stormwatch.potionpack.PotionPack;
import dev.stormwatch.potionpack.effects.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PotionPack.MOD_ID);

    public static final RegistryObject<MobEffect> REACH = EFFECTS.register("reach", ReachEffect::new);
    public static final RegistryObject<MobEffect> EXPANSION = EFFECTS.register("expansion", ExpansionEffect::new);
    public static final RegistryObject<MobEffect> SWIFT_SWIM = EFFECTS.register("swift_swim", SwiftSwimEffect::new);
    public static final RegistryObject<MobEffect> RAGE = EFFECTS.register("rage", RageEffect::new);
    public static final RegistryObject<MobEffect> HASTE = EFFECTS.register("haste", HasteEffect::new);

    public static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }

}
