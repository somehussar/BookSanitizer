package io.github.somehussar.BookSanitizer.listeners;

import io.github.somehussar.BookSanitizer.BookSanitizerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

public class PlayerListener implements Listener {

    private BookSanitizerPlugin plugin;

    public PlayerListener(BookSanitizerPlugin instance){
        this.plugin = instance;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBookEdit(PlayerEditBookEvent event){


    }
}
