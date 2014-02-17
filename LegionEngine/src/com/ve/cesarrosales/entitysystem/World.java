package com.ve.cesarrosales.entitysystem;
import com.ve.cesarrosales.entitysystem.subsystem.*;

public interface World {
	
	void update(float delta);
	
	void addSubSystem(SubSystem subsystem);
		
	void init();

	void resize(int width, int height);

	EntityManager getEntityManager();
	
	void initSystems();
	
}
