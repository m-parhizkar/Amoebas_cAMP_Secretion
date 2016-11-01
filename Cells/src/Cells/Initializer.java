package Cells;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;


/**
 * Normal Cells behaviors and Initializer cells behaviors
 * Local area for each Initializer 
 * More specifically, each iteration of the simulation, each Initializer will determine how much cAMP is within its local area.
 * CountinousSpace:allows us to use floating point numbers as coordinates of cells  
 * Grid: the Grid allows us to do neighborhood and proximity queries, using discrete integer Grid coordinates.
 * */




public class Initializer {

	private Grid<Object> grid;//Instance variables 
	
	public Initializer(final Grid<Object> grid){
		this.grid=grid;
}
	@Override
	public String toString() {
	return String.format("Bug @ location %s", grid.getLocation(this));
	}


	
	
	
	
}