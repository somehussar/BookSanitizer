package io.github.somehussar.BookSanitizer;

import io.github.somehussar.BookSanitizer.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BookSanitizerPlugin extends JavaPlugin {

    private static Config CONFIGS;
    private static BookSanitizerPlugin INSTANCE;


    public static BookSanitizerPlugin getInstance(){
        return INSTANCE;
    }

    public static Config getConfigs(){
        return CONFIGS;
    }

    @Override
    public void onLoad(){
        INSTANCE = this;
    }
    @Override
    public void onEnable(){
        CONFIGS = new Config(this);

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    @Override
    public void onDisable(){

    }

}
