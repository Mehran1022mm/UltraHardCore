package com.uhc.spigot.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class UnFreezeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[UltraHardCore] You must be a player.");
            return true;
        }
        if (!sender.hasPermission("ultrahardcore.freeze")) {
            sender.sendMessage(color("&c[UltraHardCore] You don't have permission to use this command."));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(color("&c[UltraHardCore] You must specify a player."));
            return true;
        }
        Player Player = (Player) sender;
        String PlayerName = Player.getName();
        Player Target = Bukkit.getPlayer(args[0]);
        if (Target == null) {
            sender.sendMessage(color("&c[UltraHardCore] " + PlayerName + " is not online."));
            return true;
        }
        Target.setWalkSpeed(0.2f);
        Target.setFlySpeed(0.1f);
        Target.removePotionEffect(PotionEffectType.JUMP);
        Player.sendMessage(color("&b&l(!)&b " + Target.getName() + " &fHas Been UnFrozen."));
        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
