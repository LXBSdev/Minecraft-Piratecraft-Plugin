package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import online.lxbs.minecraft.plugins.piratecraft.instance.Game;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    private final Piratecraft piratecraft;

    public PlayerDeathListener(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Arena arena = piratecraft.getArenaManager().getArena(event.getEntity().getPlayer());
        if (arena == null || !arena.getState().equals(GameState.LIVE)) return;

        Game game = arena.getGame();
        game.death(event.getEntity().getPlayer());
    }
}
