package io.github.somehussar.BookSanitizer.listeners;

import io.github.somehussar.BookSanitizer.BookSanitizerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class PlayerListener implements Listener {

    private BookSanitizerPlugin plugin;

    public PlayerListener(BookSanitizerPlugin instance){
        this.plugin = instance;
    }

    /**
     * Create a sanitized instance of BookMeta
     * @param bookToSanitize Meta of a book you would like to sanitize
     * @param event PlayerEditBookEvent
     * @return
     */
    private BookMeta sanitizeData(BookMeta bookToSanitize, PlayerEditBookEvent event){
        //Sanitized item info
        BookMeta newMeta = (BookMeta) Bukkit.getItemFactory().getItemMeta(Material.WRITTEN_BOOK);

        //Copying over essential data
        newMeta.setPages( bookToSanitize.getPages() );

        if(event.isSigning()) {
            newMeta.setAuthor( event.getPlayer().getName() );
            newMeta.setTitle( ChatColor.stripColor(bookToSanitize.getTitle()) );
        }

        return newMeta;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBookEdit(PlayerEditBookEvent event){
        //Potentially contaminated item info
        BookMeta sentMeta = event.getNewBookMeta();
        //Sanitized item
        BookMeta safeData = sanitizeData(sentMeta, event);
        //Send the sanitized book data back to the event
        event.setNewBookMeta(safeData);
    }
}
