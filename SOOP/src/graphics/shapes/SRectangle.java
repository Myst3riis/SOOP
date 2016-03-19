package graphics.shapes;

//import graphics.shapes.attributes.Attributes;
//import graphics.shapes.attributes.ColorAttributes;
//import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape
{

	private Rectangle rect;


	public SRectangle(Point point, int width, int height)
	{
		this.rect = new Rectangle(point.x, point.y, width, height);
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
		this.setLoc(new Point(dx, dy));
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
