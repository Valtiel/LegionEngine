package com.ve.cesarrosales.gamescreen;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.ve.cesarrosales.ExtendedGame;
import com.ve.cesarrosales.entitysystem.BasicWorld;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.subsystem.AndroidInputSystem;
import com.ve.cesarrosales.entitysystem.subsystem.EnemiesControllerSystem;
import com.ve.cesarrosales.entitysystem.subsystem.PCGameInputSystem;
import com.ve.cesarrosales.entitysystem.subsystem.RenderSystem;

public class TestScreen extends GameScreen {
	
	World world;
	
	public TestScreen(ExtendedGame game) {
		super(game);
		world = BasicWorld.getInstance();
		world.addSubSystem(new EnemiesControllerSystem());
		world.addSubSystem(new RenderSystem());
		switch(Gdx.app.getType()) {
		   case Desktop:
		       // android specific code
			   //Gdx.app.log("GAME", "DESKTOP");
				world.addSubSystem(new PCGameInputSystem());
			   break;
		   case Android:
		       // desktop specific code
			   world.addSubSystem(new AndroidInputSystem());
			  // Gdx.app.log("GAME", "ANDROID");

			   break;
		   case WebGL:
		       /// HTML5 specific code
			 //  Gdx.app.log("GAME", "WEB");

			   break;
		default:
			break;
		}
		world.initSystems();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		world.update(delta);
	}

	@Override
	public void resize(int width, int height) {
		world.resize(width,height);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public InputProcessor getInputProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}