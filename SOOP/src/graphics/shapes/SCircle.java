package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape
{

	private int radius;
	private Point loc;

	public SCircle(Point loc, int radius)
	{
		this.loc = loc;
		this.radius = radius;
	}

	public int getRadius()
	{
		return this.radius;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public Point getLoc()
	{
		return this.loc;
	}

	@Override
	public void setLoc(Point loc)
	{
		this.loc.setLocation(loc);
	}

	@Override
	public Rectangle getBounds()
	{
		return new Rectangle(this.loc.x, this.loc.y, 2 * this.radius, 2 * this.radius);
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		sv.visitCircle(this);
	}

	@Override
	public void translate(int dx, int dy)
	{
		this.setLoc(new Point(dx, dy));
	}
}
