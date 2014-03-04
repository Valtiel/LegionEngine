package com.ve.cesarrosales.entitysystem.subsystem;

import java.util.Set;
import java.util.UUID;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.component.PlayerInput;

public class PCGameInputSystem implements SubSystem {
	
	private World world;
	private EntityManager entityManager;
	private PlayerInput input;

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		if (input.isDown == false && Gdx.input.isKeyPressed(Keys.W)) {
			input.isDown = false;
			input.isUp = true;
			//Gdx.app.log("INPUT", "W IS PRESSED");
		} else if (input.isUp == false && Gdx.input.isKeyPressed(Keys.S)) {
			//Gdx.app.log("INPUT", "S IS PRESSED");
			input.isDown = true;
			input.isUp = false;
		}else{
			input.isDown=false;
			input.isUp=false;
		}
		if (input.isFire == false && Gdx.input.isKeyPressed(Keys.SPACE)) {
			//Gdx.app.log("INPUT", "SPACE IS PRESSED");
			input.isFire = true;
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
		Set<UUID> ids = entityManager
				.getAllEntitiesPossessingComponent(PlayerInput.class);
		for (UUID id : ids) {
			input = entityManager.getComponent(id, PlayerInput.class);
		}
	}

}
