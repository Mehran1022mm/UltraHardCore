package com.uhc.spigot.Listeners;

import com.uhc.spigot.Configuration;
import com.uhc.spigot.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RespawnEvent implements Listener {

    private final Set<UUID> RespawnedPlayers = new HashSet<>();

    @EventHandler
    public void OnDeath (PlayerRespawnEvent event) {
        Player RespawnedPlayer = event.getPlayer();
        String RespawnedPlayerName = event.getPlayer().getName();
        String BanReason = color(Configuration.PUNISHMENT_REASON);
        RespawnedPlayers.add(RespawnedPlayer.getUniqueId());
        RespawnedPlayer.sendTitle(Configuration.TITLE_TITLEMESSAGE, Configuration.TITLE_SUBTITLEMESSAGE, Configuration.TITLE_FADEIN, Configuration.TITLE_STAY, Configuration.TITLE_FADEOUT);
        RespawnedPlayer.setGameMode(GameMode.SPECTATOR);
        BukkitScheduler Scheduler = Main.getInstance().getServer().getScheduler();
        Scheduler.scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (RespawnedPlayers.contains(RespawnedPlayer.getUniqueId()) && Configuration.PUNISHMENT_BAN) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(RespawnedPlayerName, BanReason, null, null);
                    RespawnedPlayer.kickPlayer(BanReason);
                } else {
                    RespawnedPlayer.setGameMode(GameMode.SPECTATOR);
                }
            }
        }, 20L * 4);
        /*if (RespawnedPlayers.contains(RespawnedPlayer.getUniqueId()) && configuration.getBoolean("Punishment.Ban")) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(RespawnedPlayerName, BanReason, null, null);
            RespawnedPlayer.kickPlayer(BanReason);
        } else {
            RespawnedPlayer.setGameMode(GameMode.SPECTATOR);
        }*/
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
