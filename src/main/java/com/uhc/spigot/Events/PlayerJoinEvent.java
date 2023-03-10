package com.uhc.spigot.Events;

import com.uhc.spigot.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    private final Main plugin;
    private final FileConfiguration configuration;

    public PlayerJoinEvent(Main plugin) {
        this.plugin = plugin;
        this.configuration = plugin.getConfig();
    }

    @EventHandler
    public void OnPlayerJoin (org.bukkit.event.player.PlayerJoinEvent event) {
        Player JoinedPlayer = event.getPlayer();
        String JoinedPlayerName = JoinedPlayer.getName();
        if (!JoinedPlayer.hasPlayedBefore() && configuration.getBoolean("")) {
            String FirstJoinAnnouncementMessage = color(configuration.getString("JoinOptions.FirstJoinAnnouncementMessage")).replace("{PlayerName}", JoinedPlayerName);
            event.setJoinMessage(FirstJoinAnnouncementMessage);
        } else {
            String JoinAnnouncementMessage = color(configuration.getString("JoinOptions.JoinAnnouncementMessage")).replace("{PlayerName}", JoinedPlayerName);
            event.setJoinMessage(JoinAnnouncementMessage);
        }
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
