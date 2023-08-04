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

            if(block.getType().toString().contains("CONCRETE")){
                DyeColor color = sh.getColor() != null ? sh.getColor() : DyeColor.WHITE;

                if(compareColor(color, block.getType())){
                    Bukkit.broadcastMessage("sheep is standing on correct position");
                }else{
                    Bukkit.broadcastMessage("sheep is in the wrong place");
                }

            }

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
        return switch (sheepColor){
            case RED -> blockMaterial == Material.RED_CONCRETE;

            case BLUE -> blockMaterial == Material.BLUE_CONCRETE;

            case CYAN -> blockMaterial == Material.CYAN_CONCRETE;

            case GRAY -> blockMaterial == Material.GRAY_CONCRETE;

            case LIME -> blockMaterial == Material.LIME_CONCRETE;

            case PINK -> blockMaterial == Material.PINK_CONCRETE;

            case BLACK -> blockMaterial == Material.BLACK_CONCRETE;

            case BROWN -> blockMaterial == Material.BROWN_CONCRETE;

            case GREEN -> blockMaterial == Material.GREEN_CONCRETE;

            case WHITE -> blockMaterial == Material.WHITE_CONCRETE;

            case ORANGE -> blockMaterial == Material.ORANGE_CONCRETE;

            case PURPLE -> blockMaterial == Material.PURPLE_CONCRETE;

            case YELLOW -> blockMaterial == Material.YELLOW_CONCRETE;

            case MAGENTA -> blockMaterial == Material.MAGENTA_CONCRETE;

            case LIGHT_BLUE -> blockMaterial == Material.LIGHT_BLUE_CONCRETE;

            case LIGHT_GRAY -> blockMaterial == Material.LIGHT_GRAY_CONCRETE;

        };
    }
}
