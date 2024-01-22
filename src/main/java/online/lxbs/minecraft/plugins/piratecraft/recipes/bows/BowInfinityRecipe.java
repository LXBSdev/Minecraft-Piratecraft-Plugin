package online.lxbs.minecraft.plugins.piratecraft.recipes.bows;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class BowInfinityRecipe {
    public static MerchantRecipe getBowInfinityRecipe() {
        ItemStack result = new ItemStack(Material.BOW, 1);
        result.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(3));
        return recipe;
    }
}
