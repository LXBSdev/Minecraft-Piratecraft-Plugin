package online.lxbs.minecraft.plugins.piratecraft.tasks;

import online.lxbs.minecraft.plugins.piratecraft.managers.GameManager;
import online.lxbs.minecraft.plugins.piratecraft.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdownTask extends BukkitRunnable {
    private final GameManager gameManager;

    public GameStartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private int timeLeft = 10;

    @Override
    public void run() {
        timeLeft--;

        if (timeLeft == 10) {
            Bukkit.broadcastMessage("Game starts in " + timeLeft);
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle(String.valueOf(timeLeft), null, 0, 1, 0);
            }
        }

        if (timeLeft == 5) {
            Bukkit.broadcastMessage("Game starts in " + timeLeft);
        }

        if (timeLeft <= 5) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle(String.valueOf(timeLeft), null, 0, 2, 0);
            }
        }

        if (timeLeft <= 0) {
            cancel();
            gameManager.setGameState(GameState.LIVE);
            return;
        }
    }
}
