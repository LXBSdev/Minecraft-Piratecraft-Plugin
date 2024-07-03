package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class ConnectListener implements Listener {
    private final Piratecraft piratecraft;

    public ConnectListener(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        event.getPlayer().teleport(ConfigManager.getLobbySpawn());
    }

    @EventHandler
    public void onPlayerQuit(@NotNull PlayerQuitEvent event) {
        Arena arena = piratecraft.getArenaManager().getArena(event.getPlayer());

        if (arena != null) {
            arena.removePlayer(event.getPlayer());
        }
    }
}
