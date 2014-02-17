package com.ve.cesarrosales.gamescreen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.ve.cesarrosales.ExtendedGame;
import com.ve.cesarrosales.utils.Assets;

/**
 * <p>
 * Abstract Class that Represents one of many application screens, such as a main menu, a settings menu, the game screen and so on.
 * implements Screen
 * </p>
 * @see	Screen
 * @version 0.1b
 * @author César Rosales
 * 
 */
public abstract class GameScreen implements Screen {

    protected ExtendedGame game;

	protected ExtendedGame getGame() {
		return game;
	}

	/**
	 * GameScreen constructor, needs the Game instance to work
	 * @param game the game instance
	 */
	public GameScreen(ExtendedGame game) {
		this.game = game;
	}

	/**
	 * Called when the screen should render itself.
	 * @param delta The time in seconds since the last render. 
	 */
	public abstract void render(float delta);

	/**
	 * 
	 */
	public abstract void resize(int width, int height);

	/**
	 *  Called when this screen becomes the current screen for a {@link Game}. 
	 */
	public abstract void show();

	/**
	 * Called when this screen is no longer the current screen for a {@link Game}. 
	 */
	public abstract void hide();

	/**
	 *  @see ApplicationListener#pause() 
	 */
	public abstract void pause();

	/**
	 *  @see ApplicationListener#resume()
	 */
	public void resume() {
		Assets.instance.init(new AssetManager());
		// music.play();
	}

	/**
	 * Called when this screen should release all resources.
	 */
	public void dispose() {
		Assets.instance.dispose();
		// music.dispose();
	}
	
	public abstract InputProcessor getInputProcessor ();
}
