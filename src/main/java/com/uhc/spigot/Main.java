package com.uhc.spigot;

import com.uhc.spigot.Commands.UnBanCommand;
import com.uhc.spigot.Events.RespawnEvent;
import com.uhc.spigot.UpdateChecker.UpdateCheck;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        setupCommands();
        setupEvents();
        setupUpdater();
    }

    private void setupCommands() {
        getCommand("unban").setExecutor(new UnBanCommand());
        getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Commands");
    }

    private void setupEvents() {
        getServer().getPluginManager().registerEvents(new RespawnEvent(this), this);
        getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Listeners");
    }

    private void setupUpdater() {
        new UpdateCheck(this, 100307).getVersion(version -> {
            String DefaultValue = "[UltraHardCore] ";
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                DefaultValue += "There is a new update available!";
            } else {
                DefaultValue += "There is no new update available.";
            }
            getServer().getConsoleSender().sendMessage(DefaultValue);
            getServer().getConsoleSender().sendMessage("[UltraHardCore] Loaded Updater");
        });
    }
}

