package online.lxbs.minecraft.plugins.piratecraft.manager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerManager {

    private final GameManager gameManager;
    private boolean setPvP;

    public PlayerManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void giveKits() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::giveKit);
    }

    public void giveKit(Player player) {
        Inventory inventory = player.getInventory();
        inventory.clear();
    }

    public void setPvP(boolean setPvP) {
        this.setPvP = setPvP;
    }

    public boolean getPvPStatus() {
        return setPvP;
    }
}
