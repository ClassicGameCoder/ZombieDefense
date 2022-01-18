package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Resources {
    //TODO: UI ELEMENTS
    static Texture bg = new Texture(Gdx.files.internal("DungeonBackground.png"));
    static Texture title = new Texture(Gdx.files.internal("ztdtitle.png"));
    static Texture red_bar = new Texture(Gdx.files.internal("red_bar.png"));
    static Texture green_bar = new Texture(Gdx.files.internal("green_bar.png"));
    static Texture tooltip_bg = new Texture(Gdx.files.internal("ttbg.png"));

    //TODO: BUTTONS
    static Texture button_cannon = new Texture(Gdx.files.internal("CannonIcon.png"));
    static Texture button_cannon_fire = new Texture(Gdx.files.internal("FireCannonIcon.png"));
    static Texture button_cannon_super = new Texture(Gdx.files.internal("SuperCannonIcon.png"));
    static Texture button_cannon_double = new Texture(Gdx.files.internal("doubleCannonIcon.png"));
    static Texture button_cannon_laser = new Texture(Gdx.files.internal("laserCannonIcon.png"));
    static Texture button_cannon_mounted = new Texture(Gdx.files.internal("mountedCannonIcon.png"));
    static Texture button_play = new Texture(Gdx.files.internal("play.png"));
    static Texture button_pause = new Texture(Gdx.files.internal("pause.png"));
    static Texture button_start = new Texture(Gdx.files.internal("startButton.png"));
    static Texture button_exit = new Texture(Gdx.files.internal("exitButton.png"));
    static Texture button_selected = new Texture(Gdx.files.internal("border.png"));
    static Texture button_locked = new Texture(Gdx.files.internal("locked.png"));
    static Texture button_close = new Texture(Gdx.files.internal("x.png"));
    static Texture button_wall = new Texture(Gdx.files.internal("WallIcon.png"));
    static Texture wall = new Texture(Gdx.files.internal("Wall.png"));

    //TODO: CANNONS
    static Texture cannon = new Texture(Gdx.files.internal("Cannon.png"));
    static Texture cannon_fire = new Texture(Gdx.files.internal("Firecannon.png"));
    static Texture cannon_super = new Texture(Gdx.files.internal("SuperCannon.png"));
    static Texture cannon_double = new Texture(Gdx.files.internal("doubleCannon.png"));
    static Texture cannon_laser = new Texture(Gdx.files.internal("laserCannon.png"));
    static Texture cannon_mounted = new Texture(Gdx.files.internal("mountedCannon.png"));
    static Texture damaged = new Texture(Gdx.files.internal("damaged.png"));

    //TODO: BULLETS
    static Texture bullet = new Texture(Gdx.files.internal("Bullet.png"));

    //TODO: ZOMBIES
    static Texture zombie = new Texture(Gdx.files.internal("Zombies.png"));
    static Texture zombie_dif = new Texture(Gdx.files.internal("DifZombies.png"));
    static Texture zombie_fast = new Texture(Gdx.files.internal("Fastzombies.png"));
    static Texture zombie_speedy = new Texture(Gdx.files.internal("speedy_zombie.png"));
    static Texture zombie_riot = new Texture(Gdx.files.internal("riotzombieBIG.png"));

    //TODO: EFFECTS
    static Texture boom = new Texture(Gdx.files.internal("boom.png"));
    static Texture click = new Texture(Gdx.files.internal("click_effect.png"));

    static Texture tan = create_texture(50, 50, Color.TAN);
    static Texture dark = create_texture(50, 50, Color.DARK_GRAY);

    //TODO: Methods
    static Texture create_texture(int w, int h, Color color){
        Pixmap p = new Pixmap(w, h, Pixmap.Format.RGBA8888);
        p.setColor(color);
        p.fillRectangle(0, 0, w, h);
        return new Texture(p);
    }

    static Color inverse_color(Color color){
        return new Color(
                1f - color.r,
                1f - color.g,
                1f - color.b,
                1f
        );
    }
}
