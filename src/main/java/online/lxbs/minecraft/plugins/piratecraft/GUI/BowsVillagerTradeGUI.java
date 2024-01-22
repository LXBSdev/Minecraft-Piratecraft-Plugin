package online.lxbs.minecraft.plugins.piratecraft.GUI;

import online.lxbs.minecraft.plugins.piratecraft.recipes.bows.*;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class BowsVillagerTradeGUI {

    public static Merchant getBowsVillagerTradeGUI() {
        Merchant merchant = Bukkit.createMerchant("Bows");
        List<MerchantRecipe> recipes = new ArrayList<>();
        recipes.add(BowInfinityRecipe.getBowInfinityRecipe());
        recipes.add(BowInfinityPower1Recipe.getBowInfinityPower1Recipe());
        recipes.add(BowInfinityPower1Punch1Recipe.getBowInfinityPower1Punch1Recipe());
        recipes.add(BowInfinityPower1Punch2FlameRecipe.getBowInfinityPower1Punch2FlameRecipe());
        recipes.add(BowInfinityPower1Punch2FlameUnbreaking1Recipe.getBowInfinityPower1Punch2FlameUnbreaking1Recipe());
        recipes.add(BowInfinityPunch25Recipe.getBowInfinityPunch25Recipe());
        recipes.add(ArrowRecipe.getArrowRecipe());
        recipes.add(SpectralArrowRecipe.getSpectralArrowRecipe());
        merchant.setRecipes(recipes);
        return merchant;
    }
}
