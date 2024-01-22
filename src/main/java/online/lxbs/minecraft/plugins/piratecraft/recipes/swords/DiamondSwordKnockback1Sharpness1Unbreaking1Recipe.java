package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class DiamondSwordKnockback1Sharpness1Unbreaking1Recipe {
    public static MerchantRecipe getDiamondSwordKnockback1Sharpness1Unbreaking1Recipe() {
        ItemStack result = new ItemStack(Material.DIAMOND_SWORD, 1);
        result.addEnchantment(Enchantment.KNOCKBACK, 1);
        result.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        result.addEnchantment(Enchantment.DURABILITY, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(20));
        return recipe;
    }
}
