package com.mallimander.particulate;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Particulate extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture pixmapTex;
	Input input;
	
	private int screenWidth = 1440;
	private int screenHeight = 900;
	
	private int mX = 0;
	private int mY = 0;
	
	private ArrayList<Particle> particles;
	private int maxParts = 1000;
	
	private Emitter[] ems;
	
	private float gravity = -5f;
	private float drag = 0.1f;
	
	private boolean run = true;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		input = Gdx.input;
		particles = new ArrayList<Particle>();
		int [] goo = {1,2};
		ems = new Emitter[]{new Emitter(100, 200, 3f, 3f, (byte)0), new Emitter(100, 200, 3f, 3f, (byte)1)};

//		em = new Emitter(100, 200, 3f, 3f, (byte)0);
		
//		Pixmap pixmap = new Pixmap( 64, 64, Format.RGBA8888 );
//		for(int i = 0; i < 64; i++){
//			for(int j = 0; j < 64; j++){
//				
//				float rT = (float)(i/64f);
////				float gT = (float)(j/64f);
//				float gT = (float)((i+j)/128f);
//				
//				pixmap.setColor( 0, gT, 0, 1.0f);
//				pixmap.drawPixel(i, j);
//			}
//		}
////		pixmap.setColor( 1, 1, 1, 1.0f );
////		pixmap.drawPixel(1, 1);
////		pixmap.fillCircle( 32, 32, 31 );
////		pixmap.setColor( 0.5f, 0.5f, 0.5f, 1.0f );
////		pixmap.fillCircle( 32, 32, 23 );
////		pixmap.setColor( 1, 1, 1, 1.0f);
////		pixmap.fillCircle( 32, 32, 16 );
//		pixmapTex = new Texture( pixmap );
//		pixmap.dispose();
		
	}
	
	private void input() {
		int i = 0;
		if(input.isKeyPressed(Keys.NUM_1)){
			i = 0;
		}
		if(input.isKeyPressed(Keys.NUM_2)){
			i = 1;
		}
		
		
		if(input.isTouched()){
			mX = input.getX()-32;
			mY = screenHeight-input.getY()-32;
			ems[i].setX(mX);
			ems[i].setY(mY);
			ems[i].setXS((screenWidth - mX)*0.02f); 
			ems[i].setYS((screenHeight - mY)*0.02f); 
			if(particles.size() < maxParts){
				particles.add( ems[i].Emit(mX, mY) );
			}
		}
		
		if(input.isKeyJustPressed(Keys.R)){
			particles = new ArrayList<Particle>();
		}
		
		if(input.isKeyJustPressed(Keys.P)){
			run = !run;
		}
		
	}

	@Override
	public void render () {
		input();
		if(run){
			update();
		}
		
		Gdx.gl.glClearColor(0.1f, 0, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		for(Particle pTemp : particles){
			batch.draw(pTemp.getTexture(), pTemp.x, pTemp.y);
		}
		batch.end();
	}
	
	private void update(){
		ArrayList<Particle> removeList = new ArrayList<Particle>();
		
		for(Particle p : particles){
			if(p.lSpan > 0){
				p.update(gravity, drag);
			}else{
				removeList.add(p);
			}
		}
		
		particles.removeAll(removeList);
		
	}
	
	private void makePixmap(){
		Pixmap pixmap = new Pixmap( 64, 64, Format.RGBA8888 );
	
		for(int i = 0; i < 64; i++){
			for(int j = 0; j < 64; j++){
				
				float rT = (float)((64-i)/64f);
				float gT = (float)((64-j)/64f);
//				float gT = (float)((i+j)/128f);
				
				pixmap.setColor( gT, gT, 0, 1.0f);
				if(Math.random() < 0.3 && Math.abs(i*2-32)>32){
					pixmap.drawPixel(i, j);
				}
				
			}
		}
		
		pixmapTex = new Texture( pixmap );
		pixmap.dispose();
		
	}
}