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

        if (event.getPlayer().hasPermission("modchat.use") && event.getMessage().startsWith("!")) {
            event.setCancelled(true);
            final String message = ChatColor.DARK_RED + "[" + ChatColor.RED + "ModChat" + ChatColor.DARK_RED + "] "
                    + ChatColor.GREEN + event.getPlayer().getName() + ": " + event.getMessage().replace("!", "");

            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("modchat.use")) {
                    player.sendMessage(message);
                }
            }

            Bukkit.getConsoleSender().sendMessage(message);
        }
    }
}