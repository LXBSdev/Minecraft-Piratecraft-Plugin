package online.lxbs.minecraft.plugins.piratecraft.listeners.villagers;

import online.lxbs.minecraft.plugins.piratecraft.GUI.BowsVillagerTradeGUI;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BowsVillagerInteractionListener implements Listener {
    @EventHandler
    public void onBlockVillagerInteraction(@NotNull PlayerInteractAtEntityEvent event) {
        if (!event.getRightClicked().getType().equals(EntityType.VILLAGER)) return;
        if (!Objects.equals(event.getRightClicked().getCustomName(), "Bows")) return;
        event.getPlayer().openMerchant(BowsVillagerTradeGUI.getBowsVillagerTradeGUI(), true);
    }

}
