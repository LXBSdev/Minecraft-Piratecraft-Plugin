package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.Dubblon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class IronSwordRecipe {
    public static MerchantRecipe getIronSwordRecipe() {
        ItemStack result = new ItemStack(Material.IRON_SWORD, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Dubblon.getDubblon(20));
        return recipe;
    }
}
