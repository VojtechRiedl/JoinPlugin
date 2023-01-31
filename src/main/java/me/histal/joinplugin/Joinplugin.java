package me.histal.joinplugin;

import me.histal.joinplugin.listeners.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Joinplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
