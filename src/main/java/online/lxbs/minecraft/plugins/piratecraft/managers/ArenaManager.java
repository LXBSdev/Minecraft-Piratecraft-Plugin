package online.lxbs.minecraft.plugins.piratecraft.managers;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {
    private final List<Arena> arenas = new ArrayList<>();

    public ArenaManager(@NotNull Piratecraft piratecraft) {
        FileConfiguration config = piratecraft.getConfig();

        for (String id : config.getConfigurationSection("arenas.").getKeys(false)) {
            arenas.add(new Arena(piratecraft, Integer.parseInt(id), new Location(
                    Bukkit.getWorld(config.getString("arenas." + id + ".world")),
                    config.getDouble("arenas." + id + ".x"),
                    config.getDouble("arenas." + id + ".y"),
                    config.getDouble("arenas." + id + ".z"),
                    (float) config.getDouble("arenas." + id + ".yawn"),
                    (float) config.getDouble("arenas." + id + ".pitch"))));
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
