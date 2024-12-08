package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.ValuePaper;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class DiamondSwordKnockback2Sharpness2Unbreaking1FireAspect1Recipe {
    public static MerchantRecipe getDiamondSwordKnockback2Sharpness2Unbreaking1FireAspect1Recipe() {
        ItemStack result = new ItemStack(Material.DIAMOND_SWORD, 1);
        result.addEnchantment(Enchantment.KNOCKBACK, 2);
        result.addEnchantment(Enchantment.SHARPNESS, 2);
        result.addEnchantment(Enchantment.UNBREAKING, 1);
        result.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(ValuePaper.getValuePaper(10));
        return recipe;
    }
}
