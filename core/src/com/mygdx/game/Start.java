package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Start extends Screen{
    mButton m1, m2, m3;

    Start(){
        m1 = new mButton("start", (1024/2) - (mButton.bw/2), 325, mButton.bw, mButton.bh, Color.BLUE);
        m2 = new mButton("about", (1024/2) - (mButton.bw/2), 200, mButton.bw, mButton.bh, Color.DARK_GRAY);
        m3 = new mButton("exit", (1024/2) - (mButton.bw/2), 75, mButton.bw, mButton.bh, Color.RED);
    }

    void tap(int x, int y){
        if(m1.hitbox().contains(x, y)) Main.started = true;
        if(m2.hitbox().contains(x, y)) Main.about = true;
    }

    void draw(SpriteBatch batch){
        batch.draw(Resources.title, 0, 0);
        m1.draw(batch);
        m2.draw(batch);
        m3.draw(batch);
    }
}
