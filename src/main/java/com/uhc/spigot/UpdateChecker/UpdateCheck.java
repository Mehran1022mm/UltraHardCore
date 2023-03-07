package com.uhc.spigot.UpdateChecker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateCheck {
    private final Plugin plugin;
    private final int pluginResourceId;

    public UpdateCheck(Plugin plugin, int pluginResourceId) {
        this.plugin = plugin;
        this.pluginResourceId = pluginResourceId;
    }

    public void getVersion(Consumer<String> consumer) {
        if (consumer == null) {
            return;
        }
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try(InputStream inputStream = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.pluginResourceId)).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getServer().getConsoleSender().sendMessage("[UltraHardCore] Unable to check for updates: " + exception.getMessage());
            }
        });
    }
}
