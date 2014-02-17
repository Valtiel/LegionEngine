package com.ve.cesarrosales.gamescreen.transitions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Interface 
 * @author César Rosales
 * @version 0.1b
 */
public interface ScreenTransition {
	
	/**
	 * 
	 * @return the duration of the transition
	 */
	public float getDuration();
	
	/**
	 * Renders the animations and effects of the transition.
	 * Uses an alpha parameter that describes the progress of the transition
	 * in values 0.0 < n < 1.0 , by example, 0.25 equals 25% of the transition.
	 * @param batch SpriteBatch 
	 * @param currScreen the current screen of the game
	 * @param nextScreen the target screen of the transition
	 * @param alpha describes the current state of the transition
	 */
	public void render(SpriteBatch batch, Texture currScreen,
			Texture nextScreen, float alpha);
	
}