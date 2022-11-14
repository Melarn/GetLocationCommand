package me.melarn.plugin.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.UUID;

public class MessagesCMD implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;

    public MessagesCMD() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.of(Color.PINK) + "/<get> location");
                return true;
            }
            if (!cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) > 5000) {
                cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            } else {
                player.sendMessage(Component.text("Пожалуйста подождите 5 сек.").color((TextColor) new Color(204, 25, 25)));
                return false;
            }

            if (args[0].equalsIgnoreCase("location")) {
                int BlockX = (player.getLocation().getBlockX());
                int BlockY = (player.getLocation().getBlockY());
                int BlockZ = (player.getLocation().getBlockZ());

                player.sendMessage(Component.text(""));
                String location = ChatColor.of(new Color(102, 167, 197)) + "Локация: " + ChatColor.of(Color.WHITE) +
                        "\n" + " X: " + ChatColor.of(new Color(206, 231, 251)) + BlockX +
                        ChatColor.of(Color.WHITE) +
                        "\n" + " Y: " + ChatColor.of(new Color(206, 231, 251)) + BlockY +
                        ChatColor.of("#FFFFFF") +
                        "\n" + " Z: " + ChatColor.of(new Color(206, 231, 251)) + BlockZ;

                String messageToChat = ("X: " + BlockX + " Y: " + BlockY + " Z: " + BlockZ);
                String result = messageToChat;
                player.sendMessage(location);

                player.sendMessage(Component.text(""));
                player.sendMessage(Component.text("[ Нажмите чтобы отправить сообщение в локальный чат ]" + "\n")
                        .color(TextColor.color(234, 161, 48))
                        .clickEvent(ClickEvent.suggestCommand(result))
                        .hoverEvent(Component.text("Нажмите чтобы отправить сообщение")));

                player.sendMessage(Component.text("[ Нажмите чтобы отправить сообщение в глобальный чат ]")
                        .color(TextColor.color(117, 159, 234))
                        .clickEvent(ClickEvent.suggestCommand("!" + result))
                        .hoverEvent(Component.text("Нажмите чтобы отправить сообщение")));
                player.sendMessage(Component.text(""));
                return true;

            } else if (args[0].equalsIgnoreCase("world")) {
                return true;

            }
        }
        return true;
    }
}

