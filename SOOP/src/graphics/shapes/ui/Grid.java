package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;

public class Grid
{

	private final int LIMITX = 2000;
	private final int LIMITY = 2000;
	private int zoomValue = 100;
	private int spacing = 20;
	private Color color = new Color(232, 232, 232); // #A0AAAD
	private int xOffset = 0;
	private int yOffset = 0;
	private Graphics g;
	private int coordDensity = 3;

	public Grid(Graphics g)
	{
		this.g = g;
	}

	public void drawGrid()
	{
		this.g.setColor(this.color);
		for (int i = 0; i < this.LIMITX / this.spacing; i++)
		{
			this.g.drawLine(i * this.spacing, this.yOffset, i * this.spacing, this.LIMITY);
			if(i * this.spacing % this.coordDensity  * this.spacing == 0 && i * this.spacing > 0)
				this.g.drawString(Integer.toString(i * this.spacing), i * this.spacing - this.g.getFontMetrics().stringWidth(Integer.toString(i * this.spacing)) / 2, this.yOffset + this.spacing);
		}
		for (int i = 0; i < this.LIMITY / this.spacing; i++)
		{
			this.g.drawLine(this.xOffset, i * this.spacing, this.LIMITX, i * this.spacing);
			if(i * this.spacing % this.coordDensity  * this.spacing == 0 && i * this.spacing > 0)
				this.g.drawString(Integer.toString(i * this.spacing), this.xOffset, i * this.spacing + this.g.getFontMetrics().getHeight() / 3);
		}
	}

	public void translate(int dx, int dy)
	{
		// déplace la grid
		this.xOffset = dx;
		this.yOffset = dy;
		drawGrid();

		// déplace les formes
		// ...collection.translate(dx,dy);
	}
	
	public void updateZoomLevel(int zoom) {
		
	}

	public void updateSpacing()
	{
		// spacing = ...
	}

	public void zoom()
	{
		// TODO
	}

	public void updateGraphics(Graphics g)
	{
		this.g = g;
	}

}
