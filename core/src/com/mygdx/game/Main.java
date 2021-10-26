package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	//TODO: Game variables/objects
	SpriteBatch batch;
	static Random r = new Random();

	//TODO: Game Lists
	static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	static ArrayList<Button> buttons = new ArrayList<Button>();
	static ArrayList<Cannon> cannons = new ArrayList<Cannon>();
	static  ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	//Runs once when the application starts
	@Override
	public void create () {
		batch = new SpriteBatch();
		setup();
	}

	//This runs once per frame
	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		update();
		batch.begin();
		batch.draw(Resources.bg, 0 , 0);
		for(Zombie z :zombies) z.draw(batch);
		for(Cannon c :cannons) c.draw(batch);
		for(Button b :buttons) b.draw(batch);
		for(Bullet b :bullets) b.draw(batch);
		batch.end();
	}

	void update(){
		tap();
		for(Zombie z :zombies) z.update();
		for(Cannon c :cannons) c.update();
		for(Button b :buttons) b.update();
		for(Bullet b :bullets) b.update();

		Cleanup();
		spawn_zombies();
	}

	void Cleanup(){
		for(Zombie z :zombies) if (!z.active){zombies.remove(z); break;}
		for(Bullet b :bullets) if (!b.active){bullets.remove(b); break;}
	}

	void tap(){
		if(Gdx.input.justTouched()){
			int x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();

			for(Cannon c : cannons) if(c.hitbox().contains(x, y)) return;
			if(buildable(x, y)) cannons.add(new Cannon("fire", x, y));
		}
	}

	boolean buildable(int x, int y){
		if((x <= 1000 && x >= 0) && ((y >= 300 && y <= 500 ) || (y >= 0 && y <= 200 ))){
			return true;
		}else return false;
	}

	void setup(){
		Tables.init();
		spawn_zombies();
		for(int i = 0; i<5; i++){
			buttons.add(new Button("bbb",i*100 + 50,525));
		}
	}

	void spawn_zombies(){
		if(!zombies.isEmpty()) return;
		for(int i = 0; i<15; i++){
			zombies.add(new Zombie("zzz",i*30 + 1024, r.nextInt(450), 3));
		}
	}

	//*************************End of File*************************
	@Override
	public void dispose () {
		batch.dispose();
	}
}
