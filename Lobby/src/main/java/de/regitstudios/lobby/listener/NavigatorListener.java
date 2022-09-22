/*  Created on 22.09.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.lobby.listener;

import de.regitstudios.lobby.services.ServerNavigatorService;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.regitstudios.lobby.services.ServerNavigatorService.*;
import static java.util.Objects.requireNonNull;
import static net.kyori.adventure.text.Component.text;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class NavigatorListener implements Listener {

    private final ServerNavigatorService serverNavigatorService = new ServerNavigatorService();

    @EventHandler
    public void onNavigatorMoved(PlayerInteractEvent event) {
        final ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        final ItemMeta itemMeta = item.getItemMeta();
        if(itemMeta.getDisplayName().equals(NAVIGATOR_NAME)) {
            serverNavigatorService.showNavigatorInventory(event.getPlayer());
        }
    }

    @EventHandler
    public void onMenuClicked(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase(NAVIGATOR_INVENTORY_TITLE)) {
            final ItemStack clickedItem = event.getCurrentItem();
            assert clickedItem != null;
            final ItemMeta clickedItemMeta = clickedItem.getItemMeta();
            if(clickedItemMeta.getDisplayName().equals(NAVIGATOR_MENU_BEDWARS_TITLE)) {
                //Switching Server!
            }
            event.setCancelled(true);
        }
    }
}
