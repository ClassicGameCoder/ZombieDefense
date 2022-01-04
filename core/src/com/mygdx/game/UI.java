package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    static BitmapFont font = new BitmapFont();
    static int money = 10000000;
    static int wave = 0;
    static int score = 0;

    static void draw(SpriteBatch b){
        font.getData().setScale(2f);
        font.setColor(Color.GOLD);
        font.draw(b, "Money: " + money, 2, 597);
        font.setColor(Color.MAGENTA);
        font.draw(b, "Wave: " + wave, 2, 597 - 12 * font.getData().scaleX - 3);
        font.setColor(Color.GOLD);
        font.draw(b, "Score: " + score, 2, 597 - 12 * font.getData().scaleX * 2 - 6);
        font.getData().setScale(1f);
    }
}
