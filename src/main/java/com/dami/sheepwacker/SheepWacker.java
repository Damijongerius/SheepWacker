package com.dami.sheepwacker;

import com.dami.sheepwacker.Game.Spawn;
import com.dami.sheepwacker.Util.ConfigurationManager;
import com.dami.sheepwacker.Util.Positions;
import com.dami.sheepwacker.Util.ScoreBoardManager;
import org.bukkit.WeatherType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class SheepWacker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();

        ConfigurationManager.setMainClass(this);

        new Positions(this);

        Spawn spawn = new Spawn(getServer().getWorld("world"));
        spawn.spawnSheep(1);

        StringUtils.countMatches(message, key)

    }

    @EventHandler
    public void WhenPlayerJoin(PlayerJoinEvent event){

        ScoreBoardManager sbm = new ScoreBoardManager();

        sbm.setPlayScore(event.getPlayer());
    }

}
