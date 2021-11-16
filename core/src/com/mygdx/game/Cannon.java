package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.Rectangle;

public class Cannon {
    Sprite sprite;
    int x, y, w, h;
    String type;
    int counter = 0, delay;

    int cols, rows = 1;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time;

    Cannon(String type, int x, int y){
        sprite = new Sprite(Tables.cannon_resources.get(type) == null ? Resources.cannon : Tables.cannon_resources.get(type));
        this.type = type;
        delay = Tables.values.get("delay_" + type) == null ? 30 : Tables.values.get("delay_" + type);
        cols = Tables.values.get("columns_" + type) == null ? 1 : Tables.values.get("columns_" + type);
        w = (Tables.cannon_resources.get(type) == null ? Resources.cannon : Tables.cannon_resources.get(type)).getWidth() / cols;
        h = (Tables.cannon_resources.get(type) == null ? Resources.cannon : Tables.cannon_resources.get(type)).getHeight() / rows;
        this.x = gridlock(x - w/2);
        this.y = gridlock(y - h/2);
        sprite.setPosition(this.x, this.y);
        prep_animations();
    }

    void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    void update(){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time, true);
        sprite = new Sprite(frame);
        sprite.setPosition(this.x, this.y);
        sprite.setRotation(calc_angle());
        fire();
    }

    void fire(){
        if(counter++ <delay) return;
        counter = 0;
        Main.bullets.add(new Bullet("bbb", x + w/2, y + h/2));
    }

    int gridlock(int n){
        return ((n + 25) / 50) * 50;
    }
    Rectangle hitbox(){ return new Rectangle(x, y, w, h); }

    float calc_angle(){
        float zx = Main.zombies.get(0).x + (float)(Main.zombies.get(0).w/2), zy = Main.zombies.get(0).y + (float)(Main.zombies.get(0).h/2);
        return (float)Math.toDegrees(Math.atan((y - zy)/(x - zx)) + (x >= zx ? Math.PI : 0));
    }

    void prep_animations(){
        TextureRegion[][]sheet = TextureRegion.split(Tables.cannon_resources.get(type) == null ? Resources.cannon:Tables.cannon_resources.get(type),
                w, h);
        frames = new TextureRegion[rows*cols];
        int index = 0;
        for(int r=0; r<rows; r++)
            for(int c  = 0; c < cols; c++)
                frames[index++] = sheet[r][c];

        anim = new Animation(0.2f, frames);
    }
}
