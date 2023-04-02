package com.uhc.spigot.Listeners;

import com.uhc.spigot.Configuration;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ActionBarEvent implements Listener {

    @EventHandler
    public void OnPlayerJoin (PlayerMoveEvent event) {
        if (!Configuration.ACTIONBAROPTIONS_ENABLED) {
            return;
        }
        Player Player = event.getPlayer();
        double X = Math.round(Player.getLocation().getX());
        double Y = Math.round(Player.getLocation().getY());
        double Z = Math.round(Player.getLocation().getZ());
        String Facing = String.valueOf(Player.getFacing());
        String ActionBar = color("&bX: &f" + X + " &bY: &f" + Y + " &bZ &f" + Z + " &bFacing: &f" + Facing);
        Player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ActionBar));
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
