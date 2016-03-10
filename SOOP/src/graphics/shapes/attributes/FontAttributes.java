package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;

public class FontAttributes extends Attributes
{
	public static final String ID = "font";
	private Font font;
	private Color fontColor;
	private FontRenderContext frc;

	public Rectangle getBounds(String text)
	{
		return (Rectangle)this.font.getStringBounds(text,frc);
	}

	public Font font()
	{
		return this.font;
	}
	
	public Color fontColor()
	{
		return fontColor;
	}
	
	@Override
	public String getID()
	{
		return this.ID;
	}

}
