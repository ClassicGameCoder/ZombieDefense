package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Wall {
    int x, y, w, h;
    int hp = 10;
    boolean active = true;
    ArrayList<Cannon> cannons = new ArrayList<Cannon>();

    Wall(int x, int y, boolean is_mounted){
        this.x = x;
        this.y = y;
        w = Resources.wall.getWidth();
        h = Resources.wall.getHeight();
        if(is_mounted) load_cannons();


    }

    void load_cannons(){
        for(int i = 0; i < 10; i++) cannons.add(new Cannon("mounted", x, y + i * 50));
    }

    void update(){
        for(Cannon c: cannons) c.update();
        active = hp > 0;
    }

    void draw(SpriteBatch batch){
        batch.draw(Resources.wall, x, y);
        for (Cannon c : cannons) c.draw(batch);
    }

    Rectangle hitbox(){return new Rectangle(x, y, w, h);}
}
