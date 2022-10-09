package me.melarn.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
//
//        try {
//            a = Integer.parseInt(args[0]);
//            b = Integer.parseInt(args[2]);
//        }
//        catch (NumberFormatException e) {
//             return null;
//        }

        if (args.length == 1) {
            return List.of("location", "world");
        }
            return null;
    }
}
