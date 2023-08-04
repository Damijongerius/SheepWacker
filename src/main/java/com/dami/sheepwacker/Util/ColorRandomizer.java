package com.dami.sheepwacker.Util;
import org.bukkit.Color;
import org.bukkit.DyeColor;

import java.util.Random;

public class ColorRandomizer {
    // Member variables (properties about the object)
    private final static DyeColor[] mColors = {
           DyeColor.ORANGE,
            DyeColor.MAGENTA,
            DyeColor.YELLOW,
            DyeColor.PURPLE,
            DyeColor.WHITE,
            DyeColor.LIGHT_GRAY,
            DyeColor.LIGHT_BLUE,
            DyeColor.GREEN,
            DyeColor.BROWN,
            DyeColor.BLACK,
            DyeColor.PINK,
            DyeColor.LIME,
            DyeColor.GRAY,
            DyeColor.CYAN,
            DyeColor.BLUE,
            DyeColor.RED
    };

    // Method (abilities: things the object can do)
    public static DyeColor getColor() {
        DyeColor color = DyeColor.WHITE;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];

        return color;
    }
}