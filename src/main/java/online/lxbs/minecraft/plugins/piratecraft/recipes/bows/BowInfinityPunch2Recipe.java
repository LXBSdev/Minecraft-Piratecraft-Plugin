package online.lxbs.minecraft.plugins.piratecraft.recipes.bows;

import online.lxbs.minecraft.plugins.piratecraft.items.ValuePaper;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class BowInfinityPunch2Recipe {
    public static MerchantRecipe getBowInfinityPunch2Recipe() {
        ItemStack result = new ItemStack(Material.BOW, 1);
        result.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        result.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(ValuePaper.getValuePaper(1));
        return recipe;
    }
}
