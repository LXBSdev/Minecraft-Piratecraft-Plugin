package online.lxbs.minecraft.plugins.piratecraft.recipes.bows;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class BowInfinityPower1Punch2FlameUnbreaking1Recipe {
    public static MerchantRecipe getBowInfinityPower1Punch2FlameUnbreaking1Recipe() {
        ItemStack result = new ItemStack(Material.BOW, 1);
        result.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        result.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        result.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        result.addEnchantment(Enchantment.ARROW_FIRE, 1);
        result.addEnchantment(Enchantment.DURABILITY, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(20));
        return recipe;
    }
}
