package com.ve.cesarrosales.gamescreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.ve.cesarrosales.ExtendedGame;
import com.ve.cesarrosales.gamescreen.transitions.SlideScreenTransition;
import com.ve.cesarrosales.gamescreen.transitions.TransitionDirection;

public class InitialScreen extends GameScreen {

	private Timer timer;
	
	public InitialScreen(ExtendedGame game) {
		super(game);
		timer=new Timer();
		timer.scheduleTask(new Task() {
			@Override
			public void run() {
				getGame().setScreen(new TestScreen(getGame()), SlideScreenTransition.init(0.75f,TransitionDirection.LEFT,true,Interpolation.bounceOut));
			}
		}, 3);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {
		
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
