package com.uhc.spigot.TabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocialMediaTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        final List<String> List = new ArrayList<>();
        if (!cmd.getName().equalsIgnoreCase("socialmedia")) {
            return null;
        }
        if (args.length == 1) {
            List.add("Discord");
            List.add("Website");
            List.add("Instagram");
            return List;
        }
        return Collections.emptyList();
    }
}
