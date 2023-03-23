package com.uhc.spigot.Listeners;

import com.uhc.spigot.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RespawnEvent implements Listener {

    private final Main plugin;
    private final FileConfiguration configuration;
    private final String titleMessage;
    private final String subTitleMessage;
    private final int fadeIn;
    private final int stay;
    private final int fadeOut;

    private final Set<UUID> RespawnedPlayers = new HashSet<>();

    public RespawnEvent (Main plugin) {
        this.plugin = plugin;
        this.configuration = plugin.getConfig();
        this.titleMessage = color(configuration.getString("Title.TitleMessage"));
        this.subTitleMessage = color(configuration.getString("Title.SubTitleMessage"));
        this.fadeIn = configuration.getInt("Title.FadeIn");
        this.stay = configuration.getInt("Title.Stay");
        this.fadeOut = configuration.getInt("Title.FadeOut");
    }
    @EventHandler
    public void OnDeath (PlayerRespawnEvent event) {
        Player RespawnedPlayer = event.getPlayer();
        String RespawnedPlayerName = event.getPlayer().getName();
        String BanReason = color(configuration.getString("Punishment.Reason"));
        RespawnedPlayers.add(RespawnedPlayer.getUniqueId());
        RespawnedPlayer.sendTitle(titleMessage, subTitleMessage, fadeIn, stay, fadeOut);
        RespawnedPlayer.setGameMode(GameMode.SPECTATOR);
        BukkitScheduler Scheduler = plugin.getServer().getScheduler();
        Scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                if (RespawnedPlayers.contains(RespawnedPlayer.getUniqueId()) && configuration.getBoolean("Punishment.Ban")) {
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
