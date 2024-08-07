package online.lxbs.minecraft.plugins.piratecraft.instance;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Arena {
    private final Piratecraft piratecraft;
    private final int id;
    private final List<UUID> players;
    private final HashMap<Team, Location> spawns;
    private final HashMap<Team, Location> diamondBlocks;
    private GameState state;
    private Countdown countdown;
    private Game game;

    public Arena(Piratecraft piratecraft, int id, HashMap<Team, Location> spawns, HashMap<Team, Location> diamondBlocks) {
        this.piratecraft = piratecraft;
        this.id = id;
        this.spawns = spawns;
        this.diamondBlocks = diamondBlocks;
        this.state = GameState.RECRUITING;
        this.players = new ArrayList<>();
        this.countdown = new Countdown(piratecraft, this);
        this.game = new Game(this);
    }

    public void start() {
        game.start();
    }

    public void reset(boolean kickPlayers) {
        if (kickPlayers) {
            Location location = ConfigManager.getLobbySpawn();
            for (UUID uuid : players) {
                Bukkit.getPlayer(uuid).teleport(location);
            }
            players.clear();
        }

        sendTitle("", "");
        state = GameState.RECRUITING;
        countdown.cancel();
        countdown = new Countdown(piratecraft, this);
        game.cancelTasks();
        game = new Game(this);
    }

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public void sendTitle(String title, String subtitle) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendTitle(title, subtitle);
        }
    }

    public void addPlayer(@NotNull Player player) {
        players.add(player.getUniqueId());

        if (state.equals(GameState.RECRUITING)
                && players.size() >= ConfigManager.getRequiredPlayers()
                && players.size() % 1 == 0) {
            player.setGameMode(GameMode.ADVENTURE);
            countdown.start();
        }
    }

    public void removePlayer(@NotNull Player player) {
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getLobbySpawn());
        player.sendTitle("", "");

        if (state.equals(GameState.COUNTDOWN) && players.size() < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "There is not enough players. Countdown stopped.");
            reset(false);
            return;
        }

        if (state.equals(GameState.LIVE) && players.size() < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "The game has ended as too many players left.");
            reset(false);
        }
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public int getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public HashMap<Team, Location> getSpawns() {
        return spawns;
    }

    public HashMap<Team, Location> getDiamondBlocks() {
        return diamondBlocks;
    }

    public Piratecraft getPiratecraft() {
        return piratecraft;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
