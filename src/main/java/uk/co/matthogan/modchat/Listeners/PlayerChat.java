package uk.co.matthogan.modchat.Listeners;

/*
 * File: PlayerChat.java
 * CopyRight (C) Matthew Hogan 2014 All rights reserved.
 * Do not duplicate, publish, modify or otherwise distribute.
 */

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author Matthew Hogan
 */
public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        // TODO: Allow users to choose their own chat identifier.
        if (event.getPlayer().hasPermission("modchat.use") && event.getMessage().startsWith("!")) {

            // Stop the message from being broadcast in global chat
            event.setCancelled(true);

            String message = ChatColor.DARK_RED + "[" + ChatColor.RED + "ModChat" + ChatColor.DARK_RED + "] "
                    + ChatColor.GREEN + event.getPlayer().getName() + ": " + event.getMessage().replace("!", "");

            // Send the mod-chat message to only the players with the correct permission.
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("modchat.use")) {
                    player.sendMessage(message);
                }
            }

            // TODO: Add a not-shit logging functionality
            // Creates a getto log of what's being said in the mod-chat
            Bukkit.getConsoleSender().sendMessage(message);
        }
    }
}