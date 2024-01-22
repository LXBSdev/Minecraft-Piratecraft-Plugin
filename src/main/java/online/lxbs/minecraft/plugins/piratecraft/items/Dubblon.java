package online.lxbs.minecraft.plugins.piratecraft.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Dubblon {
    private final Material material;

    public Dubblon() {
        this.material = Material.BRICK;
    }

    public Material getMaterial() {
        return material;
    }

    public static ItemStack getDubblon(int amount) {
        ItemStack dubblon = new ItemStack(Material.BRICK, amount);
        ItemMeta meta = dubblon.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.WHITE + "Dubblon");
        dubblon.setItemMeta(meta);
        return dubblon;
    }
}
