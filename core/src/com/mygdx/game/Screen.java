package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen {
    BitmapFont font = new BitmapFont();
    GlyphLayout layout = new GlyphLayout();

    abstract void draw(SpriteBatch batch);
    abstract void tap(int x, int y);
}
