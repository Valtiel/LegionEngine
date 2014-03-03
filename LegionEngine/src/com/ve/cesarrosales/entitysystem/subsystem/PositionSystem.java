package com.ve.cesarrosales.entitysystem.subsystem;

import java.util.Collection;
import java.util.UUID;

import com.badlogic.gdx.Gdx;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.component.Position2D;
import com.ve.cesarrosales.entitysystem.component.SpriteComponent;
import com.ve.cesarrosales.entitysystem.component.Velocity;

public class PositionSystem implements SubSystem {
	private World world;
	private EntityManager entityManager;
	//Collection<Position2D> positionComponents;
	private Collection<UUID> entitiesList;
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		Gdx.app.log(PositionSystem.class.getSimpleName(), "delta: "+delta);
		entitiesList=entityManager.getAllEntitiesPossessingComponent(Velocity.class);
		for(UUID id: entitiesList){
			Position2D position = entityManager.getComponent(id, Position2D.class);
			Velocity velocity = entityManager.getComponent(id, Velocity.class);
			position.vector.add(velocity.vector.x*delta,velocity.vector.y*delta);
			//Gdx.app.log(PositionSystem.class.getSimpleName(), p.toString());
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
		//positionComponents = entityManager.getAllComponentsOfType(Position2D.class);
	}
}
