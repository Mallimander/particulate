package com.mallimander.particulate;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;

public class Emitter {
	
	private int x;
	private int y;
	private float xS;
	private float yS;
	
	private byte type;
	
	public Emitter(int x, int y, float xS, float yS, byte type){
		this.x = x;
		this.y = y;
		this.xS = xS;
		this.yS = yS;
		this.type = type;
	}
	
	public Particle Emit(int x, int y){
		Particle p = makeParticle(0);
		return p;
	}
	
	private Particle makeParticle(int how){
		
		Particle p = null;
		Pixmap pixmap;
		float light, tXS, tYS;
		
		switch(type){
		//water?
		case 0:
			
			pixmap = new Pixmap( 16, 16, Format.RGBA8888 );
			light = (float)(Math.random()*0.5);
			pixmap.setColor(light,light,(float)(light + 0.5),1);
			for(int i = 4; i < 12; i++){
				for(int j = 4; j < 12; j++){
					if(Math.random()<0.3){

//						pixmap.fillTriangle(i, j);
						pixmap.fillTriangle(i+(int)(Math.random()*4), j+(int)(Math.random()*4), i+(int)(Math.random()*4), j+(int)(Math.random()*4), i+(int)(Math.random()*4), j+(int)(Math.random()*4));
					}
				}
			}
			
			tXS = (float)(Math.random()*3) + xS;
			tYS = (float)(Math.random()*3) + yS;
			
			p = new Particle(x, y, tXS, tYS, type, 120, new Texture(pixmap));
			
			pixmap.dispose();
			
		break;
		//Smoke
		case 1:
			
			pixmap = new Pixmap( 16, 16, Format.RGBA8888 );
			light = (float)(Math.random()*0.5+0.4);
			pixmap.setColor(light,light,light,1f);
			for(int i = 4; i < 12; i++){
				for(int j = 4; j < 12; j++){
					if(Math.random()<0.3){
						pixmap.fillCircle(i+(int)(Math.random()*4+-2), j+(int)(Math.random()*4-2), (int)(Math.random()*2+2) );
					}
				}
			}
			
			tXS = (float)(Math.random()*3) + xS;
			tYS = (float)(Math.random()*3) + yS;
			
			p = new Particle(x-8, y-8, tXS, tYS, type, 120, new Texture(pixmap));
			
		break;
		
		
		
		
		
		
		
		}
		
		System.out.println("Made Particle " + x + ", " + y);
		
		
		return p;
		
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public void setXS(float xS){
		this.xS = xS;
	}
	
	public void setYS(float yS){
		this.yS = yS;
	}
	

}