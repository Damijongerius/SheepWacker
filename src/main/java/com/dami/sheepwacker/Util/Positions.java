package com.dami.sheepwacker.Util;

import com.dami.sheepwacker.SheepWacker;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Sheep;
import org.bukkit.material.Wool;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Positions implements Runnable{

    private final World world;
    private final SheepWacker main;
    private final PlayArea playArea;
    public Positions(SheepWacker main){
        this.main = main;
        this.world = main.getServer().getWorld("world");
        this.playArea = PlayArea.getInstance();
        ReDo();
    }
    @Override
    public void run(){
        Collection<Entity> entities = world.getNearbyEntities(playArea.getPlayArea());
        Collection<Sheep> sheep = sortOnSheep(entities);

        for (Sheep sh : sheep){
            Location location = sh.getLocation();
            Block block = world.getBlockAt(location.getBlockX(), location.getBlockY() - 1, location.getBlockZ());
            Bukkit.broadcastMessage(block.getType().toString());
            sh.getColor();

        }

        ReDo();
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

    private void ReDo(){
        BukkitScheduler scheduler = main.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(main, this, 20L);
    }

    private boolean compareColor(DyeColor sheepColor, Material blockMaterial){
        switch (sheepColor){
            case RED -> {
                if(blockMaterial == Material.RED_CONCRETE){
                return true;
                }
            }
            case BLUE -> {
                    if(blockMaterial == Material.BLUE_CONCRETE){
                        return true;
                    }

            }
            case CYAN -> {
                if(blockMaterial == Material.CYAN_CONCRETE){
                    return true;
                }
            }
            case GRAY -> {
                if(blockMaterial == Material.GRAY_CONCRETE){
                    return true;
                }
            }
            case LIME -> {
                if(blockMaterial == Material.LIME_CONCRETE){
                    return true;
                }
            }
            case PINK -> {
                if(blockMaterial == Material.PINK_CONCRETE){
                    return true;
                }
            }
            case BLACK -> {
                if(blockMaterial == Material.BLACK_CONCRETE){
                    return true;
                }
            }
            case BROWN -> {
                if(blockMaterial == Material.BROWN_CONCRETE){
                    return true;
                }
            }
            case GREEN -> {
                if(blockMaterial == Material.GREEN_CONCRETE){
                    return true;
                }
            }
            case WHITE -> {
                if(blockMaterial == Material.WHITE_CONCRETE){
                    return true;
                }
            }
            case ORANGE -> {
                if(blockMaterial == Material.ORANGE_CONCRETE){
                    return true;
                }
            }
            case PURPLE -> {
                if(blockMaterial == Material.PURPLE_CONCRETE){
                    return true;
                }
            }
            case YELLOW -> {
                if(blockMaterial == Material.YELLOW_CONCRETE){
                    return true;
                }
            }
            case MAGENTA -> {
                if(blockMaterial == Material.MAGENTA_CONCRETE){
                    return true;
                }
            }
            case LIGHT_BLUE -> {
                if(blockMaterial == Material.LIGHT_BLUE_CONCRETE){
                    return true;
                }
            }
            case LIGHT_GRAY -> {
                if(blockMaterial == Material.LIGHT_GRAY_CONCRETE){
                    return true;
                }
            }
        }
    }
}
