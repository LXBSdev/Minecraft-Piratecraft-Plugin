package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerInteractionListener implements Listener {
    private final Piratecraft piratecraft;

    public PlayerInteractionListener(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @EventHandler
    public void onPlayerInteraction(@NotNull PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player)) return;
        Player player = event.getPlayer();

        if (piratecraft.getArenaManager().getArena(player).getState() != GameState.LIVE) {
            event.setCancelled(true);
        }
    }
}
