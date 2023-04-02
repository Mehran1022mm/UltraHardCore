package com.uhc.spigot;

import com.uhc.spigot.Checks.UpdateCheck;
import com.uhc.spigot.Commands.*;
import com.uhc.spigot.Listeners.*;
import com.uhc.spigot.TabCompleters.SocialMediaTabCompleter;
import com.uhc.spigot.TabCompleters.UltraHardCoreTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Configuration.loadConfig();
        setupCommands();
        setupTabComplete();
        setupEvents();
        setupUpdater();
    }

    private void setupCommands() {
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("alert").setExecutor(new AlertCommand());
        getCommand("unban").setExecutor(new UnBanCommand());
        getCommand("freeze").setExecutor(new FreezeCommand());
        getCommand("unfreeze").setExecutor(new UnFreezeCommand());
        getCommand("playtime").setExecutor(new PlayTimeCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("socialmedia").setExecutor(new SocialMediaCommand());
        getCommand("ultrahardcore").setExecutor(new UltraHardCoreCommand());
        getLogger().info("Loaded Commands.");
    }
    private void setupTabComplete() {
        getCommand("socialmedia").setTabCompleter(new SocialMediaTabCompleter());
        getCommand("ultrahardcore").setTabCompleter(new UltraHardCoreTabCompleter());
        getLogger().info("Loaded Tab Completes.");
    }

    private void setupEvents() {
        getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatEvent(), this);
        getServer().getPluginManager().registerEvents(new ActionBarEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerSleepEvent(), this);
        getServer().getPluginManager().registerEvents(new SocialMediaCommand(), this);
        getServer().getPluginManager().registerEvents(new PlayerDisconnectEvent(), this);
        getLogger().info("Loaded Listeners.");
    }

    private void setupUpdater() {
        new UpdateCheck(this, 108431).getVersion(version -> {
            String DefaultValue = "";
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                DefaultValue += "There is a new update available!";
            } else {
                DefaultValue += "There is no new update available.";
            }
            getLogger().info("Loaded Updater.");
            getLogger().info(DefaultValue);
        });
    }
    public void antiSwearLoad () {
        Set<String> badWords = new HashSet<>();
        File BannedWordsFile = new File(getDataFolder(), "Banned-Words.txt");

        if (!BannedWordsFile.exists()){
            getLogger().warning("Loading Default Banned Words.");
            try {
                BannedWordsFile.createNewFile();
                InputStream DefaultWordsStream = getResource("Banned-Words.txt");
                BufferedReader DefaultWordsReader = new BufferedReader(new InputStreamReader(DefaultWordsStream, StandardCharsets.UTF_8));
                FileWriter BannedWordsWriter = new FileWriter(BannedWordsFile);
                String line = "";
                while ((line = DefaultWordsReader.readLine()) != null) {
                    BannedWordsWriter.write(line + "\n");
                    badWords.add(line.trim());
                }
                BannedWordsWriter.close();
                DefaultWordsReader.close();
                DefaultWordsStream.close();
                getLogger().warning("Loaded Default Banned Words File With " + badWords.size() + " Words");
            } catch (IOException e) {
                getLogger().warning("Failed To Create Default Banned Words File!");

            }
        } else {
            try {
                Files.readAllLines(BannedWordsFile.toPath(), StandardCharsets.UTF_8)
                        .stream()
                        .map(String::trim)
                        .forEach(badWords::add);

                getLogger().info("Loaded Default Banned Words File With " + badWords.size() + " Words.");

            } catch (IOException e) {
                getLogger().warning("Failed To Read Banned Words File!");
                e.printStackTrace();
            }
        }
    }
    public static Main getInstance() {
        return instance;
    }
}

