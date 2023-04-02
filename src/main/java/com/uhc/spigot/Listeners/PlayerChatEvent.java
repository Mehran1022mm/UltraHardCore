package com.uhc.spigot.Listeners;

import com.uhc.spigot.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerChatEvent implements Listener {

    private Set<String> BadWords;

    private final Map<Player, Long> LastMessageTimes = new HashMap<>();
    private final int MessageInterval = 2000;

    @EventHandler
    public void OnPlayerChat (AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!Configuration.ANTISPAM_ENABLED) {
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
    public void OnPlayerCommand (PlayerCommandSendEvent event) {
        Player player = event.getPlayer();
        if (!Configuration.ANTISPAM_ENABLED) {
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
    /*@EventHandler
    public void SwearListener (AsyncPlayerChatEvent event) {
        if (!Configuration.ANTISWEAR_ENABLED) {
            return;
        }
        String Message = event.getMessage();
        if (BadWords != null) {
            for (String BadWord : BadWords) {
                if (Message.toLowerCase().contains(BadWord)) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("§cPlease refrain from using that language!");
                    return;
                }
            }
        }
    } */
    /* public void AntiSwearLoad () {
        BadWords = new HashSet<>();
        File BannedWordsFile = new File(plugin.getDataFolder(), "Banned-Words.txt");

        if (!BannedWordsFile.exists()) {
            plugin.getLogger().warning("Loading Default Banned Words.");
            try {
                BannedWordsFile.createNewFile();
                InputStream DefaultWordsStream = plugin.getResource("Banned-Words.txt");
                BufferedReader DefaultWordsReader = new BufferedReader(new InputStreamReader(DefaultWordsStream, StandardCharsets.UTF_8));
                FileWriter BannedWordsWriter = new FileWriter(BannedWordsFile);
                String line = "";
                while ((line = DefaultWordsReader.readLine()) != null) {
                    BannedWordsWriter.write(line + "\n");
                    BadWords.add(line.trim());
                }
                BannedWordsWriter.close();
                DefaultWordsReader.close();
                DefaultWordsStream.close();
                plugin.getLogger().warning("Loaded Default Banned Words File With " + BadWords.size() + " Words");
            } catch (IOException e) {
                plugin.getLogger().warning("Failed To Create Default Banned Words File!");

            }
        } else {
            try {
                Files.readAllLines(BannedWordsFile.toPath(), StandardCharsets.UTF_8)
                        .stream()
                        .map(String::trim)
                        .forEach(BadWords::add);

                plugin.getLogger().info("Loaded Default Banned Words File With " + BadWords.size() + " Words.");

            } catch (IOException e) {
                plugin.getLogger().warning("Failed To Read Banned Words File!");
                e.printStackTrace();
            }
        }
    } */
}
