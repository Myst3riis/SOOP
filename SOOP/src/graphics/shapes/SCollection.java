package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class SCollection extends Shape
{

	private ArrayList arr = new ArrayList();

	public Iterator iterator()
	{
		return this.hmap.keySet().iterator();
	}

	public void add(Shape shape)
	{
		this.arr.add(shape);
	}

	@Override
	public Point getLoc()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLoc(Point pt)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void translate(int dx, int dy)
	{
		// TODO Auto-generated method stub

	}

}
