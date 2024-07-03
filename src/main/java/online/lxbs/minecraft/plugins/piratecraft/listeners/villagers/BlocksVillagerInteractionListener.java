package online.lxbs.minecraft.plugins.piratecraft.listeners.villagers;

import online.lxbs.minecraft.plugins.piratecraft.GUI.BlocksVillagerTradeGUI;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BlocksVillagerInteractionListener implements Listener {
    @EventHandler
    public void onBlockVillagerInteraction(@NotNull PlayerInteractAtEntityEvent event) {
        if (!event.getRightClicked().getType().equals(EntityType.VILLAGER)) return;
        if (!Objects.equals(event.getRightClicked().getCustomName(), "Blocks")) return;
        event.getPlayer().openMerchant(BlocksVillagerTradeGUI.getBlocksVillagerTradeGUI(), true);
    }
}
