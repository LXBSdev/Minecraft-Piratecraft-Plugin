package online.lxbs.minecraft.plugins.piratecraft.instance;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {
    private Arena arena;
    private HashMap<UUID, Team> teams;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        this.points = new HashMap<>();
    }

    public void start(){
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! The object is to destroy the opponents bed");

        for (int i = 0; i < arena.getPlayers().size(); i++) {
            UUID uuid = arena.getPlayers().get(i);
            Team team = Team.values()[i];
            points.put(uuid, 0);
            teams.put(uuid, team);
            Bukkit.getPlayer(uuid).teleport(arena.getSpawns().get(team));
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
