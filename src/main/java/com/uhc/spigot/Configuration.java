package com.uhc.spigot;

import org.bukkit.configuration.file.FileConfiguration;

public final class Configuration {

    public static String PUNISHMENT_REASON;
    public static boolean PUNISHMENT_BAN;
    public static boolean JOINOPTIONS_ENABLED;
    public static String JOINOPTIONS_FIRSTJOINANNOUNCEMENTMESSAGE;
    public static String JOINOPTIONS_JOINANNOUNCEMENTMESSAGE;
    public static String JOINOPTIONS_QUITANNOUNCEMENTMESSAGE;
    public static String SOCIALMEDIA_WEBSITE_URL;
    public static String SOCIALMEDIA_INSTAGRAM_URL;
    public static String SOCIALMEDIA_DISCORD_URL;
    public static boolean ACTIONBAROPTIONS_ENABLED;
    public static boolean SLEEPOPTIONS_ONEPLAYERSLEEP_ENABLED;
    public static String SLEEPOPTIONS_ONEPLAYERSLEEP_WAKEUPMESSAGE;
    public static boolean ANTISPAM_ENABLED;
    public static boolean ANTISWEAR_ENABLED;
    public static boolean FORCEDRESOURCEPACK_ENABLED;
    public static String FORCEDRESOURCEPACK_RESOURCEPACKURL;
    public static String TITLE_TITLEMESSAGE;
    public static String TITLE_SUBTITLEMESSAGE;
    public static int TITLE_FADEIN;
    public static int TITLE_STAY;
    public static int TITLE_FADEOUT;

    public static void loadConfig() {
        Main instance = Main.getInstance();
        instance.reloadConfig();
        FileConfiguration config = instance.getConfig();

        PUNISHMENT_REASON = config.getString("Punishment.Reason");
        PUNISHMENT_BAN = config.getBoolean("Punishment.Ban");
        JOINOPTIONS_ENABLED = config.getBoolean("JoinOptions.Enabled");
        JOINOPTIONS_FIRSTJOINANNOUNCEMENTMESSAGE = config.getString("JoinOptions.FirstJoinAnnouncementMessage");
        JOINOPTIONS_JOINANNOUNCEMENTMESSAGE = config.getString("JoinOptions.JoinAnnouncementMessage");
        JOINOPTIONS_QUITANNOUNCEMENTMESSAGE = config.getString("JoinOptions.QuitAnnouncementMessage");
        SOCIALMEDIA_WEBSITE_URL = config.getString("SocialMedia.Website-URL");
        SOCIALMEDIA_INSTAGRAM_URL = config.getString("SocialMedia.Instagram-URL");
        SOCIALMEDIA_DISCORD_URL = config.getString("SocialMedia.Discord-URL");
        ACTIONBAROPTIONS_ENABLED = config.getBoolean("ActionBarOptions.Enabled");
        SLEEPOPTIONS_ONEPLAYERSLEEP_ENABLED = config.getBoolean("SleepOptions.OnePlayerSleep.Enabled");
        SLEEPOPTIONS_ONEPLAYERSLEEP_WAKEUPMESSAGE = config.getString("SleepOptions.OnePlayerSleep.WakeUpMessage");
        ANTISPAM_ENABLED = config.getBoolean("AntiSpam.Enabled");
        ANTISWEAR_ENABLED = config.getBoolean("AntiSwear.Enabled");
        FORCEDRESOURCEPACK_ENABLED = config.getBoolean("ForcedResourcePack.Enabled");
        FORCEDRESOURCEPACK_RESOURCEPACKURL = config.getString("ForcedResourcePack.ResourcePackURL");
        TITLE_TITLEMESSAGE = config.getString("Title.TitleMessage");
        TITLE_SUBTITLEMESSAGE = config.getString("Title.SubTitleMessage");
        TITLE_FADEIN = config.getInt("Title.FadeIn");
        TITLE_STAY = config.getInt("Title.Stay");
        TITLE_FADEOUT = config.getInt("Title.FadeOut");
    }
}
