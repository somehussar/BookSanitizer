package io.github.somehussar.BookSanitizer;

import io.github.somehussar.BookSanitizer.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BookSanitizerPlugin extends JavaPlugin {

    private static BookSanitizerPlugin INSTANCE;


    public static BookSanitizerPlugin getInstance(){
        return INSTANCE;
    }


    @Override
    public void onLoad(){
        INSTANCE = this;
    }
    @Override
    public void onEnable(){

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    @Override
    public void onDisable(){

    }

}
