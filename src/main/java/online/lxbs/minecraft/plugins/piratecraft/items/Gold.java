package online.lxbs.minecraft.plugins.piratecraft.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Gold {
    private final Material material;

    public Gold() {
        this.material = Material.GOLD_INGOT;
    }

    public Material getMaterial() {
        return material;
    }

    @NotNull
    public static ItemStack getGold(int amount) {
        ItemStack gold = new ItemStack(Material.GOLD_INGOT, amount);
        ItemMeta meta = gold.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.WHITE + "Gold");
        gold.setItemMeta(meta);
        return gold;
    }
}
