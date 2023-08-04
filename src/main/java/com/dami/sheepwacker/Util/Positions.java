package com.dami.sheepwacker.Util;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Sheep;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Positions {

    private final World world;
    private final PlayArea playArea;
    public Positions(World world){
        this.world = world;
        this.playArea = PlayArea.getInstance();
    }
    private void onSecond(){
        Collection<Entity> entities = world.getNearbyEntities(playArea.getPlayArea());
        Collection<Sheep> sheep = sortOnSheep(entities);

        for (Sheep sh : sheep){
            //sh.getLocation();
            //world.getBlockAt();
        }
    }

    @NotNull
    private Collection<Sheep> sortOnSheep(Collection<Entity> entities){
        Collection<Sheep> sheep = new HashSet<>();

        for(Entity entity : entities){
            if(entity instanceof Sheep){
                sheep.add((Sheep) entity);
            }
        }

        return sheep;
    }
}