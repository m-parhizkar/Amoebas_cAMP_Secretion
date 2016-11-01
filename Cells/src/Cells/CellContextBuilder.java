package Cells;

import repast.simphony.context.Context;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.space.grid.RandomGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;


public class CellContextBuilder implements ContextBuilder {
	 Grid <Object> grid; 
	
	@Override
	public Context build(Context context) {

		
		Parameters p = RunEnvironment.getInstance().getParameters();
		
		int gridWidth = (Integer)p.getValue("gridWidth");
		int gridHeight = (Integer)p.getValue("gridHeight");
		int initialCells = (Integer)p.getValue("initialCells");
		
		GridFactoryFinder.createGridFactory(null).createGrid("Grid",
				context, GridBuilderParameters.singleOccupancy2D(new RandomGridAdder(),
								new WrapAroundBorders(), gridWidth, gridHeight));
		
		for (int i=0; i<initialCells; i++){
			Cell cell=new Cell(grid);
			context.add(cell);
		
		}
		
		return context;
	}

}
