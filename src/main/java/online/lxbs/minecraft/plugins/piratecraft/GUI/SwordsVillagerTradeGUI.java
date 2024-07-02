package online.lxbs.minecraft.plugins.piratecraft.GUI;

import online.lxbs.minecraft.plugins.piratecraft.recipes.swords.*;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SwordsVillagerTradeGUI {

    @NotNull
    public static Merchant getSwordsVillagerTradeGUI() {
        Merchant merchant = Bukkit.createMerchant("Swords");
        List<MerchantRecipe> recipes = new ArrayList<>();
        recipes.add(WoodenSwordRecipe.getWoodenSwordRecipe());
        recipes.add(StoneSwordRecipe.getStoneSwordRecipe());
        recipes.add(IronSwordRecipe.getIronSwordRecipe());
        recipes.add(DiamondSwordRecipe.getDiamondSwordRecipe());
        recipes.add(DiamondSwordKnockback1Sharpness1Unbreaking1Recipe.getDiamondSwordKnockback1Sharpness1Unbreaking1Recipe());
        recipes.add(DiamondSwordKnockback2Sharpness2Unbreaking1FireAspect1Recipe.getDiamondSwordKnockback2Sharpness2Unbreaking1FireAspect1Recipe());
        recipes.add(KnockbackStickRecipe.getKnockbackStickRecipe());
        merchant.setRecipes(recipes);
        return merchant;
    }
}
