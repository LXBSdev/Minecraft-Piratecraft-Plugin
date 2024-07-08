package online.lxbs.minecraft.plugins.piratecraft.instance;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Game {
    private final Arena arena;
    private final HashMap<UUID, Integer> points;
    private final HashMap<UUID, Team> teams;
    private final HashMap<Team, Boolean> existingDiamondBlocks;
    private final List<BukkitTask> tasks;
    private final List<UUID> alivePlayers;

    public Game(Arena arena) {
        this.arena = arena;
        this.points = new HashMap<>();
        this.teams = new HashMap<>();
        this.existingDiamondBlocks = new HashMap<>();
        this.tasks = new ArrayList<>();
        this.alivePlayers = new ArrayList<>();
    }

    public void start(){
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! The object is to destroy the opponents bed");

        for (int i = 0; i < arena.getPlayers().size(); i++) {
            UUID uuid = arena.getPlayers().get(i);
            Team team = Team.values()[i];
            points.put(uuid, 0);
            teams.put(uuid, team);
            existingDiamondBlocks.put(team, true);

            Location location = arena.getDiamondBlocks().get(team);
            Block block = location.getBlock();
            block.setBlockData(Bukkit.createBlockData(Material.DIAMOND_BLOCK));
            block.setMetadata("team", new FixedMetadataValue(arena.getPiratecraft(), team.getName()));

            Player player = Bukkit.getPlayer(uuid);
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
            player.teleport(arena.getSpawns().get(team));
            alivePlayers.add(uuid);
        }

        tasks.add(Bukkit.getScheduler().runTaskTimer(arena.getPiratecraft(), () -> {
            for (UUID uuid : alivePlayers) {
                if (Bukkit.getPlayer(uuid).getLocation().getY() <= -64) {
                    death(Bukkit.getPlayer(uuid));
                }
            }
        }, 4, 4));
    }

    public void cancelTasks() {
        for (BukkitTask task : tasks) {
            task.cancel();
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

    public boolean destroyDiamondBlock(Team team, Player player) {
        if (teams.get(player.getUniqueId()) == team) {
            return true;
        }
        arena.sendMessage(player.getName() + " has broken " + team.getName() + "'s diamond block!");
        existingDiamondBlocks.remove(team, false);
        return false;
    }

    public void death(Player player) {
        Team team = teams.get(player.getUniqueId());
        if (existingDiamondBlocks.get(team)) {
            player.teleport(arena.getSpawns().get(team));
            arena.sendMessage(ChatColor.RED + player.getName() + " has died");
        } else {
            player.setGameMode(GameMode.SPECTATOR);
            arena.sendMessage(ChatColor.RED + player.getName() + " has died and will not respawn");
            alivePlayers.remove(player.getUniqueId());

            if (alivePlayers.size() == 1) {
                arena.sendMessage(ChatColor.GREEN + Bukkit.getPlayer(alivePlayers.get(0)).getName() + " has won!");
                arena.reset(true);
            }
        }
    }
}
