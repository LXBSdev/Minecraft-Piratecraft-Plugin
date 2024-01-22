package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.Dubblon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class WoodenSwordRecipe {
    public static MerchantRecipe getWoodenSwordRecipe() {
        ItemStack result = new ItemStack(Material.WOODEN_SWORD, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Dubblon.getDubblon(5));
        return recipe;
    }
}
