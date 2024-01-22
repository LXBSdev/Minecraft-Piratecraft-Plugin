package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class DiamondSwordRecipe {
    public static MerchantRecipe getDiamondSwordRecipe() {
        ItemStack result = new ItemStack(Material.DIAMOND_SWORD, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(10));
        return recipe;
    }
}
