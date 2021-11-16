package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Tables {
    static HashMap<String, Texture> cannon_resources =  new HashMap<String, Texture>();
    static HashMap<String, Texture> button_resources =  new HashMap<String, Texture>();
    static HashMap<String, Texture> zombie_resources =  new HashMap<String, Texture>();
    static HashMap<String, String> tooltips =  new HashMap<String, String>();
    static HashMap<String, Integer> values =  new HashMap<String, Integer>();

    static void init(){
        cannon_resources.put("fire", Resources.cannon_fire);
        cannon_resources.put("super", Resources.cannon_super);
        cannon_resources.put("double", Resources.cannon_double);
        cannon_resources.put("laser", Resources.cannon_laser);
        cannon_resources.put("mounted", Resources.cannon_mounted);

        button_resources.put("fire", Resources.button_cannon_fire);
        button_resources.put("super", Resources.button_cannon_super);
        button_resources.put("double", Resources.button_cannon_double);
        button_resources.put("laser", Resources.button_cannon_laser);
        button_resources.put("mounted", Resources.button_cannon_mounted);
        button_resources.put("play", Resources.button_play);
        button_resources.put("pause", Resources.button_pause);
        button_resources.put("start", Resources.button_start);
        button_resources.put("exit", Resources.button_exit);
        button_resources.put("close", Resources.button_close);

        zombie_resources.put("dif", Resources.zombie_dif);
        zombie_resources.put("fast", Resources.zombie_fast);
        zombie_resources.put("speedy", Resources.zombie_speedy);
        zombie_resources.put("riot", Resources.zombie_riot);

        tooltips.put("fire", "Fires high damage bullets at a high rate of fire.");
        tooltips.put("super", "Fires low damage bullets at a low rate of fire. Does not degrade.");
        tooltips.put("double", "Fires two low damage bullets at a low rate of fire.");
        tooltips.put("laser", "Fires one giant bullet at a very slow rate of fire.");
        tooltips.put("mounted", "Fires low damage bullets at a low rate of fire.");

        //CANNON PLACEMENT COSTS
        values.put("place_fire", 30);
        values.put("place_super", 25);
        values.put("place_double", 20);
        values.put("place_laser", 100);

        //CANNON UNLOCK COSTS
        values.put("unlock_fire", 300);
        values.put("unlock_super", 500);
        values.put("unlock_double", 250);
        values.put("unlock_laser", 1000);
        values.put("unlock_mounted", 300);

        //CANNON FIRE DELAYS
        values.put("delay_fire", 10);
        values.put("delay_double", 40);
        values.put("delay_laser", 100);

        //ZOMBIE SPEED
        values.put("speed_dif", 1);
        values.put("speed_speedy", 5);
        values.put("speed_fast", 3);
        values.put("speed_riot", 1);

        //ZOMBIE HEALTH
        values.put("health_dif", 4);
        values.put("health_speedy", 2);
        values.put("health_fast", 3);
        values.put("health_riot", 10);

        //ANIMATION COLUMNS
        values.put("columns_laser", 16);
        values.put("columns_speedy", 6);
    }
}
