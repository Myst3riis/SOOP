package graphics.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import graphics.shapes.attributes.FontAttributes;

public class SCollection extends Shape
{
	private int xmin;
	private int ymin;

	private int xmax;
	private int ymax;

	private ArrayList<Shape> arr = new ArrayList<Shape>();

	public SCollection()
	{
		this.xmin = 0;
		this.ymin = 0;
		this.xmax = 0;
		this.ymax = 0;
	}

	public Iterator<Shape> iterator()
	{
		return this.arr.iterator();
	}

	public void add(Shape shape)
	{
		this.arr.add(shape);
	}

	public void updateBounds(Graphics g)
	{
		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
		{

			Shape tmp = it.next();

			if (tmp.getClass().getName().equals("graphics.shapes.SText"))
			{
				FontAttributes fatt = (FontAttributes) ((SText) tmp).getAttributes("font");
				fatt.setFontRenderContext(g);
			}
			else if (tmp.getClass().getName().equals("graphics.shapes.SCollection"))
			{
				((SCollection) tmp).updateBounds(g);
			}
			
			Rectangle rect = tmp.getBounds();

			Point loc = rect.getLocation();

			if (loc.x < this.xmin)
				this.xmin = loc.x;

			if (loc.x + rect.width > this.xmax)
				this.xmax = (loc.x + rect.width);

			if (loc.y < this.ymin)
				this.ymin = loc.y;

			if (loc.y + rect.height > this.ymax)
				this.ymax = (loc.y + rect.height);
		}

	}

	@Override
	public Point getLoc()
	{
		return new Point(this.xmin, this.ymin);
	}

	@Override
	public void setLoc(Point loc)
	{
		this.xmax += (loc.x - this.xmin);
		this.ymax += (loc.y - this.ymin);
		this.xmin = loc.x;
		this.ymin = loc.y;

		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().setLoc(loc);
	}

	@Override
	public Rectangle getBounds()
	{
		return new Rectangle(this.xmin, this.ymin, this.xmax - this.xmin, this.ymax - this.ymin);
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().accept(sv);
	}

	@Override
	public void translate(int dx, int dy)
	{
		this.xmin += dx;
		this.ymin += dy;
		this.xmax += dx;
		this.ymax += dy;

		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().translate(dx, dy);
	}

}
