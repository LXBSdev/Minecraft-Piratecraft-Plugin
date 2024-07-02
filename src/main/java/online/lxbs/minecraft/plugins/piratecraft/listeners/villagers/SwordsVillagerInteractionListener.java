package online.lxbs.minecraft.plugins.piratecraft.listeners.villagers;

import online.lxbs.minecraft.plugins.piratecraft.GUI.SwordsVillagerTradeGUI;
import online.lxbs.minecraft.plugins.piratecraft.Piratecraft;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SwordsVillagerInteractionListener implements Listener {

    public SwordsVillagerInteractionListener(Piratecraft plugin) {Bukkit.getPluginManager().registerEvents(this, plugin);}

    @EventHandler
    public void onBlockVillagerInteraction(@NotNull PlayerInteractAtEntityEvent event) {
        if (!event.getRightClicked().getType().equals(EntityType.VILLAGER)) return;
        if (!Objects.equals(event.getRightClicked().getCustomName(), "Swords")) return;
        event.getPlayer().openMerchant(SwordsVillagerTradeGUI.getSwordsVillagerTradeGUI(), true);
    }

}
