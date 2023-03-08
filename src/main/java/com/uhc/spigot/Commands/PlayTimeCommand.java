package com.uhc.spigot.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayTimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[UltraHardCore] You Must Be A Player.");
            return true;
        }
        if (!cmd.getName().equalsIgnoreCase("playtime")) {
            return false;
        }

        Player CommandExecutor = (Player) sender;
        String ExecutorName = CommandExecutor.getName();
        int PlayTimeMin = CommandExecutor.getStatistic(Statistic.PLAY_ONE_MINUTE);
        int PlayTimeHour = PlayTimeMin / 60;
        String PlayTime = color("&b&l(!)&b {PlayerName}'s &fPlaytime Is &b"+ PlayTimeHour +"&f Hours.").replace("{PlayerName}", ExecutorName);
        CommandExecutor.sendMessage(PlayTime);
        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
