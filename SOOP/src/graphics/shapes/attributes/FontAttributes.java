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

	public FontAttributes()
	{
		
	}
	
	public void setFontRenderContext(Graphics g) {
		this.frc = ((Graphics2D) g).getFontRenderContext();
		this.font = g.getFont();
	}

	public Rectangle getBounds(String text)
	{
		return this.font.getStringBounds(text, frc).getBounds(); // La classe Rectangle2D dont hérite Rectangle et renvoyée par getStringBounds() ne peut pas être casté directement en Rectangle. On doit utiliser la méthode getBounds() de celle-ci.
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
