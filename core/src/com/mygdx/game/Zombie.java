package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.Rectangle;

public class Zombie {
    int x, y, w, h, speed, hp;
    String type;
    boolean active = true;

    int cols = 4, rows = 1;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time;
    Rectangle hitbox(){ return new Rectangle(x, y, w, h); }

    Zombie(String type, int x, int y, int speed){
        this.type = type;
        this.x = x;
        this.y = y;
        this.speed = speed;

        w = 50;
        h = 50;
        hp = 5;

        prep_animations();
    }

    void draw(SpriteBatch batch){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time, true);
        batch.draw(frame, x, y);
    }

    void update(){
        x -= speed;
        active = x >= 0 && hp > 0;
    }

    void prep_animations(){
            TextureRegion[][] sheet = TextureRegion.split(Resources.zombie,
                    Resources.zombie.getWidth()/cols,
                    Resources.zombie.getHeight()/rows);
            frames = new TextureRegion[rows*cols];
            int index = 0;
            for(int r=0; r<rows; r++)
                for(int c  = 0; c < cols; c++)
                    frames[index++] = sheet[r][c];

                anim = new Animation(0.2f, frames);
        }
}
