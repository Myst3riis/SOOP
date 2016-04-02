package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.SelectionAttributes;

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
		StringBuilder res = new StringBuilder();
		res.append('[');
		res.append(this.getClass().getSimpleName());
		res.append(", ");
		res.append("is selected: " + ((SelectionAttributes)this.getAttributes("selection")).isSelected());
		res.append(']');
		return res.toString();
	}
}
