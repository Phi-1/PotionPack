package dev.stormwatch.potionpack.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

import javax.annotation.Nonnull;

public class PotionRecipe implements IBrewingRecipe {

    private final Item ingredient;
    private final Potion input;
    private final Potion output;

    public PotionRecipe(Item ingredient, Potion input, Potion output) {
        this.ingredient = ingredient;
        this.input = input;
        this.output = output;
    }

    @Override
    public boolean isInput(@Nonnull ItemStack input) {
        return PotionUtils.getPotion(input) == this.input;
    }

    @Override
    public boolean isIngredient(@Nonnull ItemStack ingredient) {
        return ingredient.getItem() == this.ingredient;
    }

    @Nonnull
    @Override
    public ItemStack getOutput(@Nonnull ItemStack input, @Nonnull ItemStack ingredient) {
        if (isInput(input) && isIngredient(ingredient)) {
            ItemStack output = PotionUtils.setPotion(new ItemStack(Items.POTION), this.output);
            return output;
        }
        return ItemStack.EMPTY;
    }

}