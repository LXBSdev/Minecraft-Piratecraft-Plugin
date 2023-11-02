package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractionListener implements Listener {

    public PlayerInteractionListener(Piratecraft plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private PlayerManager playerManager;

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof Player && !playerManager.getPvPStatus()) {
            event.setCancelled(true);
        } else if (entity instanceof Player && playerManager.getPvPStatus()) {
            return;
        }
    }
}
