package graphics.shapes.ui;

import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.View;

public class ShapesView extends View
{

	public ShapesView(Object model)
	{
		super(model);
	}

	public void paintComponent(Graphics g)
	{
		ShapeDraftman sd = new ShapeDraftman(g);
		SCollection sc = (SCollection) this.getModel();
		for(Iterator<Shape> it = sc.iterator(); it.hasNext();)
			it.next().accept(sd);
	}

}
