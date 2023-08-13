package dev.stormwatch.potionpack.datagen;

import dev.stormwatch.potionpack.registry.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.PlacedBlockTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class ModRecipes {

    public static final ShapedRecipeBuilder GOLDEN_BEETROOT = ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ModItems.GOLDEN_BEETROOT.get())
            .pattern("GGG")
            .pattern("GBG")
            .pattern("GGG")
            .define('G', Items.GOLD_NUGGET)
            .define('B', Items.BEETROOT)
            .unlockedBy("placed_brewing_stand", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.BREWING_STAND));

    public static final ShapedRecipeBuilder ENDEIRIC_CATALYST = ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ModItems.ENDEIRIC_CATALYST.get())
            .pattern(" G ")
            .pattern("GEG")
            .pattern(" G ")
            .define('G', Items.GLOWSTONE_DUST)
            .define('E', Items.ENDER_PEARL)
            .unlockedBy("placed_brewing_stand", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.BREWING_STAND));

}
