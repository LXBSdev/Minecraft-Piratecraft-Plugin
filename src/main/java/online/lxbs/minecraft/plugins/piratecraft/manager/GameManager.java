package online.lxbs.minecraft.plugins.piratecraft.manager;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.tasks.GameStartCountdownTask;

public class GameManager {

    private final Piratecraft plugin;
    private GameState gameState = GameState.LOBBY;
    private final PlayerManager playerManager;
    private GameStartCountdownTask gameStartCountdownTask;

    public GameManager(Piratecraft plugin) {
        this.plugin = plugin;
        this.playerManager = new PlayerManager(this);
    }

    public void setGameState(GameState gameState) {
        if (this.gameState == GameState.ACTIVE && gameState == GameState.STARTING) return;
        this.gameState = gameState;
        switch (gameState) {
            case ACTIVE:
                if (this.gameStartCountdownTask != null) this.gameStartCountdownTask.cancel();
                getPlayerManager().giveKits();
            case STARTING:
                this.gameStartCountdownTask = new GameStartCountdownTask(this);
                this.gameStartCountdownTask.runTaskTimer(plugin, 0, 20);
                break;
        }
    }

    public void cleanup() {

    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public  GameState getGameState() {
        return gameState;
    }
}
