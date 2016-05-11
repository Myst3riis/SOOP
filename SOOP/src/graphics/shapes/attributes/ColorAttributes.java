package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes
{

	public static final String ID = "colors";
	public boolean filled;
	public boolean stroked;
	public Color filledColor = Color.BLACK;
	public Color strokedColor = Color.BLACK;

	public ColorAttributes(boolean filled, boolean stroked, Color filledColor, Color strokedColor)
	{
		this.filled = filled;
		this.stroked = stroked;
		this.filledColor = filledColor;
		this.strokedColor = strokedColor;
	}

	public ColorAttributes(){}

	public boolean filled()
	{
		return this.filled;
	}

	public Color filledColor()
	{
		return this.filledColor;
	}

	public Color strokedColor()
	{
		return this.strokedColor;
	}

	@Override
	public String getID()
	{
		return this.ID;
	}

}
