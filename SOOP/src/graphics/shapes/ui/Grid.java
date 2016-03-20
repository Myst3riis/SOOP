package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
//import graphics.shapes.SCollection;

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
		}
		for (int i = 0; i < this.LIMITY / this.spacing; i++)
		{
			this.g.drawLine(this.xOffset, i * this.spacing, this.LIMITX, i * this.spacing);
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
