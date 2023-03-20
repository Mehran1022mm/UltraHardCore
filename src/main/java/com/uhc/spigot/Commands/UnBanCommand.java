package com.uhc.spigot.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnBanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("unban")) {
            return true;
        }

        if (!sender.hasPermission("ultrahardcore.unban")) {
            sender.sendMessage(color("&c[UltraHardCore] You don't have permission to use this command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(color("&c[UltraHardCore] You must specify a player."));
            return true;
        }

        String PlayerName = args[0];
        BanList BanList = Bukkit.getServer().getBanList(org.bukkit.BanList.Type.NAME);

        if (!BanList.isBanned(PlayerName)) {
            sender.sendMessage(color("&c[UltraHardCore] " + PlayerName + " is not banned."));
            return true;
        }

        BanList.pardon(PlayerName);
        sender.sendMessage(color("&a[UltraHardCore] " + PlayerName + " has been unbanned."));

        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
