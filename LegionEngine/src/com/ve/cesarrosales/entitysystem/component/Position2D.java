package com.ve.cesarrosales.entitysystem.component;


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
	
	public float x, y;
	
	public Position2D(){
		x=0;
		y=0;
	}
	
	public Position2D(float x, float y){
		this.x=x;
		this.y=y;
	}

	
	public String toString(){
		return Position2D.class.getSimpleName() + "("+x+","+y+")";
	}
}
