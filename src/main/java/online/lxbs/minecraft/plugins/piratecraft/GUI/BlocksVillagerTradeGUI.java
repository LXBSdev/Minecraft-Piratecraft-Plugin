package online.lxbs.minecraft.plugins.piratecraft.GUI;

import online.lxbs.minecraft.plugins.piratecraft.recipes.CobbleStoneRecipe;
import online.lxbs.minecraft.plugins.piratecraft.recipes.OakPlanksRecipe;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import java.util.ArrayList;
import java.util.List;

public class BlocksVillagerTradeGUI {

    public static Merchant getBlocksVillagerTradeGUI() {
        Merchant merchant = Bukkit.createMerchant("Blocks");
        List<MerchantRecipe> recipes = new ArrayList<>();
        recipes.add(OakPlanksRecipe.getOakPlanksRecipe());
        recipes.add(CobbleStoneRecipe.getCobbleStoneRecipe());
        merchant.setRecipes(recipes);
        return merchant;
    }
}
