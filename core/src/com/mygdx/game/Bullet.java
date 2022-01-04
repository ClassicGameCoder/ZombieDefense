package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public class Bullet {
    int x, y, w, h, speed;
    float angle;
    String type;
    boolean active = true;

    Bullet(String type, int x, int y){
        this.type = type;
        w = Resources.bullet.getWidth();
        h = Resources.bullet.getHeight();
        this.x = x;
        this.y = y;
        speed = 5;
        angle = calc_angle();
    }
    void draw(SpriteBatch batch){
        batch.draw(Resources.bullet, x, y);
    }

    void update(){
        x += Math.cos(angle) * speed;
        y += Math.sin(angle) * speed;
        zombie_collisions();
    }

    Rectangle hitbox(){ return new Rectangle(x, y, w, h); }

    void zombie_collisions(){
        if(Main.zombies.isEmpty()) return;
        for(Zombie z :Main.zombies) if(z.hitbox().contains(this.hitbox())) {
            z.hp--;
            this.active = false;
        }
    }

    float calc_angle(){
        Zombie closest =  null;
        for(Zombie z : Main.zombies){
            if(closest == null){ closest = z; continue;}
            float closest_dif = (float) Math.sqrt((x - closest.x) * (x - closest.x) + (y- closest.y) * (y - closest.y));
            float z_dif = (float) Math.sqrt((x - z.x) * (x - z.x) + (y- z.y) * (y - z.y));
            if(z_dif < closest_dif) closest = z;
        }
        return (float)(Math.atan((float)(y - (closest.y + closest.h/2))/(float)(x - (closest.x + closest.w/2))) + (x >= closest.x ? Math.PI : 0));
    }
}
