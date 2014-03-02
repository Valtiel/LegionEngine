package com.ve.cesarrosales.entitysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.ve.cesarrosales.entitysystem.component.*;
import com.ve.cesarrosales.entitysystem.subsystem.*;
import com.ve.cesarrosales.utils.Assets;
import com.ve.cesarrosales.utils.Constants;

public class BasicWorld implements World {
	public static String TAG=BasicWorld.class.getName();
	private static volatile BasicWorld _INSTANCE = null;
	private List<SubSystem> subSystemList;
	public EntityManager entityManager;
	
	private BasicWorld(){
		init();
	}
	
	public static BasicWorld getInstance(){
		if(_INSTANCE == null){
			synchronized(BasicWorld.class){
				_INSTANCE=new BasicWorld();
			}
		}
		return _INSTANCE;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		for(SubSystem s: subSystemList){
			s.update(delta);
		}
	}

	@Override
	public void addSubSystem(SubSystem subsystem) {
		// TODO Auto-generated method stub
		
		subSystemList.add(subsystem);
		subsystem.setWorld(this);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		subSystemList=new ArrayList<SubSystem>();
		entityManager = new EntityManager();
		UUID entity;
		for(int i=0 ; i<30; i++){
			entity = entityManager.createEntity();
			float x=MathUtils.random(0, Constants.VIRTUAL_WIDTH);
			float y=MathUtils.random(0, Constants.VIRTUAL_HEIGHT);		
			Gdx.app.log(TAG, "Position: "+x+":"+y);
			entityManager.addComponent(entity,new Position2D(x,y));
			entityManager.addComponent(entity, new SpriteComponent(Assets.instance.stEnemy.stEnemy));
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		for(SubSystem s: subSystemList){
			if(s instanceof Resizable){
				Resizable r=(Resizable) s;
				r.resize(width, height);
			}
		}
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	@Override
	public void initSystems() {
		// TODO Auto-generated method stub
		for(SubSystem s: subSystemList){
			s.init();
		}
	}
	
}
