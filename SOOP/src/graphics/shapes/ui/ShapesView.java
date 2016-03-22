package graphics.shapes.ui;

import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.View;

public class ShapesView extends View
{
	private SCollection model;
	private ShapeDraftman sd = new ShapeDraftman(this.getGraphics());
	private Grid grid = new Grid(this.getGraphics());
	private ShapesController scontroller;

	public ShapesView(Object model)
	{
		super(model);
		this.model = (SCollection) model;
		this.scontroller = defaultController(this.model);
		this.scontroller.setView(this);
		this.addMouseListener(this.scontroller);
		this.addMouseMotionListener(this.scontroller);
		this.addKeyListener(this.scontroller);
		this.addMouseWheelListener(this.scontroller);
		this.setFocusable(true);
	}
/*
	public void updateModel(SCollection model)
	{
		this.model = model;
	}

	public void updateView()//ShapesView view)
	{
		this.scontroller.setView(this);
	}

	public void updateController(SCollection model)
	{
		this.scontroller.setModel(model);
	}
*/
	public SCollection getModel()
	{
		return this.model;
	}

	public ShapesController defaultController(SCollection model)
	{
		return new ShapesController(model);
	}

	public Grid getGrid()
	{
		return this.grid;
	}

	public ShapeDraftman getShapeDraftman()
	{
		return this.sd;
	}

	public void paintComponent(Graphics g)
	{
		sd.updateGraphics(g);
		grid.updateGraphics(g);
		grid.drawGrid();
		for (Iterator<Shape> it = this.model.iterator(); it.hasNext();)
			it.next().accept(sd);

	}

}
