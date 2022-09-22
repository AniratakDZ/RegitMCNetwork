package de.regitstudios.lobby;

import de.regitstudios.lobby.listener.PlayerJoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
