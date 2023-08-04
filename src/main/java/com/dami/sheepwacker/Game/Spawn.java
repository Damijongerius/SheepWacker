package com.dami.sheepwacker.Game;

import com.dami.sheepwacker.Util.ConfigurationManager;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;

public class Spawn {

    private ConfigurationManager configM;

    private List<Integer> rounds;
    public Spawn(){
        configM = new ConfigurationManager("Rounds");
        configM.saveConfig();

        try{
            ConfigurationSection config = configM.getConfig();
            rounds = config.getIntegerList("rounds");

        }catch(Exception ignored){}
    }

    public void spawnSheep(int round){
        int playRound = rounds.get(round - 1);
    }
}
