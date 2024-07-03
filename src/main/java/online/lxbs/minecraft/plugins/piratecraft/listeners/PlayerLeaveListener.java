package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerLeaveListener implements Listener {
    private final Piratecraft piratecraft;

    public PlayerLeaveListener(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @EventHandler
    public void onPlayerLeave(@NotNull PlayerQuitEvent event) {
        Arena arena = piratecraft.getArenaManager().getArena(event.getPlayer());

        if (arena != null) {
            arena.removePlayer(event.getPlayer());
        }
    }
}
