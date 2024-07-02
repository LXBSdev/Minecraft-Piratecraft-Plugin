package online.lxbs.minecraft.plugins.piratecraft.instance;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {
    private Arena arena;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        this.points = new HashMap<>();
    }

    public void start(){
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! The object is to destroy the opponents bed");

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
        }
    }

    public void addPoint(Player player) {
        int playerPoints = this.points.get(player.getUniqueId()) + 1;
        
        this.points.replace(player.getUniqueId(), playerPoints);
    }

    public void addPoints(Player player, int points) {
        int playerPoints = this.points.get(player.getUniqueId()) + points;

        this.points.replace(player.getUniqueId(), playerPoints);
    }
}
