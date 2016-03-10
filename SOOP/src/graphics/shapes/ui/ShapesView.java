package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.SCircle;
import graphics.shapes.SText;
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
		SText txt = (SText)this.getModel();
		g.drawString(txt.getText(), txt.getLoc().x, txt.getLoc().y);
		
	}

}
