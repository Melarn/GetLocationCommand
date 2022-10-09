package me.melarn.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("get").setExecutor(new MessagesCMD());
        getCommand("get").setTabCompleter(new TabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
