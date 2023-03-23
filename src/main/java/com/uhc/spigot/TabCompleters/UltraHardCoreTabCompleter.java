package com.uhc.spigot.TabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;

public class UltraHardCoreTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("ultrahardcore")) {
            return null;
        }
        if (args.length == 1) {
            return Collections.singletonList("info");
        }
        return Collections.emptyList();
    }
}
