package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Zombie {
    int x, y, w, h, speed;
    String type;
    boolean active = true;

    int cols = 4, rows = 1;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time;

    Zombie(String type, int x, int y, int speed){
        this.type = type;
        this.x = x;
        this.y = y;
        this.speed = speed;

        w = 50;
        h = 50;

        prep_animations();
    }

    void draw(SpriteBatch batch){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time, true);
        batch.draw(frame, x, y);
    }

    void update(){
        active = x >= 0;
        x -= speed;
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
