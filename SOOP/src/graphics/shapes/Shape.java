package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

import graphics.shapes.attributes.Attributes;

public abstract class Shape
{

	HashMap<String, Attributes> hmap = new HashMap<String, Attributes>();

	public void addAttributes(Attributes attr)
	{
		this.hmap.put(attr.getID(), attr);
	}

	public Attributes getAttributes(String id)
	{
		return this.hmap.get(id);
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point pt);

	public abstract void translate(int dx, int dy);

	public abstract Rectangle getBounds();

	public abstract void accept(ShapeVisitor sv);

	public String toString()
	{
		StringBuilder res = new StringBuilder('[');
		res.append(this.getClass().getSimpleName());
		res.append(", ");
		res.append(this.getBounds().toString());
		res.append(", ");
		boolean colors = (this.getAttributes("colors") != null);
		res.append("ColorAttributes " + colors);
		res.append(", ");
		boolean font = (this.getAttributes("font") != null);
		res.append("FontAttributes " + font);
		res.append(", ");
		boolean selection = (this.getAttributes("selection") != null);
		res.append("SelectionAttributes " + selection);
		res.append(']');
		return res.toString();
	}

}
