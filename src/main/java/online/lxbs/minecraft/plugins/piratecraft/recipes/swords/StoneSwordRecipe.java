package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.Dubblon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class StoneSwordRecipe {
    public static MerchantRecipe getStoneSwordRecipe() {
        ItemStack result = new ItemStack(Material.STONE_SWORD, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Dubblon.getDubblon(10));
        return recipe;
    }
}
