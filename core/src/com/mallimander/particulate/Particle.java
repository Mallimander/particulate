package com.mallimander.particulate;

import com.badlogic.gdx.graphics.Texture;

public class Particle {
	
	public int x;
	public int y;
	public float xS;
	public float yS;
	public int lSpan;
	public byte type;
	private Texture t;
	
	public Particle (int x, int y, float xSpeed, float ySpeed, byte type, int lifeSpan, Texture tex){
		this.x = x;
		this.y = y;
		xS = xSpeed;
		yS = ySpeed;
		this.type = type;
		lSpan = lifeSpan;
		t = tex;
		
	}
	
	public void setTexture(Texture tex){
		t = tex;
	}
	public Texture getTexture(){
		return t;
	}
	
	public void update(float gravity, float drag){
		if(xS > 0){
			if(xS > drag){
				xS -= drag;
			}else{
				xS = 0;
			}
		}else{
			if(Math.abs(xS) > drag){
				xS += drag;
			}else{
				xS = 0;
			}
		}
		
		
		x += xS;
		
		yS += gravity*.1f;
		y += yS;
		if (lSpan > 0){
			lSpan --;
		}
	}

}
