package graphics.shapes;

//import graphics.shapes.attributes.Attributes;
//import graphics.shapes.attributes.ColorAttributes;
//import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape
{

	private Rectangle rect;
	private Point loc;

	public SRectangle(Point loc, int width, int height)
	{
		this.rect = new Rectangle(loc.x, loc.y, width, height);
		this.loc = new Point(loc);
	}

	public Rectangle getRect()
	{
		return this.getBounds();
	}

	@Override
	public Point getLoc()
	{
		return this.rect.getLocation();
	}

	@Override
	public void setLoc(Point loc)
	{
		this.rect.setLocation(loc);
	}

	@Override
	public void translate(int dx, int dy)
	{
		this.loc.setLocation(dx, dy);
		this.setLoc(this.loc);
	}

	@Override
	public Rectangle getBounds()
	{
		return new Rectangle(this.rect);
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		sv.visitRectangle(this);
	}

}
