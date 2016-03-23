package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.attributes.FontAttributes;

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
		FontAttributes txt = (FontAttributes) getAttributes("font");
		Rectangle TXT = txt.getBounds(this.text);
		TXT.translate(this.getLoc().x, this.getLoc().y);
		return TXT;
	}

	public String getText()
	{
		return this.text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	@Override
	public void accept(ShapeVisitor sv)
	{
		sv.visitText(this);
	}

	@Override
	public void translate(int dx, int dy)
	{
		this.loc.setLocation(dx, dy);
	}

}
