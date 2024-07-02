package online.lxbs.minecraft.plugins.piratecraft;

import online.lxbs.minecraft.plugins.piratecraft.commands.BowsCommand;
import online.lxbs.minecraft.plugins.piratecraft.commands.SwordsCommand;
import online.lxbs.minecraft.plugins.piratecraft.listeners.PlayerInteractionListener;
import online.lxbs.minecraft.plugins.piratecraft.listeners.PlayerJoinListener;
import online.lxbs.minecraft.plugins.piratecraft.managers.ArenaManager;
import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import online.lxbs.minecraft.plugins.piratecraft.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Piratecraft extends JavaPlugin {

    private GameManager gameManager;
    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        super.onEnable();

        this.gameManager = new GameManager(this);
        this.gameManager = new GameManager(this);
        this.arenaManager = new ArenaManager(this);

        //getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("swords").setExecutor(new SwordsCommand());
        getCommand("bows").setExecutor(new BowsCommand());

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractionListener(this), this);
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    @Override
    public void onDisable() {
        super.onDisable();

        gameManager.cleanup();
    }
}
