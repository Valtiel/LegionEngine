package com.ve.cesarrosales.entitysystem.subsystem;

import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.component.Position2D;

public class PositionSystem implements SubSystem {
	private World world;
	private EntityManager entityManager;
	Collection<Position2D> positionComponents;
	
	
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		for(Position2D p: positionComponents){
			Gdx.app.log(PositionSystem.class.getSimpleName(), p.toString());
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setWorld(World world){
		this.world=world;
		entityManager = world.getEntityManager();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		positionComponents = entityManager.getAllComponentsOfType(Position2D.class);
	}
}
