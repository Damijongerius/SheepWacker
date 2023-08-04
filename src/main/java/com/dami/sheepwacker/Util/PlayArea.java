package com.dami.sheepwacker.Util;

import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class PlayArea {

    private final BoundingBox playArea;
    private final BoundingBox spawnArea;
    private static PlayArea instance;

    // Private constructor to prevent instantiation from other classes
    private PlayArea() {
        Vector minusVector = new Vector(-18, -10, -18);
        Vector plusVector = new Vector(18,10,18);
        playArea = BoundingBox.of(minusVector,plusVector);

        Vector minusVector2 = new Vector(-5, 1, -5);
        Vector plusVector2 = new Vector(5,1,5);

        spawnArea = BoundingBox.of(minusVector2,plusVector2);
    }

    // Public static method to provide access to the single instance
    public static PlayArea getInstance() {
        // Lazy initialization: create the instance only when it is requested for the first time
        if (instance == null) {
            instance = new PlayArea();
        }
        return instance;
    }

    public BoundingBox getPlayArea(){
        return playArea;
    }

    public BoundingBox getSpawnArea() {
        return spawnArea;
    }
}
