package com.uhc.spigot.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AlertCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("ultrahardcore.alert")) {
            sender.sendMessage(ChatColor.RED + "[UltraHardCore] You do not have permission to send alerts.");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "[UltraHardCore] You Must Specify A Message.");
            return true;
        }
        String Alert = String.join(" ", args);
        Bukkit.broadcastMessage(color("&b&l(!)&b Alert &7- &r" + Alert));
        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
