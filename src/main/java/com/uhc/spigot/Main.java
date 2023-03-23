package com.uhc.spigot;

import com.uhc.spigot.Commands.*;
import com.uhc.spigot.Listeners.*;
import com.uhc.spigot.Checks.UpdateCheck;
import com.uhc.spigot.TabCompleters.SocialMediaTabCompleter;
import com.uhc.spigot.TabCompleters.UltraHardCoreTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
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
        getCommand("socialmedia").setExecutor(new SocialMediaCommand(this));
        getCommand("ultrahardcore").setExecutor(new UltraHardCoreCommand(this));
        getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Commands.");
    }
    private void setupTabComplete() {
        getCommand("socialmedia").setTabCompleter(new SocialMediaTabCompleter());
        getCommand("ultrahardcore").setTabCompleter(new UltraHardCoreTabCompleter());
        getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Tab Completers.");
    }

    private void setupEvents() {
        getServer().getPluginManager().registerEvents(new RespawnEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerChatEvent(this), this);
        getServer().getPluginManager().registerEvents(new ActionBarEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new SocialMediaCommand(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDisconnectEvent(this), this);
        getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Listeners.");
    }

    private void setupUpdater() {
        new UpdateCheck(this, 108431).getVersion(version -> {
            String DefaultValue = "[UltraHardCore] ";
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                DefaultValue += "There is a new update available!";
            } else {
                DefaultValue += "There is no new update available.";
            }
            getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Updater.");
            getServer().getConsoleSender().sendMessage(DefaultValue);
        });
    }

}

