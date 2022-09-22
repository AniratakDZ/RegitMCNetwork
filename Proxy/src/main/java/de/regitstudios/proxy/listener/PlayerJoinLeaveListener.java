/*  Created on 22.09.2022
 *
 *  Copyright (c) 2022
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package de.regitstudios.proxy.listener;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static net.md_5.bungee.api.ChatColor.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class PlayerJoinLeaveListener implements Listener {

    public static String JOIN_MESSAGE = GRAY + "[" + YELLOW + "+" + GRAY + "] ";
    public static String LEAVE_MESSAGE = GRAY + "[" + YELLOW + "-" + GRAY + "] ";

    @EventHandler
    public void onPlayerJoin(PostLoginEvent event) {
        final ProxiedPlayer player = event.getPlayer();
        ProxyServer.getInstance().broadcast(new TextComponent(JOIN_MESSAGE + player.getName()));
    }

    @EventHandler
    public void onPlayerLeave(PlayerDisconnectEvent event) {
        final ProxiedPlayer player = event.getPlayer();
        ProxyServer.getInstance().broadcast(new TextComponent(LEAVE_MESSAGE + player.getName()));
    }
}
