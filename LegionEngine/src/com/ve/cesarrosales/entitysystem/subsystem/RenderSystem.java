package com.ve.cesarrosales.entitysystem.subsystem;

import java.util.Collection;
import java.util.UUID;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.component.Position2D;
import com.ve.cesarrosales.entitysystem.component.SpriteComponent;
import com.ve.cesarrosales.utils.Constants;

public class RenderSystem implements SubSystem, Resizable{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private ShapeRenderer sp;
	private World world;
	private EntityManager entityManager;
	private Collection<UUID> entitiesList;
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		sp.begin(ShapeType.Filled);
		sp.setColor(1,1,1,1);
		
		for(UUID id: entitiesList){
			Position2D position = entityManager.getComponent(id, Position2D.class);
			SpriteComponent sprite = entityManager.getComponent(id, SpriteComponent.class);
			batch.draw(sprite.sprite.getTexture(),
					position.x, position.y);
		}
		
		sp.end();
		batch.end();
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
		batch = new SpriteBatch();
		sp = new ShapeRenderer();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
		Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.setToOrtho(false);
		camera.update();
		entitiesList=entityManager.getAllEntitiesPossessingComponent(SpriteComponent.class);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT
				/ (float)height) * (float)width;
				camera.update();
	}

}
