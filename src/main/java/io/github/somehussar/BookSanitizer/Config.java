package io.github.somehussar.BookSanitizer;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private static final String illegalSaveAttemptTag = "Announce illegal book sign attempts to moderators";

    private BookSanitizerPlugin instance;
    private FileConfiguration configFile;

    public static boolean announceIllegalBooks = true;

    public Config(BookSanitizerPlugin instance){
        this.instance = instance;
        configFile = instance.getConfig();

        configFile.addDefault(illegalSaveAttemptTag, true);
        configFile.options().copyDefaults(true);

        announceIllegalBooks = configFile.getBoolean(illegalSaveAttemptTag);

        instance.saveConfig();

    }


}
