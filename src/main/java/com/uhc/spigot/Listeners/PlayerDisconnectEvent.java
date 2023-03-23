package com.uhc.spigot.Listeners;

import com.uhc.spigot.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnectEvent implements Listener {

    private final Main plugin;
    private final FileConfiguration configuration;

        public PlayerDisconnectEvent (Main plugin) {
            this.plugin = plugin;
            this.configuration = plugin.getConfig();
        }

        @EventHandler
        public void OnPlayerDisconnect (PlayerQuitEvent event) {
            Player JoinedPlayer = event.getPlayer();
            String JoinedPlayerName = JoinedPlayer.getName();
            String QuitAnnouncementMessage = color(configuration.getString("JoinOptions.QuitAnnouncementMessage")).replace("{PlayerName}", JoinedPlayerName);
            event.setQuitMessage(QuitAnnouncementMessage);
        }
        private String color(String str) {
            return ChatColor.translateAlternateColorCodes('&', str);
        }
    }
