package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener implements Listener {
    @EventHandler
    private void onPlayerJoin(@NotNull PlayerJoinEvent event){
        event.getPlayer().teleport(ConfigManager.getLobbySpawn());
    }
}
