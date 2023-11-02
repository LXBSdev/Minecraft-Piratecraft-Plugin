package online.lxbs.minecraft.plugins.piratecraft;

import online.lxbs.minecraft.plugins.piratecraft.commands.StartCommand;
import online.lxbs.minecraft.plugins.piratecraft.listeners.PlayerInteractionListener;
import online.lxbs.minecraft.plugins.piratecraft.listeners.PlayerJoinListener;
import online.lxbs.minecraft.plugins.piratecraft.manager.GameManager;
import online.lxbs.minecraft.plugins.piratecraft.manager.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Piratecraft extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        super.onEnable();

        this.gameManager = new GameManager(this);

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractionListener(this), this);

        getCommand("start").setExecutor(new StartCommand(gameManager));
    }

    @Override
    public void onDisable() {
        super.onDisable();

        gameManager.cleanup();
    }
}
