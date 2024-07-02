package online.lxbs.minecraft.plugins.piratecraft.commands;

import online.lxbs.minecraft.plugins.piratecraft.managers.GameManager;
import online.lxbs.minecraft.plugins.piratecraft.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;

public class StartCommand implements CommandExecutor {

    private final GameManager gameManager;

    public StartCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public boolean onCommand(@Nonnull CommandSender commandSender,@Nonnull Command command,@Nonnull String string,@Nonnull String[] args) {
        gameManager.setGameState(GameState.COUNTDOWN);

        return false;
    }
}
