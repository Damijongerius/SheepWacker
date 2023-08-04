package com.dami.sheepwacker.Game;

import com.dami.sheepwacker.Util.ColorRandomizer;
import com.dami.sheepwacker.Util.ConfigurationManager;
import com.dami.sheepwacker.Util.PlayArea;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.util.BoundingBox;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Spawn {

    private ConfigurationManager configM;

    private BoundingBox spawnArea;

    private World world;

    private List<Integer> rounds;
    public Spawn(World world){
        this.world = world;
        spawnArea = PlayArea.getInstance().getSpawnArea();
        configM = new ConfigurationManager("Rounds");

        configM.saveConfig();

        try{
            //if null try to delete the existing file and replace it with the recource instance
            ConfigurationSection config = configM.getConfig();
            rounds = config.getIntegerList("rounds");

        }catch(Exception ignored){}
    }

    public void spawnSheep(int round){
        int playRound = rounds.get(round - 1);
        for(int i = 0 ; i < playRound ; i++){
            double x = Math.random() * (Math.abs(spawnArea.getMinX()) + spawnArea.getMaxX()) + (Math.min(0, spawnArea.getMinX()));
            double y = spawnArea.getMaxY();
            double z = Math.random() * (Math.abs(spawnArea.getMinZ()) + spawnArea.getMaxZ()) + (Math.min(0, spawnArea.getMinZ()));
            System.out.println(x + "-" + z);
            Location spawnLocation = new Location(world, x, y, z);
            setSheep(spawnLocation);
        }
    }
    private void setSheep(@NotNull Location location){
        Sheep sheep = (Sheep) Objects.requireNonNull(location.getWorld()).spawnEntity(location, EntityType.SHEEP);
        sheep.setColor(ColorRandomizer.getColor());
    }
}
