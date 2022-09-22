package de.regitstudios.proxy;

import de.regitstudios.proxy.listener.PlayerJoinLeaveListener;
import net.md_5.bungee.api.plugin.Plugin;

public final class Proxy extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerListener(this, new PlayerJoinLeaveListener());
    }

    @Override
    public void onDisable() {

    }
}
