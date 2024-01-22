package online.lxbs.minecraft.plugins.piratecraft.recipes.bows;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class SpectralArrowRecipe {
    public static MerchantRecipe getSpectralArrowRecipe() {
        ItemStack result = new ItemStack(Material.SPECTRAL_ARROW, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(5));
        return recipe;
    }
}
