package online.lxbs.minecraft.plugins.piratecraft.commands;

import online.lxbs.minecraft.plugins.piratecraft.GUI.SwordsVillagerTradeGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class SwordsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String string, @Nonnull String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can run this command.");
            return true;
        }
        Player player = (Player) commandSender;
        player.openMerchant(SwordsVillagerTradeGUI.getSwordsVillagerTradeGUI(), true);
        return true;
    }
}
