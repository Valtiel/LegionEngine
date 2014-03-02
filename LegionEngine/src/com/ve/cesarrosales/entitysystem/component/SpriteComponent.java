package com.ve.cesarrosales.entitysystem.component;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteComponent implements Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TextureRegion sprite;
	
	public SpriteComponent(TextureRegion sprite){
		this.sprite=sprite;
	}
	
	public String toString(){
		return SpriteComponent.class.getSimpleName() + "("+sprite.getTexture().toString()+")";
	}
}
