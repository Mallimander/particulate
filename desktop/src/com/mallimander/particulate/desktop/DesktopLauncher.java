package com.mallimander.particulate.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mallimander.particulate.Particulate;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		int res = 1;
		
		switch(res){
		case 0: config.width = 1920; config.height = 1080; config.fullscreen = true;
		break;
		
		case 1: config.width = 1440; config.height = 900; config.fullscreen = false;
		break;
				
		}
		
		new LwjglApplication(new Particulate(), config);
	}
}
