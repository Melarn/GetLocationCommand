package me.melarn.plugin;

import me.melarn.plugin.Commands.MessagesCMD;
import me.melarn.plugin.Commands.TabCompleter;
import net.kyori.adventure.audience.Audience;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class Plugin extends JavaPlugin {

    private Audience adventure;

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
