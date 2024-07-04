package online.lxbs.minecraft.plugins.piratecraft.managers;

import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class ConfigManager {
    private static FileConfiguration config;

    public static final int REQUIRED_PLAYERS = config.getInt("required-players");
    public static final int MAXIMUM_PLAYERS = config.getInt("max-players");
    public static final int COUNTDOWN_SECONDS = config.getInt("countdown-seconds");
    public static final Location LOBBY_SPAWN = new Location(
            Bukkit.getWorld(config.getString("lobby-spawn.world")),
            config.getDouble("lobby-spawn.x"),
            config.getDouble("lobby-spawn.y"),
            config.getDouble("lobby-spawn.z"),
            (float) config.getDouble("lobby-spawn.yawn"),
            (float) config.getDouble("lobby-spawn.pitch")
    );

    public static void setupConfig(@NotNull Piratecraft piratecraft) {
        ConfigManager.config = piratecraft.getConfig();
        piratecraft.saveDefaultConfig();
    }
}
