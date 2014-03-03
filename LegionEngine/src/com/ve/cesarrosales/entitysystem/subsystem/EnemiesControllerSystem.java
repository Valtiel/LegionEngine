package com.ve.cesarrosales.entitysystem.subsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.ve.cesarrosales.entitysystem.EntityFactory;
import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.component.EnemyBehaviorComponent;
import com.ve.cesarrosales.entitysystem.component.Position2D;
import com.ve.cesarrosales.entitysystem.component.Velocity;
import com.ve.cesarrosales.utils.Constants;

public class EnemiesControllerSystem implements SubSystem {
	
	private World world;
	private EntityManager entityManager;
	private Timer timer;
	//private Collection<UUID> entitiesList;

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		Collection<UUID> entitiesList = entityManager
				.getAllEntitiesPossessingComponent(EnemyBehaviorComponent.class);
		manageEnemies(entitiesList, delta);
	}

	private void manageEnemies(Collection<UUID> list, float delta) {
		// TODO Auto-generated method stub
		List<UUID> toRemove=new ArrayList<UUID>();

		for (Iterator<UUID> it = list.iterator(); it.hasNext();) {
			  UUID id = it.next();
			  Position2D p = entityManager.getComponent(id, Position2D.class);
				Velocity v = entityManager.getComponent(id, Velocity.class);
				p.vector.add(v.vector.x * delta, v.vector.y * delta);
				if (p.vector.x <= -Constants.VIRTUAL_WIDTH_MAX / 2) {
					toRemove.add(id);
				}
		}
		for(UUID id: toRemove){
			entityManager.killEntity(id);
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWorld(World world) {
		// TODO Auto-generated method stub
		this.world = world;
		entityManager = world.getEntityManager();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		setTimer();
	}

	private void setTimer() {
		// TODO Auto-generated method stub
		timer= new Timer();
		timer.scheduleTask(new Task() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					EntityFactory.getInstance().createRandomStandardEnemy(
							entityManager);
					//Gdx.app.log("ASDASD", "ASDASD");
					setTimer();
			}
		}, MathUtils.random(0.5f,2f));
		timer.start();
	}
}