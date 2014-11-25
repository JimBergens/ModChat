package uk.co.matthogan.modchat;

/*
 * File: Main.java
 * CopyRight (C) Matthew Hogan 2014 All rights reserved.
 * Do not duplicate, publish, modify or otherwise distribute.
 */

import org.bukkit.plugin.java.JavaPlugin;

import uk.co.matthogan.modchat.Listeners.PlayerChat;

/**
 * @author Matthew Hogan
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() { this.getServer().getPluginManager().registerEvents(new PlayerChat(), this); }
}