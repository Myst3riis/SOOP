package graphics.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class SCollection extends Shape
{
	private int xmin = 2000;
	private int ymin = 2000;

	private int xmax = 0;
	private int ymax = 0;
	
	private Point loc;
	
	private Rectangle rect = new Rectangle(this.xmin, this.ymin, this.xmax - this.xmin, this.ymax - this.ymin);

	private ArrayList<Shape> arr = new ArrayList<Shape>();

	public SCollection()
	{
		this.loc = new Point(xmin, ymin);
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
		/* Il faut remettre les dimensions à leur valeur par défaut pour prendre en compte les ajouts et suppressions de formes. */
		this.xmin = 2000;
		this.ymin = 2000;

		this.xmax = 0;
		this.ymax = 0;
		
		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
		{
	
			Shape shape = it.next();

			if (shape.getClass().getSimpleName().equals("SText"))
			{
				FontAttributes fatt = (FontAttributes) ((SText) shape).getAttributes("font");
				fatt.setFontRenderContext(g);
			}
			else if (shape.getClass().getSimpleName().equals("SCollection"))
			{
				((SCollection) shape).updateBounds(g);
			}

			Rectangle rect = shape.getBounds();

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
		
		this.rect.setBounds(this.xmin, this.ymin, this.xmax - this.xmin, this.ymax - this.ymin);
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
	public Rectangle getBounds()
	{
		return this.rect;
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		sv.visitCollection(this);
	}

	@Override
	public void translate(int dx, int dy)
	{
		this.loc.setLocation(dx, dy);
		this.setLoc(this.loc);
		// On dissocie les méthodes de translate des SCollections de leurs formes.
	}
	
	public void remove(Shape shape) {
		this.arr.remove(shape);
	}
	
	public int size()
	{
		return this.arr.size();
	}

	public Shape get(int i)
	{
		return this.arr.get(i);
	}

	public String toString()
	{
		StringBuilder res = new StringBuilder(" Collection");
		res.append(", ");
		res.append(this.getBounds().toString());
		res.append(", ");
		res.append("is selected: " + ((SelectionAttributes)this.getAttributes("selection")).isSelected());
		res.append("[");
		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
			res.append(it.next().toString());
		res.append("]EndCollection ");
		return res.toString();
	}
}
