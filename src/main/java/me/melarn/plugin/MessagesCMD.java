package me.melarn.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MessagesCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length < 1) {
                sender.sendMessage("No dude");
                return true;
            }

            if (args[0].equalsIgnoreCase("location")) {
                sender.sendMessage("Локация: " + player.getLocation());
                return true;
            } else if (args[0].equalsIgnoreCase("world")) {
                sender.sendMessage("Мир: " + player.getWorld());
                return true;
            }
        }
        return true;
    }
}

