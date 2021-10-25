package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public class Cannon {
    int x, y, w, h;
    String type;

    Cannon(String type, int x, int y){
        this.type = type;
        w = 50;
        h = 50;
        this.x = gridlock(x - w/2);
        this.y = gridlock(y - h/2);
    }

    void draw(SpriteBatch batch){
        batch.draw(Tables.cannon_resources.get(type) == null? Resources.cannon: Tables.cannon_resources.get(type), x, y);
    }

    void update(){}

    int gridlock(int n){
        return ((n + 25) / 50) * 50;
    }
    Rectangle hitbox(){ return new Rectangle(x, y, w, h); }
}
