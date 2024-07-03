package online.lxbs.minecraft.plugins.piratecraft;

import online.lxbs.minecraft.plugins.piratecraft.commands.ArenaCommand;
import online.lxbs.minecraft.plugins.piratecraft.commands.BowsCommand;
import online.lxbs.minecraft.plugins.piratecraft.commands.SwordsCommand;
import online.lxbs.minecraft.plugins.piratecraft.listeners.*;
import online.lxbs.minecraft.plugins.piratecraft.managers.ArenaManager;
import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Piratecraft extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        super.onEnable();

        ConfigManager.setupConfig(this);

        this.arenaManager = new ArenaManager(this);

        getCommand("swords").setExecutor(new SwordsCommand());
        getCommand("bows").setExecutor(new BowsCommand());
        getCommand("arena").setExecutor(new ArenaCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractionListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
