package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button {
    int x, y, w, h;
    String type;

    Button(String type, int x, int y){
        this.type = type;
        w = 50;
        h = 50;
        this.x = x;
        this.y = y;
    }
    void draw(SpriteBatch batch){
        batch.draw(Resources.button_cannon, x, y);
    }

    void update(){}
}
