package online.lxbs.minecraft.plugins.piratecraft.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ValuePaper {
    private final Material material;

    public ValuePaper() {
        this.material = Material.PAPER;
    }

    public Material getMaterial() {
        return material;
    }

    public Material getType() {
        return material;
    }

    public static ItemStack getValuePaper(int amount) {
        ItemStack dubblon = new ItemStack(Material.PAPER, amount);
        ItemMeta meta = dubblon.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.WHITE + "Value Paper");
        dubblon.setItemMeta(meta);
        return dubblon;
    }
}
