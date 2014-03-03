package com.ve.cesarrosales.entitysystem;

import java.util.UUID;

import com.badlogic.gdx.math.MathUtils;
import com.ve.cesarrosales.entitysystem.component.EnemyBehaviorComponent;
import com.ve.cesarrosales.entitysystem.component.PlayerInput;
import com.ve.cesarrosales.entitysystem.component.Position2D;
import com.ve.cesarrosales.entitysystem.component.SpriteComponent;
import com.ve.cesarrosales.entitysystem.component.Velocity;
import com.ve.cesarrosales.utils.Assets;
import com.ve.cesarrosales.utils.Constants;

public class EntityFactory {

	private static EntityFactory _INSTANCE;
	
	private EntityFactory(){
		
	}
	
	public static EntityFactory getInstance(){
		if(_INSTANCE == null){
			_INSTANCE = new EntityFactory();
		}
		return _INSTANCE;
	}
	
	public void createRandomStandardEnemy(EntityManager manager){
			UUID entity;
			entity = manager.createEntity();
		//	float x=MathUtils.random(-400f,400f);
			float y=getYCoordinateForEnemy();
			float v=MathUtils.random(150f,300f);
			manager.addComponent(entity,new Position2D(400,y));
			manager.addComponent(entity, new SpriteComponent(Assets.instance.stEnemy.sprite));
			manager.addComponent(entity, new Velocity(-v,0f));
			manager.addComponent(entity, new EnemyBehaviorComponent());
	}

	public void createPlayer(EntityManager manager){
		UUID entity;
		entity = manager.createEntity();
		manager.addComponent(entity,new Position2D(-350,0));
		manager.addComponent(entity, new SpriteComponent(Assets.instance.player.sprite));
		manager.addComponent(entity, new Velocity(0f,0f));
		manager.addComponent(entity, new PlayerInput());
	}
	
	private float testY=Constants.VIRTUAL_HEIGHT_MIN/4;
	
	private float getYCoordinateForEnemy(){
		return testY*MathUtils.random(1,3)-(Constants.VIRTUAL_HEIGHT_MIN/2);
	}
	
}
