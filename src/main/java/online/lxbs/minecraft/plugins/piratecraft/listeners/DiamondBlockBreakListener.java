package online.lxbs.minecraft.plugins.piratecraft.listeners;

import online.lxbs.minecraft.plugins.piratecraft.GameState;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import online.lxbs.minecraft.plugins.piratecraft.instance.Arena;
import online.lxbs.minecraft.plugins.piratecraft.instance.Game;
import online.lxbs.minecraft.plugins.piratecraft.instance.Team;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class DiamondBlockBreakListener implements Listener {
    private final Piratecraft piratecraft;

    public DiamondBlockBreakListener(Piratecraft piratecraft) {
        this.piratecraft = piratecraft;
    }

    @EventHandler
    public void onDiamondBlockBreak(@NotNull BlockBreakEvent event) {
        if (!event.getBlock().getType().equals(Material.DIAMOND_BLOCK) || !event.getBlock().hasMetadata("team")) return;

        Arena arena = piratecraft.getArenaManager().getArena(event.getPlayer());
        if (arena == null || !arena.getState().equals(GameState.LIVE)) return;

        Game game = arena.getGame();
        event.setCancelled(game.destroyBed(Team.valueOf(event.getBlock().getMetadata("team").get(0).asString().toUpperCase()), event.getPlayer()));


    }
}
