package graphics.shapes;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Point;
import java.awt.Rectangle;

public class SText extends Shape
{

	private String text;
	private Point loc;

	public SText(Point point, String string)
	{
		// TODO Auto-generated constructor stub
	}

	public void addAttributes(ColorAttributes colorAttributes)
	{
		// TODO Auto-generated method stub

	}

	public void addAttributes(FontAttributes fontAttributes)
	{
		// TODO Auto-generated method stub

	}

	public void addAttributes(SelectionAttributes selectionAttributes)
	{
		// TODO Auto-generated method stub

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
