package dev.stormwatch.potionpack.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        ModRecipes.GOLDEN_BEETROOT.save(writer);
        ModRecipes.ENDEIRIC_CATALYST.save(writer);
    }
}
