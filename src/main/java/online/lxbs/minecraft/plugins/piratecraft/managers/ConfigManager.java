package online.lxbs.minecraft.plugins.piratecraft.managers;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private static FileConfiguration config;

    public static void setupConfig(Piratecraft minigame) {
        ConfigManager.config = minigame.getConfig();
        minigame.saveDefaultConfig();
    }

    public static int getRequiredPlayers() {
        return config.getInt("required-players");
    }

    public static int getCountdownSeconds() {
        return config.getInt("countdown-seconds");
    }

    public static Location getSpawnLocation() {
        return new Location(
                Bukkit.getWorld(config.getString("lobby-spawn.world")),
                config.getDouble("lobby-spawn.x"),
                config.getDouble("lobby-spawn.y"),
                config.getDouble("lobby-spawn.z"),
                (float) config.getDouble("lobby-spawn.yawn"),
                (float) config.getDouble("lobby-spawn.pitch")
        );
    }
}