package dev.stormwatch.potionpack.registry;

import dev.stormwatch.potionpack.PotionPack;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PotionPack.MOD_ID);

    public static final RegistryObject<Item> ENDEIRIC_CATALYST = ITEMS.register("endeiric_catalyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_BEETROOT = ITEMS.register("golden_beetroot",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().alwaysEat().nutrition(4).saturationMod(1.2f)
                            .build())));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
