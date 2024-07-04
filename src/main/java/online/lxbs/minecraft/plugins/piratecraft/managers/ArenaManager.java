package online.lxbs.minecraft.plugins.piratecraft.managers;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import online.lxbs.minecraft.plugins.piratecraft.instance.BedLocation;
import online.lxbs.minecraft.plugins.piratecraft.instance.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArenaManager {
    private final List<Arena> arenas = new ArrayList<>();

    public ArenaManager(@NotNull Piratecraft piratecraft) {
        FileConfiguration config = piratecraft.getConfig();

        for (String id : config.getConfigurationSection("arenas.").getKeys(false)) {
            World world = Bukkit.createWorld(new WorldCreator(config.getString("arenas." + id + ".world")));
            HashMap<Team, Location> spawns = new HashMap<>();

            for (String team : config.getConfigurationSection("arenas." + id + ".spawns.").getKeys(false)) {
                spawns.put(Team.valueOf(team.toUpperCase()), new Location(
                        world,
                        config.getDouble("arenas." + id + ".spawns." + team + ".x"),
                        config.getDouble("arenas." + id + ".spawns." + team + ".y"),
                        config.getDouble("arenas." + id + ".spawns." + team + ".z"),
                        (float) config.getDouble("arenas." + id + ".spawns." + team + ".yawn"),
                        (float) config.getDouble("arenas." + id + ".spawns." + team + ".pitch")
                ));
            }

            HashMap<Team, BedLocation> beds = new HashMap<>();

            for (String team : config.getConfigurationSection("arenas." + id + ".beds.").getKeys(false)) {
                beds.put(Team.valueOf(team.toUpperCase()), new BedLocation(
                        world,
                        config.getDouble("arenas." + id + ".beds." + team + ".x"),
                        config.getDouble("arenas." + id + ".beds." + team + ".y"),
                        config.getDouble("arenas." + id + ".beds." + team + ".z"),
                        BlockFace.valueOf(config.getString("arenas." + id + ".spawns." + team + ".facing").toUpperCase())
                ));
            }

            arenas.add(new Arena(piratecraft, Integer.parseInt(id), spawns, beds));
        }
    }

    public List<Arena> getArenas() {
        return arenas;
    }

    public Arena getArena(Player player) {
        for (Arena arena : arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }

    public Arena getArena(int id) {
        for (Arena arena : arenas) {
            if (arena.getId() == id) {
                return arena;
            }
        }
        return null;
    }
}
