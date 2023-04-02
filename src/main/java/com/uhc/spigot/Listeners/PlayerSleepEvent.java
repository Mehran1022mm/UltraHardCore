package com.uhc.spigot.Listeners;

import com.uhc.spigot.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerSleepEvent implements Listener {

    @EventHandler
    public void OnPlayerSleep (PlayerBedEnterEvent event) {
        if (!Configuration.SLEEPOPTIONS_ONEPLAYERSLEEP_ENABLED) {
            return;
        }
        Player SleepingPlayer = event.getPlayer();
        World PlayerWorld = SleepingPlayer.getWorld();
        PlayerWorld.setTime(23500L);
        SleepingPlayer.sendMessage(color(Configuration.SLEEPOPTIONS_ONEPLAYERSLEEP_WAKEUPMESSAGE));
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
