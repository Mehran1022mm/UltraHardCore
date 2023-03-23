package com.uhc.spigot.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[UltraHardCore] You Must Be A Player.");
            return true;
        }
        if (!cmd.getName().equalsIgnoreCase("ping")) {
            return false;
        }
        Player CommandExecutor = (Player) sender;
        String ExecutorName = CommandExecutor.getName();
        int ExecutorPing = CommandExecutor.getPing();
        String Ping = color("&b&l(!)&b {PlayerName}'s &fPing Is &b"+ ExecutorPing +"&f MilliSeconds.").replace("{PlayerName}", ExecutorName);
        CommandExecutor.sendMessage(Ping);

        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
