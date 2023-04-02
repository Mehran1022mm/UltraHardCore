package com.uhc.spigot.Listeners;

import com.uhc.spigot.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnectEvent implements Listener {

        @EventHandler
        public void OnPlayerDisconnect (PlayerQuitEvent event) {
            Player JoinedPlayer = event.getPlayer();
            String JoinedPlayerName = JoinedPlayer.getName();
            String QuitAnnouncementMessage = color(Configuration.JOINOPTIONS_QUITANNOUNCEMENTMESSAGE).replace("{PlayerName}", JoinedPlayerName);
            event.setQuitMessage(QuitAnnouncementMessage);
        }
        private String color(String str) {
            return ChatColor.translateAlternateColorCodes('&', str);
        }
    }
