package online.lxbs.minecraft.plugins.piratecraft.recipes.swords;

import online.lxbs.minecraft.plugins.piratecraft.items.Gold;
import online.lxbs.minecraft.plugins.piratecraft.items.KnockbackStick;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class KnockbackStickRecipe {
    public static MerchantRecipe getKnockbackStickRecipe() {
        ItemStack result = KnockbackStick.getKnockbackStick(1);

        MerchantRecipe recipe = new MerchantRecipe(result, 10000);
        recipe.addIngredient(Gold.getGold(3));
        return recipe;
    }
}
