/*  Created on 22.09.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.lobby.services;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import static java.util.Objects.requireNonNull;
import static org.bukkit.GameMode.SURVIVAL;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class PlayerService {

    public static String WORLD_NAME = "world";

    private final ServerNavigatorService serverNavigatorService = new ServerNavigatorService();

    public void initializePlayerJoin(Player player) {
        initializeVitalParams(player);
        intializePlayerSpawn(player);
        initializeInventory(player);
    }

    private void initializeVitalParams(Player player) {
        player.setGameMode(SURVIVAL);
        player.setHealth(20);
        player.setFoodLevel(20);
    }

    private void initializeInventory(Player player) {
        player.getInventory().clear();
        final PlayerInventory playerInventory = player.getInventory();
        playerInventory.setItem(0, serverNavigatorService.createServerNavigator());
    }

    private void intializePlayerSpawn(Player player) {
        final Location serverSpawn = requireNonNull(Bukkit.getServer().getWorld(WORLD_NAME)).getSpawnLocation();
        //Adjusting coordinates for X and Z by 0.5, so the player spawns in the middle of the block
        serverSpawn.set(serverSpawn.getX() + 0.5, serverSpawn.getY(), serverSpawn.getZ() + 0.5);
        player.teleport(serverSpawn);
    }
}
