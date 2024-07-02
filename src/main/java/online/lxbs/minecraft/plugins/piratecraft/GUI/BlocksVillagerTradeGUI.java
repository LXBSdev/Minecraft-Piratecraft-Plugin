package online.lxbs.minecraft.plugins.piratecraft.GUI;

import online.lxbs.minecraft.plugins.piratecraft.recipes.blocks.CobbleStoneRecipe;
import online.lxbs.minecraft.plugins.piratecraft.recipes.blocks.OakPlanksRecipe;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BlocksVillagerTradeGUI {

    @NotNull
    public static Merchant getBlocksVillagerTradeGUI() {
        Merchant merchant = Bukkit.createMerchant("Blocks");
        List<MerchantRecipe> recipes = new ArrayList<>();
        recipes.add(OakPlanksRecipe.getOakPlanksRecipe());
        recipes.add(CobbleStoneRecipe.getCobbleStoneRecipe());
        merchant.setRecipes(recipes);
        return merchant;
    }
}
