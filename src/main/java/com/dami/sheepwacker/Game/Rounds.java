package com.dami.sheepwacker.Game;

import com.dami.sheepwacker.Util.ConfigurationManager;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;

public class Rounds {

    private ConfigurationManager configM;

    private List<Integer> secondsForRounds;

    public Rounds(){
        configM  = ConfigurationManager.getConfigurationManager("rounds");

        try{
            //if null try to delete the existing file and replace it with the recource instance
            ConfigurationSection config = configM.getConfig();
            secondsForRounds = config.getIntegerList("timer");

        }catch(Exception ignored){}
    }

    public int getSeconds(int round){
        return secondsForRounds.get(round -1);
    }
}
