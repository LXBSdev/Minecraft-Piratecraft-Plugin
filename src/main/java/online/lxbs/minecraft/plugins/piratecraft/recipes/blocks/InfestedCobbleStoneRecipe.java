package online.lxbs.minecraft.plugins.piratecraft.recipes.blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

public class InfestedCobbleStoneRecipe {
    @NotNull
    public static MerchantRecipe getCobbleStoneRecipe() {
        ItemStack result = new ItemStack(Material.INFESTED_COBBLESTONE, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(new ItemStack(Material.GOLD_INGOT, 5));
        return recipe;
    }
}
