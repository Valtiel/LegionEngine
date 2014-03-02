package com.ve.cesarrosales.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets implements Disposable, AssetErrorListener {
	//public AssetMenuBackground menuBackground;
	public AssetPlayer player;
	public AssetStEnemy stEnemy;
	public static final String TAG = Assets.class.getName();
	public static final Assets instance = new Assets();
	private AssetManager assetManager;

	private Assets() {
	}

	public void init(AssetManager assetManager) {
		this.assetManager = assetManager;
		assetManager.setErrorListener(this);
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		assetManager.finishLoading();
		Gdx.app.debug(TAG,
				"# of assets loaded: " + assetManager.getAssetNames().size);
		for (String a : assetManager.getAssetNames()) {
			Gdx.app.debug(TAG, "asset: " + a);
		}
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		stEnemy=new AssetStEnemy(atlas);
		player=new AssetPlayer(atlas);
		//fonts = new AssetFonts();
		//menuBackground = new AssetMenuBackground(atlas);
		
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		// TODO Auto-generated method stub
		Gdx.app.error(TAG, "Couldn't load asset :" + asset.fileName,
				(Exception) throwable);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		assetManager.dispose();
	}

	public class AssetPlayer {
		public final AtlasRegion player;
		public AssetPlayer(TextureAtlas atlas){
			player=atlas.findRegion("player");
		}
	}
	
	public class AssetStEnemy {
		public final AtlasRegion stEnemy;
		public AssetStEnemy(TextureAtlas atlas){
			stEnemy=atlas.findRegion("enemy");
		}
	}
}

