package me.histal.joinplugin;

import me.histal.joinplugin.commands.HealCommand;
import me.histal.joinplugin.listeners.JoinListener;
import me.histal.joinplugin.listeners.LeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new LeaveListener(), this);

        this.getCommand("heal").setExecutor(new HealCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
