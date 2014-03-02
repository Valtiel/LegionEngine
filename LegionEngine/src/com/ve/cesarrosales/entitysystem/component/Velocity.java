package com.ve.cesarrosales.entitysystem.component;

import com.badlogic.gdx.math.Vector2;

public class Velocity implements Component {
	
	public Vector2 vector;
	
	public Velocity(){
		vector=new Vector2(0,0);
	}
	
	public Velocity(Vector2 vector){
		this.vector=vector;
	}
	
	public Velocity(float x, float y){
		vector=new Vector2(x,y);
	}
}
