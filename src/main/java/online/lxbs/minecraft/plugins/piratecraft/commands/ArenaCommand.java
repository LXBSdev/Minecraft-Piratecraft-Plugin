package online.lxbs.minecraft.plugins.piratecraft.commands;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArenaCommand implements CommandExecutor {
    private final Piratecraft piratecraft;

    public ArenaCommand(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;

        if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
            player.sendMessage(ChatColor.GREEN + "These are the available arenas:");

            for (Arena arena : piratecraft.getArenaManager().getArenas()) {
                player.sendMessage(ChatColor.GREEN + "- " + arena.getId() + " (" + arena.getState().name() + ")");
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
            Arena arena = piratecraft.getArenaManager().getArena(player);
            if (arena != null) {
                player.sendMessage(ChatColor.RED + "You left the arena.");
                arena.removePlayer(player);
            } else {
                player.sendMessage(ChatColor.RED + "You are not in an arena.");
            }
        } else if (args.length == 2 && args[0].equalsIgnoreCase("join")) {
            if (piratecraft.getArenaManager().getArena(player) != null) {
                player.sendMessage(ChatColor.RED + "You are already playing in an arena.");
                return false;
            }

            int id;
            try {
                id = Integer.parseInt(args[1]);
            } catch (NumberFormatException exception) {
                player.sendMessage(ChatColor.RED + "You specified an invalid arena id.");
                return false;
            }

            if (id >= 0 && id < piratecraft.getArenaManager().getArenas().size()) {
                Arena arena = piratecraft.getArenaManager().getArena(id);

                if (arena.getState() == GameState.RECRUITING || arena.getState() == GameState.COUNTDOWN) {
                    player.sendMessage(ChatColor.GREEN + "You are already playing in arena " + id + ".");
                    arena.addPlayer(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You can not join this arena right now.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You specified an invalid arena id.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Invalid usage! These are the options:");
            player.sendMessage(ChatColor.RED + "- /arena list");
            player.sendMessage(ChatColor.RED + "- /arena leave");
            player.sendMessage(ChatColor.RED + "- /arena join <id>");
        }

        return false;
    }
}
