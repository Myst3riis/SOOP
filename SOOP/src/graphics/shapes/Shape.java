package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

import graphics.shapes.attributes.Attributes;

public abstract class Shape
{

	// Le diagramme des classes l'utilisation d'une HashMap ou une TreeMap au
	// lieu d'une simple ArrayListe.
	HashMap<String, Attributes> hmap = new HashMap<String, Attributes>();

	public void addAttributes(Attributes attr)
	{
		this.hmap.put(attr.getID(), attr);
	}

	public Attributes getAttributes(String id)
	{
		if (hmap.containsKey(id))
			return hmap.get(id);
		else
			return null;
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point pt);

	public void translate(int dx, int dy)
	{

	}

	public abstract Rectangle getBounds();

	public abstract void accept(ShapeVisitor sv);

}
