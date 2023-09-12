package dev.stormwatch.potionpack;

import com.mojang.logging.LogUtils;
import dev.stormwatch.potionpack.datagen.ModRecipeProvider;
import dev.stormwatch.potionpack.effects.ExpansionEffect;
import dev.stormwatch.potionpack.effects.HasteEffect;
import dev.stormwatch.potionpack.registry.ModEffects;
import dev.stormwatch.potionpack.registry.ModItems;
import dev.stormwatch.potionpack.registry.ModPotions;
import dev.stormwatch.potionpack.registry.PotionRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(PotionPack.MOD_ID)
public class PotionPack
{
    public static final String MOD_ID = "potionpack";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PotionPack() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::addCreative);

        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(HasteEffect.class);
        MinecraftForge.EVENT_BUS.register(ExpansionEffect.class);
    }

    private void gatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        event.getGenerator().addProvider(
                event.includeServer(),
                new ModRecipeProvider(packOutput)
        );
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerPotionRecipes();
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.GOLDEN_BEETROOT);
        }
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.GOLDEN_BEETROOT);
            event.accept(ModItems.ENDEIRIC_CATALYST);
        }
    }

    private void registerPotionRecipes() {
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(ModItems.GOLDEN_BEETROOT.get(), Potions.AWKWARD, ModPotions.BUILDERS_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.REDSTONE, ModPotions.BUILDERS_POTION.get(), ModPotions.BUILDERS_POTION_LONG.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.GLOWSTONE_DUST, ModPotions.BUILDERS_POTION.get(), ModPotions.BUILDERS_POTION_STRONG.get()));

        BrewingRecipeRegistry.addRecipe(new PotionRecipe(ModItems.ENDEIRIC_CATALYST.get(), Potions.AWKWARD, ModPotions.BOTTLED_NEBULA.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.REDSTONE, ModPotions.BOTTLED_NEBULA.get(), ModPotions.BOTTLED_NEBULA_LONG.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.GLOWSTONE_DUST, ModPotions.BOTTLED_NEBULA.get(), ModPotions.BOTTLED_NEBULA_STRONG.get()));

        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.SEA_PICKLE, Potions.AWKWARD, ModPotions.SWIFT_SWIM_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.REDSTONE, ModPotions.SWIFT_SWIM_POTION.get(), ModPotions.SWIFT_SWIM_POTION_LONG.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.GLOWSTONE_DUST, ModPotions.SWIFT_SWIM_POTION.get(), ModPotions.SWIFT_SWIM_POTION_STRONG.get()));

        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.CRIMSON_FUNGUS, Potions.AWKWARD, ModPotions.RAGE_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.REDSTONE, ModPotions.RAGE_POTION.get(), ModPotions.RAGE_POTION_LONG.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.GLOWSTONE_DUST, ModPotions.RAGE_POTION.get(), ModPotions.RAGE_POTION_STRONG.get()));

        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.AMETHYST_SHARD, Potions.AWKWARD, ModPotions.MINERS_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.REDSTONE, ModPotions.MINERS_POTION.get(), ModPotions.MINERS_POTION_LONG.get()));
        BrewingRecipeRegistry.addRecipe(new PotionRecipe(Items.GLOWSTONE_DUST, ModPotions.MINERS_POTION.get(), ModPotions.MINERS_POTION_STRONG.get()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
