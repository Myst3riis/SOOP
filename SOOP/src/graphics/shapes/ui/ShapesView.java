package graphics.shapes.ui;

import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.View;
import graphics.shapes.ui.Grid;

public class ShapesView extends View
{ 	
	private SCollection sc = (SCollection) this.getModel();
	
	public ShapesView(Object model)
	{
		super(model);
	}

	public void paintComponent(Graphics g)
	{	
		ShapeDraftman sd = new ShapeDraftman(g);
		//SCollection sc = (SCollection) this.getModel();
		Grid grid = new Grid(g);
		grid.drawGrid();
		for(Iterator<Shape> it = sc.iterator(); it.hasNext();)
			it.next().accept(sd);
		
	}

}
