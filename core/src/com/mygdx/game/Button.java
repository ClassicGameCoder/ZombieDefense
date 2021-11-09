package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;
import java.util.Locale;

public class Button {
    int x, y, w, h;
    String type;
    boolean locked, selected;
    ToolTip t;

    Button(String type, int x, int y){
        this.type = type;
        w = (Tables.button_resources.get(type) == null ? Resources.button_cannon : Tables.button_resources.get(type)).getWidth();
        h = (Tables.button_resources.get(type) == null ? Resources.button_cannon : Tables.button_resources.get(type)).getHeight();
        this.x = x;
        this.y = y;
        locked = true;
        selected = false;
        t = type.equals("close") ? null : new ToolTip(type, this);
    }
    void draw(SpriteBatch batch){
        batch.draw((Tables.button_resources.get(type) == null ? Resources.button_cannon : Tables.button_resources.get(type)), x, y);
        if(t != null) t.draw(batch);
        if(locked) batch.draw(Resources.button_locked, x, y);
        if(selected) batch.draw(Resources.button_selected, x-7, y-7);
    }

    Rectangle hitbox(){ return new Rectangle(x, y, w, h); }

    void update(){}
}
