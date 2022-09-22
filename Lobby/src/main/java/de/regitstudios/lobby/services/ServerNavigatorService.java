/*  Created on 22.09.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.lobby.services;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static net.kyori.adventure.text.Component.text;
import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.YELLOW;
import static org.bukkit.Material.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class ServerNavigatorService {

    public static String NAVIGATOR_NAME = YELLOW + "Server Navigator";
    public static String NAVIGATOR_INVENTORY_TITLE = GRAY + "Server Navigator";
    public static String NAVIGATOR_MENU_BEDWARS_TITLE = "Bedwars";

    public static int NAVIGATOR_INVENTORY_SIZE = 54;
    public static int NAVIGAOTR_MENU_BEDWARS_INDEX = 10;

    public ItemStack createServerNavigator() {
        return createItemStackWithSpecificName(NAVIGATOR_NAME, COMPASS);
    }

    public void showNavigatorInventory(Player player) {
        final Inventory inventory = Bukkit.createInventory(player, NAVIGATOR_INVENTORY_SIZE, NAVIGATOR_INVENTORY_TITLE);
        final List<ItemStack> inventoryItems = initializeCustomInventoryItems(initializeDefaultInventoryItems());
        for(int i = 0; i < NAVIGATOR_INVENTORY_SIZE; i++) {
            inventory.setItem(i, inventoryItems.get(i));
        }
        player.openInventory(inventory);
    }

    private List<ItemStack> initializeDefaultInventoryItems() {
        final List<ItemStack> inventoryItems = new ArrayList<>();
        for(int i = 0; i < NAVIGATOR_INVENTORY_SIZE; i++)
            inventoryItems.add(createItemStackWithSpecificName("", GRAY_STAINED_GLASS_PANE));
        return inventoryItems;
    }

    private List<ItemStack> initializeCustomInventoryItems(List<ItemStack> inventoryItems) {
        final ItemStack bedwarsItem = createItemStackWithSpecificName(NAVIGATOR_MENU_BEDWARS_TITLE, RED_BED);
        inventoryItems.set(NAVIGAOTR_MENU_BEDWARS_INDEX, bedwarsItem);
        return inventoryItems;
    }

    private ItemStack createItemStackWithSpecificName(String name, Material material) {
        final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(text(name));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
