package com.uhc.spigot.Commands;

import com.uhc.spigot.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class SocialMediaCommand implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if  (args.length == 0) {
            sender.sendMessage(color("[UltraHardCore] Invalid Argument. /SocialMedia [Discord,Website,Instagram]"));
            return true;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("discord")) {
            sender.sendMessage(color("&b&l(!)&9 Discord Server URL"));
            sender.sendMessage(color("&b&l(!)&b " + Configuration.SOCIALMEDIA_DISCORD_URL));
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("website")) {
            sender.sendMessage(color("&b&l(!)&a Website URL"));
            sender.sendMessage(color("&b&l(!)&b " + Configuration.SOCIALMEDIA_WEBSITE_URL));
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("instagram")) {
            sender.sendMessage(color("&b&l(!)&5 Instagram Page URL"));
            sender.sendMessage(color("&b&l(!)&b " + Configuration.SOCIALMEDIA_INSTAGRAM_URL));
        }

        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
   }
}
