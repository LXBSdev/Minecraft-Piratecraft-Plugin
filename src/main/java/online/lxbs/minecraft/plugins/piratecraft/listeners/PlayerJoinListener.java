package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.managers.GameManager;
import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener(Piratecraft plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private GameManager gameManager;
    private PlayerManager playerManager;

    @EventHandler
    private void onPlayerJoin(@NotNull PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (gameManager.getGameState() == GameState.RECRUITING) {
            player.setGameMode(GameMode.ADVENTURE);
            playerManager.setPvP(false);
            if (Bukkit.getOnlinePlayers().size() >= 8 && Bukkit.getOnlinePlayers().size() <= 16) {
                gameManager.setGameState(GameState.COUNTDOWN);
            }
        } else if (gameManager.getGameState() == GameState.COUNTDOWN) {
            gameManager.setGameState(GameState.RECRUITING);
        } else if (gameManager.getGameState() == GameState.LIVE) {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }

    @EventHandler
    private void onPlayerLeave(PlayerQuitEvent event) {
        if (gameManager.getGameState() != GameState.LIVE) {
            if (Bukkit.getOnlinePlayers().size() < 8) {
                gameManager.setGameState(GameState.RECRUITING);
            }
        }
    }
}
