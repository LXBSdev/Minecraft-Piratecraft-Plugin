package online.lxbs.minecraft.plugins.piratecraft;

import online.lxbs.minecraft.plugins.piratecraft.commands.ArenaCommand;
import online.lxbs.minecraft.plugins.piratecraft.commands.BowsCommand;
import online.lxbs.minecraft.plugins.piratecraft.commands.SwordsCommand;
import online.lxbs.minecraft.plugins.piratecraft.listeners.*;
import online.lxbs.minecraft.plugins.piratecraft.listeners.villagers.BlocksVillagerInteractionListener;
import online.lxbs.minecraft.plugins.piratecraft.listeners.villagers.BowsVillagerInteractionListener;
import online.lxbs.minecraft.plugins.piratecraft.listeners.villagers.SwordsVillagerInteractionListener;
import online.lxbs.minecraft.plugins.piratecraft.managers.ArenaManager;
import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Piratecraft extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);

        this.arenaManager = new ArenaManager(this);

        getCommand("swords").setExecutor(new SwordsCommand());
        getCommand("bows").setExecutor(new BowsCommand());
        getCommand("arena").setExecutor(new ArenaCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractionListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);
        Bukkit.getPluginManager().registerEvents(new BlocksVillagerInteractionListener(), this);
        Bukkit.getPluginManager().registerEvents(new BowsVillagerInteractionListener(), this);
        Bukkit.getPluginManager().registerEvents(new SwordsVillagerInteractionListener(), this);
        Bukkit.getPluginManager().registerEvents(new DiamondBlockBreakListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(this), this);

        System.out.println("The Piratecraft plugin has been enabled!");
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    @Override
    public void onDisable() {
        System.out.println("The Piratecraft plugin has been disabled!");
    }
}
