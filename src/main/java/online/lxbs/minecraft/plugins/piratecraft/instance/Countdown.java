package online.lxbs.minecraft.plugins.piratecraft.instance;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.managers.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {
    private final Piratecraft piratecraft;
    private final Arena arena;
    private int countdownSeconds;

    public Countdown(Piratecraft piratecraft, Arena arena) {
        this.piratecraft = piratecraft;
        this.arena = arena;
        this.countdownSeconds = ConfigManager.COUNTDOWN_SECONDS;
    }

    public void start() {
        arena.setState(GameState.COUNTDOWN);
        runTaskTimer(piratecraft, 0, 20);
    }

    @Override
    public void run() {
        if (countdownSeconds == 0) {
            cancel();
            arena.start();
            return;
        }

        if (countdownSeconds <= 10 || countdownSeconds % 15 == 0) {
            arena.sendMessage(ChatColor.GREEN + "Game will start in " + countdownSeconds + " second" + (countdownSeconds == 1 ? "" : "s") + ".");
        }

        arena.sendTitle(ChatColor.GREEN.toString() + countdownSeconds + "second" + (countdownSeconds == 1 ? "" : "s"), ChatColor.GRAY + "until game starts");

        countdownSeconds--;
    }
}
