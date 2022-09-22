package de.regitstudios.lobby;

import de.regitstudios.lobby.listener.NavigatorListener;
import de.regitstudios.lobby.listener.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        this.getServer().getPluginManager().registerEvents(new NavigatorListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
