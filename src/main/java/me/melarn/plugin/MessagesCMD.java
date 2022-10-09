package me.melarn.plugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class MessagesCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.of(Color.PINK) + "No arguments!");
                return true;
            }

            if (args[0].equalsIgnoreCase("location")) {

                int BlockX = (player.getLocation().getBlockX());
                int BlockY = (player.getLocation().getBlockY());
                int BlockZ = (player.getLocation().getBlockZ());

                sender.sendMessage(ChatColor.of(Color.PINK) + "Локация: " + ChatColor.of(Color.WHITE) +
                        "\n" + "X: " + ChatColor.of(Color.RED) + BlockX +
                        ChatColor.of(Color.WHITE) +
                        "\n" + "Y: " + ChatColor.of(Color.GRAY) + BlockY +
                        ChatColor.of(Color.WHITE) +
                        "\n" + "Z: " + ChatColor.of(Color.cyan) + BlockZ);
                return true;
            } else if (args[0].equalsIgnoreCase("world")) {
                sender.sendMessage(ChatColor.of(Color.PINK) + "Мир: " + ChatColor.of(Color.LIGHT_GRAY) + player.getWorld());
                return true;
            }
        }
        return true;
    }
}

