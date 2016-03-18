package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
//import graphics.shapes.SCollection;

public class Grid
{

	private final int LIMITX = 300000;
	private final int LIMITY = 300000;
	private int zoomValue;
	private int spacing;
	private Color color = new Color(160, 170, 173); // #A0AAAD
	private int xOffset;
	private int yOffset;
	private Graphics g;

	public Grid(Graphics g)
	{
		this.spacing = 20;
		this.zoomValue = 100;
		this.xOffset = 0;
		this.yOffset = 0;
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
