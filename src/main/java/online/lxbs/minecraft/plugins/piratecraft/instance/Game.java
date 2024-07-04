package online.lxbs.minecraft.plugins.piratecraft.instance;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {
    private final Arena arena;
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

            BedLocation location = arena.getBeds().get(team);
            Block block = location.getBlock();
            for (Bed.Part part : Bed.Part.values()) {
                block.setBlockData(Bukkit.createBlockData(Material.RED_BED, (data) -> {
                    ((Bed) data).setPart(part);
                    ((Bed) data).setFacing(location.getFacing());
                }));
                block = block.getRelative(location.getFacing().getOppositeFace());
            }

            Player player = Bukkit.getPlayer(uuid);
            player.setGameMode(GameMode.SURVIVAL);
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
