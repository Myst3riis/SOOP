package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.SCircle;
import graphics.shapes.attributes.ColorAttributes;
import graphics.ui.View;

public class ShapesView extends View
{

	public ShapesView(Object model)
	{
		super(model);
	}

	public void paintComponent(Graphics g)
	{
		SCircle circ = (SCircle) this.getModel();
		g.drawOval(circ.getLoc().x, circ.getLoc().y, 2 * circ.getRadius(), 2 * circ.getRadius());
	}

}
