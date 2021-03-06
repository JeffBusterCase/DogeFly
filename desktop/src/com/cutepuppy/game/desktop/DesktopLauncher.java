package com.cutepuppy.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cutepuppy.game.DogeFly;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "DogeFly";
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
        config.width = 900;
        config.height = 600;
        config.resizable = false;
        config.vSyncEnabled = true;
		new LwjglApplication(new DogeFly(), config);
	}
}
