package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SText extends Shape
{
	
	private String text;
	private Point loc;

	public SText(Point loc, String text)
	{
		this.loc = loc;
		this.text = text;
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
		return null;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void translate(int dx, int dy)
	{
		this.loc.translate(dx, dy);
	}

}
