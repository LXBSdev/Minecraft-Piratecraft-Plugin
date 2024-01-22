package online.lxbs.minecraft.plugins.piratecraft.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KnockbackStick {
    private final Material material;

    public KnockbackStick() {
        this.material = Material.STICK;
    }

    public Material getMaterial() {
        return material;
    }

    public static ItemStack getKnockbackStick(int amount) {
        ItemStack knockbackStick = new ItemStack(Material.STICK, amount);
        ItemMeta meta = knockbackStick.getItemMeta();
        knockbackStick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        assert meta != null;
        meta.setDisplayName(ChatColor.WHITE + "Knockback Stick");
        knockbackStick.setItemMeta(meta);
        return knockbackStick;
    }
}
