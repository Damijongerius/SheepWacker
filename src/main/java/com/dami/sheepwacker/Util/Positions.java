package com.dami.sheepwacker.Util;

import com.dami.sheepwacker.SheepWacker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Sheep;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Positions implements Runnable{

    private final World world;
    private final PlayArea playArea;
    public Positions(SheepWacker main){
        BukkitScheduler scheduler = main.getServer().getScheduler();
        this.world = main.getServer().getWorld("world");
        this.playArea = PlayArea.getInstance();
        scheduler.scheduleSyncDelayedTask(main, this, 20L);
    }
    @Override
    public void run(){
        Collection<Entity> entities = world.getNearbyEntities(playArea.getPlayArea());
        Collection<Sheep> sheep = sortOnSheep(entities);

        for (Sheep sh : sheep){
            Location location = sh.getLocation();
            Block block = world.getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
            Bukkit.broadcastMessage(block.getType().toString());
            sh.getColor();

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
