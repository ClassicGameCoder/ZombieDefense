package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class mButton {
    int x, y, w, h, ox, oy, sx, sy, sw, sh;
    String type;
    BitmapFont font = new BitmapFont();
    GlyphLayout layout = new GlyphLayout();

    mButton(String type, int x, int y, int w, int h){
         this.type = type;
         layout.setText(
                 font,
                 type.equals("start") ? "Start":
                 type.equals("about") ? "About" : "Button"
         );
         this.x = ox = x;
         this.y = oy = y;
         this.w = w;
         this.h = h;
         sx = 0;
         sy = 0;
         sw = 15;
         sh = 15;
    }
    void draw(SpriteBatch batch){
        batch.draw(Resources.button_start,x, y, ox, oy, w, h, 1f, 1f, 0f, sx, sy, sw, sh, false, false);
    }
}
