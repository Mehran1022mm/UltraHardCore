package com.uhc.spigot.Commands;

import com.uhc.spigot.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class UltraHardCoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("ultrahardcore.reload")) {
                sender.sendMessage(ChatColor.RED + "[UltraHardCore] You do not have permission to reload the plugin configuration.");
                return true;
            }
            Configuration.loadConfig();
            sender.sendMessage(ChatColor.RED + "[UltraHardCore] Config Reloaded.");
            return true;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("info")) {
            sender.sendMessage(color("&b&l(!)&b UltraHardCore&f Info"));
            sender.sendMessage(color("&b&l(!)&f VERSION 1.7 RE-BUILD C 1.0 - Mehran1022 & GodOfPro"));
            sender.sendMessage(color("&b&l(!)&b /Alert &7- &fSend A Alert &7- &cultrahardcore.alert"));
            sender.sendMessage(color("&b&l(!)&b /ClearChat &7- &fClear Server Chats &7- &cultrahardcore.clearchat"));
            sender.sendMessage(color("&b&l(!)&b /Freeze &7- &fFreeze Cheaters &7- &cultrahardcore.freeze"));
            sender.sendMessage(color("&b&l(!)&b /Ping &7- &fCheck Your Ping &7- &cNull"));
            sender.sendMessage(color("&b&l(!)&b /Playtime &7- &fCheck Your Playtime &7- &cNull"));
            sender.sendMessage(color("&b&l(!)&b /SocialMedia [Discord-Instagram-Website] &7- &fSocialMedia URLs &7- &cNull"));
            sender.sendMessage(color("&b&l(!)&b /UltraHardCore [Reload-Info] &7- &fMain Command &7- &cVariable"));
            sender.sendMessage(color("&b&l(!)&b /Unban &7- &fUnban A Player &7- &cultrahardcore.unban"));
            sender.sendMessage(color("&b&l(!)&b /UnFreeze &7- &fUnFroze Players &7- &cultrahardcore.freeze"));
            return true;
        }

        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
