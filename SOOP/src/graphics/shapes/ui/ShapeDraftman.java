package graphics.shapes.ui;

import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;

public class ShapeDraftman implements ShapeVisitor
{
	public ColorAttributes DEFAULTCOLORATTRIBUTES;
	private Graphics g;

	public ShapeDraftman(Graphics g)
	{
		this.g = g;
	}

	@Override
	public void visitRectangle(SRectangle rect)
	{
		g.drawRect(rect.getBounds().x, rect.getBounds().y, rect.getBounds().width, rect.getBounds().height);
	}

	@Override
	public void visitCircle(SCircle circ)
	{
		g.drawOval(circ.getLoc().x, circ.getBounds().y, circ.getRadius(), circ.getRadius());
	}

	@Override
	public void visitText(SText text)
	{
		g.drawString(text.getText(), text.getLoc().x, text.getLoc().y);
	}

	@Override
	public void visitCollection(SCollection coll)
	{
		for(Iterator<Shape> it = coll.iterator(); it.hasNext();)
			it.next().accept(this);
	}

}
