package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class GameListener implements Listener {
    private final Piratecraft piratecraft;

    public GameListener(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @EventHandler
    public void onBlockBreak(@NotNull BlockBreakEvent event) {
        Arena arena = piratecraft.getArenaManager().getArena(event.getPlayer());

        if (arena != null && arena.getState().equals(GameState.LIVE)) {
            arena.getGame().addPoint(event.getPlayer());
        }
    }
}
