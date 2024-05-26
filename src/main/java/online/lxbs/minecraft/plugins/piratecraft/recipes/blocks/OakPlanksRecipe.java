package online.lxbs.minecraft.plugins.piratecraft.recipes.blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class OakPlanksRecipe {
    public static MerchantRecipe getOakPlanksRecipe() {
        ItemStack result = new ItemStack(Material.OAK_PLANKS, 15);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(new ItemStack(Material.BRICK, 5));
        return recipe;
    }
}
