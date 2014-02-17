package com.ve.cesarrosales.entitysystem.subsystem;

import com.ve.cesarrosales.entitysystem.World;

public interface SubSystem {

	void update(float delta);
	
 	String getName();
	
	void setWorld(World world);
	
	void init();
}
