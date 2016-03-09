package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class SCollection extends Shape
{

	private ArrayList<Shape> arr = new ArrayList<Shape>();

	public Iterator<Shape> iterator()
	{
		return this.arr.iterator();
	}

	public void add(Shape shape)
	{
		this.arr.add(shape);
	}

	@Override
	public Point getLoc()
	{
		// Doit renvoyer le point en haut à gauche de la collection
		return null;
	}

	@Override
	public void setLoc(Point loc)
	{
		for(Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().setLoc(loc);
	}

	@Override
	public Rectangle getBounds()
	{
		// Doit renvoyer un rectangle englobant la collection
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
		for(Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().translate(dx, dy);
	}

}
