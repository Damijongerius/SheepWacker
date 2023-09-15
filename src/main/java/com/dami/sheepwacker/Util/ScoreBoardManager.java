package com.dami.sheepwacker.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreBoardManager {

    public void setPlayScore(Player player){
        //round, time, powerUp, points, alive sheep, missed sheep, correct sheep
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("PlayScoreBoard", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.BLUE + "Sheep Wacker");

        Score map =  objective.getScore("Map: Challenger Arena");
        Score roundTime = objective.getScore("Round: 1/100 time left: 10s");
        Score alive = objective.getScore("sheep left: 1");
        Score blank1  =  objective.getScore("");
        Score points = objective.getScore("Points: 100");
        Score wrongPoints = objective.getScore("Wrong: 5");
        Score blank2 = objective.getScore("");
        Score ip = objective.getScore("made by: Dami and Kenshiro");
        Score date = objective.getScore("16:31 06/08/2023");

        map.setScore(15);
        roundTime.setScore(14);
        alive.setScore(13);
        blank1.setScore(12);
        points.setScore(11);
        wrongPoints.setScore(10);
        blank2.setScore(9);
        ip.setScore(8);
        date.setScore(7);

        player.setScoreboard(scoreboard);
    }

    public void setViewerScore(){

    }
}
