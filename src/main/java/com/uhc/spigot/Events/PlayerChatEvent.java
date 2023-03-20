package com.uhc.spigot.Events;

import com.uhc.spigot.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerChatEvent implements Listener {
    private final Main plugin;
    private final FileConfiguration configuration;

    public PlayerChatEvent(Main plugin) {
        this.plugin = plugin;
        this.configuration = plugin.getConfig();
    }

    private final Map<Player, Long> LastMessageTimes = new HashMap<>();
    private final int MessageInterval = 2000;

    @EventHandler
    public void OnPlayerChat (AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!configuration.getBoolean("AntiSpam.Enabled")) {
            return;
        }
        long CurrentTime = System.currentTimeMillis();
        if (LastMessageTimes.containsKey(player)) {
            long LastMessageTime = LastMessageTimes.get(player);
            if (CurrentTime - LastMessageTime < MessageInterval) {
                event.setCancelled(true);
                player.sendMessage("§cPlease Wait Before Sending Another Message.");
                return;
            }
        }
        LastMessageTimes.put(player, CurrentTime);

    }
    @EventHandler
    public void OnPlayrCommand (PlayerCommandSendEvent event) {
        Player player = event.getPlayer();
        if (!configuration.getBoolean("AntiSpam.Enabled")) {
            return;
        }
        long CurrentTime = System.currentTimeMillis();
        if (LastMessageTimes.containsKey(player)) {
            long LastMessageTime = LastMessageTimes.get(player);
            if (CurrentTime - LastMessageTime < MessageInterval) {
                event.getCommands().clear();
                player.sendMessage("§cPlease Wait Before Sending Another Command.");
                return;
            }
        }
        LastMessageTimes.put(player, CurrentTime);
    }

}
