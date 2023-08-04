package com.dami.sheepwacker;

import com.dami.sheepwacker.Game.Spawn;
import com.dami.sheepwacker.Util.ConfigurationManager;
import com.dami.sheepwacker.Util.Positions;
import org.bukkit.WeatherType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.concurrent.ThreadLocalRandom;

public final class SheepWacker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        ConfigurationManager.setMainClass(this);

        new Positions(this);

        Spawn spawn = new Spawn(getServer().getWorld("world"));
        spawn.spawnSheep(1);
    }

}
