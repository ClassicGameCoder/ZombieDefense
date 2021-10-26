package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public class Cannon {
    Sprite sprite;
    int x, y, w, h;
    String type;

    Cannon(String type, int x, int y){
        sprite = new Sprite(Tables.cannon_resources.get(type) == null ? Resources.cannon : Tables.cannon_resources.get(type));
        this.type = type;
        w = 50;
        h = 50;
        this.x = gridlock(x - w/2);
        this.y = gridlock(y - h/2);
        sprite.setPosition(this.x, this.y);
    }

    void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    void update(){
        sprite.setRotation(calc_angle());
        fire();
    }

    void fire(){
        Main.bullets.add(new Bullet("bbb", x + w/2, y + h/2));
    }

    int gridlock(int n){
        return ((n + 25) / 50) * 50;
    }
    Rectangle hitbox(){ return new Rectangle(x, y, w, h); }

    float calc_angle(){
        float zx = Main.zombies.get(0).x - (float)(Main.zombies.get(0).w/2), zy = Main.zombies.get(0).y - (float)(Main.zombies.get(0).h/2);
        return (float)Math.toDegrees(Math.atan((y - zy)/(x - zx)) + (x >= zx ? Math.PI : 0));
    }
}
