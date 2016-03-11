package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;

public class FontAttributes extends Attributes
{
	public static final String ID = "font";
	
	private Font font;
	private Color fontColor;
	private FontRenderContext frc;

	public FontAttributes(Font font, Color fontColor, Graphics graphics)
	{
		this.font = font;
		this.fontColor = fontColor;
		this.frc = ((Graphics2D) graphics).getFontRenderContext();
	}

	public FontAttributes()
	{
	}

	public Rectangle getBounds(String text)
	{
		return (Rectangle)this.font.getStringBounds(text, frc);
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
