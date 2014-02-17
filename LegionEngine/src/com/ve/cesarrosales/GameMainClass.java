package com.ve.cesarrosales;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.ve.cesarrosales.gamescreen.InitialScreen;

public class GameMainClass extends ExtendedGame {
	@Override
	public void create() {		
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		//Assets.instance.init(new AssetManager());
		// Start game at menu screen
		setScreen(new InitialScreen(this));
	}
}
