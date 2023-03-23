package com.uhc.spigot.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("ultrahardcore.clearchat")) {
            sender.sendMessage(color("&c[UltraHardCore] You don't have permission to use this command."));
            return true;
        }

        if (sender instanceof Player){
            String SenderName = sender.getName();
            for (Player OnlinePlayers : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < 100; i++) {
                    OnlinePlayers.sendMessage(" ");
                }
                OnlinePlayers.sendMessage(color("&b&l(!)&f Chat Has Been Cleared By &b" + SenderName));
            }

        } else {
            for (Player OnlinePlayers : Bukkit.getOnlinePlayers()) {
                for (int i = 0; i < 100; i++) {
                    OnlinePlayers.sendMessage(" ");
                }
                OnlinePlayers.sendMessage(color("&b&l(!)&f Chat Has Been Cleared By &bConsole"));
            }
        }
        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
