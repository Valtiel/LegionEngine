package com.ve.cesarrosales.entitysystem.subsystem;

import java.util.Collection;
import java.util.UUID;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.ve.cesarrosales.entitysystem.EntityManager;
import com.ve.cesarrosales.entitysystem.World;
import com.ve.cesarrosales.entitysystem.component.Position2D;
import com.ve.cesarrosales.entitysystem.component.SpriteComponent;
import com.ve.cesarrosales.utils.Constants;
import com.ve.cesarrosales.utils.MultipleVirtualViewportBuilder;
import com.ve.cesarrosales.utils.OrthographicCameraWithVirtualViewport;
import com.ve.cesarrosales.utils.VirtualViewport;

public class RenderSystem implements SubSystem, Resizable{
	private OrthographicCameraWithVirtualViewport camera;
    private MultipleVirtualViewportBuilder multipleVirtualViewportBuilder;  
	private SpriteBatch batch;
	private ShapeRenderer sp;
	private World world;
	private EntityManager entityManager;
	private Collection<UUID> entitiesList;
	
	
	//TEST THINGS
    private Sprite minimumAreaSprite;  
    private Sprite maximumAreaSprite;  
    private Sprite floatingButtonSprite;  
    private BitmapFont font;  
	//END TEST
	
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
        camera.update();  
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		maximumAreaSprite.draw(batch);  
        minimumAreaSprite.draw(batch);  
        floatingButtonSprite.draw(batch);  
        font.draw(batch, Gdx.graphics.getWidth() +"x"+ Gdx.graphics.getHeight(), -20, 0);  
		entitiesList=entityManager.getAllEntitiesPossessingComponent(SpriteComponent.class);
		for(UUID id: entitiesList){
			Position2D position = entityManager.getComponent(id, Position2D.class);
			SpriteComponent sprite = entityManager.getComponent(id, SpriteComponent.class);
			float x = position.vector.x - sprite.sprite.getRegionWidth()/2;
			float y = position.vector.y - sprite.sprite.getRegionHeight()/2;
			batch.draw(sprite.sprite, x, y);
		}
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
		multipleVirtualViewportBuilder = new MultipleVirtualViewportBuilder(Constants.VIRTUAL_WIDTH_MIN, Constants.VIRTUAL_HEIGHT_MIN, Constants.VIRTUAL_WIDTH_MAX, Constants.VIRTUAL_HEIGHT_MAX);  
        VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
          
        camera = new OrthographicCameraWithVirtualViewport(virtualViewport);  
        // centers the camera at 0, 0 (the center of the virtual viewport)  
		camera.position.set(0, 0, 0);
		camera.setToOrtho(false);
		//camera.scale = screen.width / 25
		camera.update();
	        
        Pixmap pixmap = new Pixmap(64, 64, Format.RGBA8888);  
        pixmap.setColor(Color.WHITE);  
        pixmap.fillRectangle(0, 0, 64, 64);  
          
        minimumAreaSprite = new Sprite(new Texture(pixmap));  
        minimumAreaSprite.setPosition(-400, -240);  
        minimumAreaSprite.setSize(800, 480);  
        minimumAreaSprite.setColor(0f, 1f, 0f, 1f);  
          
        maximumAreaSprite = new Sprite(new Texture(pixmap));  
        maximumAreaSprite.setPosition(-427, -300);  
        maximumAreaSprite.setSize(854, 600);  
        maximumAreaSprite.setColor(1f, 1f, 0f, 1f);  
          
        floatingButtonSprite = new Sprite(new Texture(pixmap));  
        floatingButtonSprite.setPosition(virtualViewport.getVirtualWidth() * 0.5f - 80, virtualViewport.getVirtualHeight() * 0.5f - 80);  
        floatingButtonSprite.setSize(64, 64);  
        floatingButtonSprite.setColor(1f, 1f, 1f, 1f);  
          
        font = new BitmapFont();  
        font.setColor(Color.BLACK);  
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		  
        VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
        camera.setVirtualViewport(virtualViewport);  
          
        camera.updateViewport();  
        // centers the camera at 0, 0 (the center of the virtual viewport)  
        camera.position.set(0f, 0f, 0f);  
          
        // relocate floating stuff  
        floatingButtonSprite.setPosition(virtualViewport.getVirtualWidth() * 0.5f - 80, virtualViewport.getVirtualHeight() * 0.5f - 80);  

	}

}
