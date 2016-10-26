package Cells;
/**
 * Decentralized Agent-based model: ABM
 * Agents: no movement, just release the chemical signal
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameters;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;

/**
 * Amoebas start to release the cAMP: Function: produce()
 * 
 * 
 * 
 * @author Mohammad Parhizkar 
 *
 */
public class Cell {

	
	public Cell(){
		Parameters p = RunEnvironment.getInstance().getParameters();

	}
	
	//----------------------------------------Schedule Method -------------------------------
	/**
	 * Actions scheduled on a Schedule will be executed in random order
	 * According to the simulation clock
	 * 
	 * */ 
	
	@ScheduledMethod(start=1, interval=1)
	public void step(){
			if (!findEmptySites().isEmpty())
				produce();
	}

	private void produce(){		
		Context context = ContextUtils.getContext(this);
		Grid grid = (Grid)context.getProjection("Grid");
	
		Cell cell = new Cell();	
		context.add(cell);
		
		List<GridPoint> emptySites = findEmptySites();
		
		if (emptySites.size() > 0) grid.moveTo(cell, emptySites.get(0).getX(), emptySites.get(0).getY());
		
	}

	private List<GridPoint> findEmptySites(){
		List<GridPoint> emptySites = new ArrayList<GridPoint>();
		Context context = ContextUtils.getContext(this);
		Grid grid = (Grid)context.getProjection("Grid");
		GridPoint pt = grid.getLocation(this);

		
		if (!grid.getObjectsAt(pt.getX()-1,pt.getY()+1).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX()-1,pt.getY()+1));
		if (!grid.getObjectsAt(pt.getX(),pt.getY()+1).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX(),pt.getY()+1));
		if (!grid.getObjectsAt(pt.getX()+1,pt.getY()+1).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX()+1,pt.getY()+1));
		if (!grid.getObjectsAt(pt.getX()+1,pt.getY()).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX()+1,pt.getY()));
		if (!grid.getObjectsAt(pt.getX()+1,pt.getY()-1).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX()+1,pt.getY()-1));
		if (!grid.getObjectsAt(pt.getX(),pt.getY()-1).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX(),pt.getY()-1));
		if (!grid.getObjectsAt(pt.getX()-1,pt.getY()-1).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX()-1,pt.getY()-1));
		if (!grid.getObjectsAt(pt.getX()-1,pt.getY()).iterator().hasNext())
			emptySites.add(new GridPoint(pt.getX()-1,pt.getY()));
		
		Collections.shuffle(emptySites);
		
		return emptySites;
	}
}
