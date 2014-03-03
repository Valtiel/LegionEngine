package com.ve.cesarrosales.entitysystem;

import java.util.ArrayList;
import java.util.List;

import com.ve.cesarrosales.entitysystem.subsystem.*;

public class BasicWorld implements World {
	
	public static String TAG = BasicWorld.class.getName();
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
		EntityFactory.getInstance().createPlayer(entityManager);
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
