package com.ve.cesarrosales.entitysystem.component;

import com.badlogic.gdx.math.Vector2;


/**
 * Componente que contiene la posición 2D (X,Y) 
 * 
 * @author César Rosales
 *
 */
public class Position2D implements Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Vector2 vector;
	public float rotation;
	public Vector2 scale;

	
	public Position2D(){
		vector=new Vector2(0f,0f);
		scale=new Vector2(1f,1f);
		rotation=0f;
	}
	
	public Position2D(float x, float y){
		vector = new Vector2(x,y);
		scale=new Vector2(1f,1f);
		rotation=0f;
	}
	
	public Position2D(float x, float y, float scaleX, float scaleY){
		vector = new Vector2(x,y);
		scale=new Vector2(scaleX,scaleY);
		rotation=0f;
	}

	
	public String toString(){
		return Position2D.class.getSimpleName() + "("+vector.x+","+vector.y+")";
	}
}
