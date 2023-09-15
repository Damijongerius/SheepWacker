package com.dami.sheepwacker.Game;

import com.dami.sheepwacker.SheepWacker;
import com.dami.sheepwacker.Util.PlayArea;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitScheduler;

public class GameManager implements Runnable {

    private final World world;
    private final SheepWacker main;
    private final PlayArea playArea;
    public GameManager(SheepWacker main){
        this.main = main;
        this.world = main.getServer().getWorld("world");
        this.playArea = PlayArea.getInstance();
        reRun();
    }

    @Override
    public void run() {

        reRun();
    }

    private void reRun(){
        BukkitScheduler scheduler = main.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(main, this);
    }

    //tijd, rondes,
}
