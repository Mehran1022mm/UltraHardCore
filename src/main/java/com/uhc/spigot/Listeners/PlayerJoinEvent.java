package com.uhc.spigot.Listeners;

import com.uhc.spigot.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    // private String WebhookURL = configuration.getString("JoinOptions.JoinDiscordWebhook.Webhook-URL");

    @EventHandler
    public void OnPlayerJoin (org.bukkit.event.player.PlayerJoinEvent event) {
        Player JoinedPlayer = event.getPlayer();
        String JoinedPlayerName = JoinedPlayer.getName();
        String ResourcePackURL = Configuration.FORCEDRESOURCEPACK_RESOURCEPACKURL;
        /* Join Message */
        if (!JoinedPlayer.hasPlayedBefore() && Configuration.JOINOPTIONS_ENABLED) {
            String FirstJoinAnnouncementMessage = color(Configuration.JOINOPTIONS_FIRSTJOINANNOUNCEMENTMESSAGE).replace("{PlayerName}", JoinedPlayerName);
            event.setJoinMessage(FirstJoinAnnouncementMessage);
        } else {
            String JoinAnnouncementMessage = color(Configuration.JOINOPTIONS_JOINANNOUNCEMENTMESSAGE).replace("{PlayerName}", JoinedPlayerName);
            event.setJoinMessage(JoinAnnouncementMessage);
        }
        /* ResourcePack */
        if (ResourcePackURL == null || ! Configuration.FORCEDRESOURCEPACK_ENABLED) {
            return;
        }
        JoinedPlayer.setResourcePack(ResourcePackURL);
    }
    /* ill add it later <3
    public void WebhookSend(String message) {
        try {
            URL url = new URL(WebhookURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonMessage = "{\"content\": \"" + message + "\"}";
            byte[] jsonBytes = jsonMessage.getBytes(StandardCharsets.UTF_8);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.write(jsonBytes);
            outputStream.flush();
            outputStream.close();

            connection.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
        }

    } */

    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
