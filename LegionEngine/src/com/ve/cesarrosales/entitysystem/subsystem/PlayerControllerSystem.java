package com.ve.cesarrosales.entitysystem.subsystem;

import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.component.PlayerInput;
import com.ve.cesarrosales.entitysystem.component.Position2D;
import com.ve.cesarrosales.entitysystem.component.Velocity;

public class PlayerControllerSystem implements SubSystem{

	private World world;
	private EntityManager entityManager;
	private PlayerInput input;
	private Position2D position;
	private Velocity velocity;
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWorld(World world) {
		// TODO Auto-generated method stub
		this.world=world;
		entityManager = world.getEntityManager();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
