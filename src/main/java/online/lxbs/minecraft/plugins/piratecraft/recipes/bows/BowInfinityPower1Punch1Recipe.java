package online.lxbs.minecraft.plugins.piratecraft.recipes.bows;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class BowInfinityPower1Punch1Recipe {
    public static MerchantRecipe getBowInfinityPower1Punch1Recipe() {
        ItemStack result = new ItemStack(Material.BOW, 1);
        result.addEnchantment(Enchantment.INFINITY, 1);
        result.addEnchantment(Enchantment.POWER, 1);
        result.addEnchantment(Enchantment.PUNCH, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(7));
        return recipe;
    }
}
