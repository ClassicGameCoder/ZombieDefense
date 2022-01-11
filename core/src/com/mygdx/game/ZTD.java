package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class ZTD {
    static Random r = new Random();
    static  String current_type = "";
    static boolean pause = false;

    static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    static ArrayList<Button> buttons = new ArrayList<Button>();
    static ArrayList<Cannon> cannons = new ArrayList<Cannon>();
    static  ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    static  ArrayList<Effect> effects = new ArrayList<Effect>();
    static ArrayList<Wall> walls = new ArrayList<Wall>();

    ZTD(){
        setup();
    }

    void draw(SpriteBatch batch){
        batch.draw(Resources.bg, 0 , 0);
        UI.draw(batch);
        for(Zombie z :zombies) z.draw(batch);
        for(Cannon c :cannons) c.draw(batch);
        for(Button b :buttons) b.draw(batch);
        for(Bullet b :bullets) b.draw(batch);
        for(Effect ef :effects) ef.draw(batch);
        for(Wall w :walls) w.draw(batch);
    }

    void update(){
        Main.gameover = true;
        if(!pause) {
            for (Zombie z : zombies) z.update();
            for (Cannon c : cannons) c.update();
            for (Button b : buttons) b.update();
            for (Bullet b : bullets) b.update();
            for (Wall w : walls) w.update();
        }

        Cleanup();
        spawn_zombies();

    }
    void Cleanup(){
        for(Zombie z :zombies) if (!z.active){zombies.remove(z); break;}
        for(Bullet b :bullets) if (!b.active){bullets.remove(b); break;}
        for(Effect ef :effects) if (!ef.active){effects.remove(ef); break;}
        for(Wall w :walls) if (!w.active){walls.remove(w); break;}
        for(Cannon c :cannons) if (!c.active){cannons.remove(c); break;}
    }

    void tap(int x, int y){
            //effects.add(new Effect("boom", x, y));

            for(Button b: buttons) {
                if(b.t != null && !b.t.hidden && b.t.close.hitbox().contains(x, y)) {b.t.hidden = true; return;}
                if(b.t != null && !b.t.hidden && b.t.hitbox().contains(x, y)) return;
                if (b.hitbox().contains(x, y)) {
                    if(b.type.equals("pause") || b.type.equals("play")){
                        pause = !pause;
                        b.type = pause ? "play" : "pause";
                        return;
                    }
                    if (b.locked) {
                        if (b.t.hidden) {
                            hidetooltips();
                            b.t.hidden = false;
                        } else {
                            b.locked = false;
                            b.t.hidden = true;
                        }
                        return;
                    } else {
                        if(b.type.equals("walls") || b.type.equals("mounted")){
                            if(walls.size() < 3) walls.add(new Wall(walls.size() * 50, 0, b.type.equals("mounted")));
                            return;
                        }
                        hidetooltips();
                        deselect();
                        b.selected = true;
                        current_type = b.type;
                    }
                    return;
                }
            }
            for(Cannon c : cannons) if(c.hitbox().contains(x, y)) {c.active = !c.damaged; return;}
            if(buildable(x, y) && UI.money >= Tables.values.get("place_" + current_type)) {
                UI.money -= Tables.values.get("place_" + current_type);
                cannons.add(new Cannon(current_type, x, y));
            }

    }

    void deselect(){
        for(Button b : buttons) b.selected = false;
    }
    void hidetooltips(){
        for(Button b: buttons) if(b.t != null) b.t.hidden = true;
    }

    boolean buildable(int x, int y){
        if((x <= 1000 && x >= 0) && ((y >= 300 && y <= 500 ) || (y >= 0 && y <= 200 ))){
            return true;
        }else return false;
    }

    void setup(){
        Tables.init();
        spawn_zombies();
        buttons.add(new Button("fire",buttons.size() * 70 + 200,525));
        buttons.add(new Button("double",buttons.size() * 70 + 200,525));
        buttons.add(new Button("laser",buttons.size() * 70 + 200,525));
        buttons.add(new Button("cannon",buttons.size() * 70 + 200,525));
        buttons.get((buttons.size() - 1)).selected = true;
        buttons.get((buttons.size() - 1)).locked = false;
        current_type = "cannon";
        buttons.add(new Button("super",buttons.size() * 70 + 200,525));
        buttons.add(new Button("wall",buttons.size() * 70 + 200,525));
        buttons.get((buttons.size() - 1)).locked = false;
        buttons.add(new Button("mounted",buttons.size() * 70 + 200,525));
        buttons.add(new Button("pause",1024 - 75,525));
        buttons.get((buttons.size() - 1)).selected = true;
        buttons.get((buttons.size() - 1)).locked = false;

    }

    ArrayList<String> ztypes = new ArrayList<String>();

    void spawn_zombies(){
        if(!zombies.isEmpty()) return;
        UI.wave++;
        switch(UI.wave){
            case 1:
                ztypes.add("dif");
            case 3:
                ztypes.add("zzz");
                break;
            case 5:
                ztypes.add("speedy");
                break;
            case 7:
                ztypes.add("riot");
                break;
        }
        for(int i = 0; i< UI.wave * 3 + 5; i++){
            zombies.add(new Zombie(ztypes.get(r.nextInt(ztypes.size())),i*30 + 1024, r.nextInt(450)));
        }
    }
}
