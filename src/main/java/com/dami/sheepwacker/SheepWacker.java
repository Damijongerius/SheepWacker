package com.dami.sheepwacker;

import com.dami.sheepwacker.Util.Positions;
import org.bukkit.WeatherType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SheepWacker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("plugin werkt toch wel");
        getServer().getPluginManager().registerEvents(this,this);
        new Positions(getServer().getWorld("world"));
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        System.out.println("player joined" + e.getPlayer().getName());
        e.setJoinMessage("welcome to being gay " + e.getPlayer().getName());
    }
}
