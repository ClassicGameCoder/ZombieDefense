package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameEnds {
    mButton m1;

    GameEnds(){
        m1= new mButton("back", (1024/2) - (mButton.bw/2), 325, mButton.bw, mButton.bh);
    }

    void tap(int x, int y){
        if(m1.hitbox().contains(x, y))
            Main.about = false;
            Main.gameover = false;
    }

    void draw(SpriteBatch batch){
        ScreenUtils.clear(new Color(0x15100300));
        m1.draw(batch);
    }
}
