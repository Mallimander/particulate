package com.mallimander.particulate;

import com.badlogic.gdx.graphics.Texture;

public class Particle {
	
	public float x;
	public float y;
	public float xS;
	public float yS;
	public int lSpan;
	public byte type;
	private Texture t;
	private float drag;
	private float mass;
	
	/**
	 * 
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param xSpeed X Speed
	 * @param ySpeed Y Speed
	 * @param type Byte Type
	 * @param lifeSpan int Lifespan
	 * @param drag Float Drag
	 * @param mass Float Mass
	 * @param tex Texture
	 */
	public Particle (int x, int y, float xSpeed, float ySpeed, byte type, int lifeSpan, float drag, float mass, Texture tex){
		this.x = x;
		this.y = y;
		xS = xSpeed;
		yS = ySpeed;
		this.type = type;
		lSpan = lifeSpan;
		this.drag = drag;
		this.mass = mass;
		t = tex;
		
	}
	
	public void setTexture(Texture tex){
		t = tex;
	}
	public Texture getTexture(){
		return t;
	}
	
	public void update(float gravity){
		
		
		
//		if(xS > 0){
//			if(xS > drag){
//				xS -= drag;
//			}else{
//				xS = 0;
//			}
//		}else{
//			if(Math.abs(xS) > drag){
//				xS += drag;
//			}else{
//				xS = 0;
//			}
//		}
		
		
		x += xS+(-xS*drag);
		
		yS += gravity*mass*.1f;
		y += yS+(-yS*drag);
		if (lSpan > 0){
			lSpan --;
		}
	}

}
