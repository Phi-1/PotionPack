package dev.stormwatch.potionpack.registry;

import dev.stormwatch.potionpack.PotionPack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, PotionPack.MOD_ID);

    public static final RegistryObject<Potion> BUILDERS_POTION = POTIONS.register("builders_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.REACH.get(), 6000, 0)));
    public static final RegistryObject<Potion> BUILDERS_POTION_LONG = POTIONS.register(
            "builders_potion_long",
            () -> new Potion(new MobEffectInstance(ModEffects.REACH.get(), 14400, 0)));
    public static final RegistryObject<Potion> BUILDERS_POTION_STRONG = POTIONS.register(
            "builders_potion_strong",
            () -> new Potion(new MobEffectInstance(ModEffects.REACH.get(), 6000, 1)));

    public static final RegistryObject<Potion> BOTTLED_NEBULA = POTIONS.register("bottled_nebula",
            () -> new Potion(new MobEffectInstance(ModEffects.EXPANSION.get(), 9600, 0)));
    public static final RegistryObject<Potion> BOTTLED_NEBULA_LONG = POTIONS.register(
            "bottled_nebula_long",
            () -> new Potion(new MobEffectInstance(ModEffects.EXPANSION.get(), 36000, 0)));
    public static final RegistryObject<Potion> BOTTLED_NEBULA_STRONG = POTIONS.register(
            "bottled_nebula_strong",
            () -> new Potion(new MobEffectInstance(ModEffects.EXPANSION.get(), 9600, 1)));

    public static final RegistryObject<Potion> SWIFT_SWIM_POTION = POTIONS.register(
            "swift_swim_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SWIFT_SWIM.get(), 3600, 0)));
    public static final RegistryObject<Potion> SWIFT_SWIM_POTION_LONG = POTIONS.register(
            "swift_swim_potion_long",
            () -> new Potion(new MobEffectInstance(ModEffects.SWIFT_SWIM.get(), 9600, 0)));
    public static final RegistryObject<Potion> SWIFT_SWIM_POTION_STRONG = POTIONS.register(
            "swift_swim_potion_strong",
            () -> new Potion(new MobEffectInstance(ModEffects.SWIFT_SWIM.get(), 3600, 1)));
//
//
//    public static final RegistryObject<Potion> RAGE_POTION = POTIONS.register(
//            "rage_potion",
//            () -> new Potion(new MobEffectInstance(ModEffects.RAGE.get(), 600, 0)));
//
//    public static final RegistryObject<Potion> RAGE_POTION_LONG = POTIONS.register(
//            "rage_potion_long",
//            () -> new Potion(new MobEffectInstance(ModEffects.RAGE.get(), 1800, 0)));
//
//    public static final RegistryObject<Potion> RAGE_POTION_STRONG = POTIONS.register(
//            "rage_potion_strong",
//            () -> new Potion(new MobEffectInstance(ModEffects.RAGE.get(), 600, 1)));
//
//
//    public static final RegistryObject<Potion> CALM_POTION = POTIONS.register(
//            "calm_potion",
//            () -> new Potion(new MobEffectInstance(ModEffects.CALM.get(), 600, 0)));
//
//    public static final RegistryObject<Potion> CALM_POTION_LONG = POTIONS.register(
//            "calm_potion_long",
//            () -> new Potion(new MobEffectInstance(ModEffects.CALM.get(), 1800, 0)));
//
//    public static final RegistryObject<Potion> CALM_POTION_STRONG = POTIONS.register(
//            "calm_potion_strong",
//            () -> new Potion(new MobEffectInstance(ModEffects.CALM.get(), 600, 1)));
//
//
//    public static final RegistryObject<Potion> RESPLENDENCE_POTION = POTIONS.register(
//            "resplendence_potion",
//            () -> new Potion(new MobEffectInstance(ModEffects.RESPLENDENCE.get(), 3600, 0)));
//
//    public static final RegistryObject<Potion> RESPLENDENCE_POTION_LONG = POTIONS.register(
//            "resplendence_potion_long",
//            () -> new Potion(new MobEffectInstance(ModEffects.RESPLENDENCE.get(), 6000, 0)));
//
//    public static final RegistryObject<Potion> RESPLENDENCE_POTION_STRONG = POTIONS.register(
//            "resplendence_potion_strong",
//            () -> new Potion(new MobEffectInstance(ModEffects.RESPLENDENCE.get(), 3600, 1)));

    public static void register(IEventBus modEventBus) {
        POTIONS.register(modEventBus);
    }

}
