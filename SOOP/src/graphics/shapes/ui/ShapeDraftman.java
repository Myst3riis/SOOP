package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftman implements ShapeVisitor
{
	public ColorAttributes DEFAULTCOLORATTRIBUTES;
	private Graphics g;
	public static int selectSquareSize = 10;

	public ShapeDraftman(Graphics g)
	{
		this.g = g;
		this.DEFAULTCOLORATTRIBUTES = new ColorAttributes();
	}

	@Override
	public void visitRectangle(SRectangle rect)
	{
		ColorAttributes color = (ColorAttributes) rect.getAttributes("colors");
		SelectionAttributes selection = (SelectionAttributes) rect.getAttributes("selection");

		int x = rect.getBounds().x;
		int y = rect.getBounds().y;
		int width = rect.getBounds().width;
		int height = rect.getBounds().height;

		if (color != null)
		{
			if (color.filled)
			{
				g.setColor(color.filledColor);
				g.fillRect(x, y, width, height);
			}
			if (color.stroked)
			{
				g.setColor(color.strokedColor);
				g.drawRect(x, y, width, height);
			}
		}
		else
		{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawRect(x, y, width, height);
		}

		if (selection != null)
			if (selection.isSelected())
			{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.fillRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
			else if((selection.isSelected() && selection.isDragged()) || !selection.isSelected())
			{
				g.clearRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.clearRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
	}

	@Override
	public void visitCircle(SCircle circ)
	{
		ColorAttributes color = (ColorAttributes) circ.getAttributes("colors");
		SelectionAttributes selection = (SelectionAttributes) circ.getAttributes("selection");

		int x = circ.getBounds().x;
		int y = circ.getBounds().y;
		int width = circ.getBounds().width;
		int height = circ.getBounds().height;

		if (color != null)
		{
			if (color.filled)
			{
				g.setColor(color.filledColor);
				g.fillOval(x, y, width, height);
			}
			if (color.stroked)
			{
				g.setColor(color.strokedColor);
				g.drawOval(x, y, width, height);
			}
		}
		else
		{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawOval(x, y, width, height);
		}

		if (selection != null)
			if (selection.isSelected())
			{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.fillRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
			else
			{
				g.clearRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.clearRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
	}

	@Override
	public void visitText(SText text)
	{
		ColorAttributes color = (ColorAttributes) text.getAttributes("colors");
		SelectionAttributes selection = (SelectionAttributes) text.getAttributes("selection");

		int x = text.getBounds().x;
		int y = text.getBounds().y;
		int width = text.getBounds().width;
		int height = text.getBounds().height;
		String word = text.getText();
		Point loc = text.getLoc();

		if (color != null)
		{
			if (color.filled)
			{
				g.setColor(color.filledColor);
				g.fillRect(x, y, width, height);
			}
			if (color.stroked)
			{
				g.setColor(color.strokedColor);
				g.drawString(word, loc.x, loc.y);
			}
		}
		else
		{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawString(word, loc.x, loc.y);
		}

		if (selection != null)
			if (selection.isSelected())
			{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.fillRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
			else
			{
				g.clearRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.clearRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
	}

	@Override
	public void visitCollection(SCollection coll)
	{

		ColorAttributes color = (ColorAttributes) coll.getAttributes("colors");
		SelectionAttributes selection = (SelectionAttributes) coll.getAttributes("selection");

		int x = coll.getBounds().x;
		int y = coll.getBounds().y;
		int width = coll.getBounds().width;
		int height = coll.getBounds().height;

		if (color != null)
		{
			if (color.filled)
			{
				g.setColor(color.filledColor);
				g.fillRect(x, y, width, height);
			}
			if (color.stroked)
			{
				g.setColor(color.strokedColor);
				g.drawRect(x, y, width, height);
			}
		}
		else
		{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawRect(x, y, width, height);
		}

		if (selection != null)
			if (selection.isSelected())
			{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.fillRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}
			else
			{
				g.clearRect(x - this.selectSquareSize, y - this.selectSquareSize, this.selectSquareSize,
						this.selectSquareSize);
				g.clearRect(x + width, y + height, this.selectSquareSize, this.selectSquareSize);
			}

		for (Iterator<Shape> it = coll.iterator(); it.hasNext();)
			it.next().accept(this);
	}

	public void updateGraphics(Graphics g)
	{
		this.g = g;
	}

}
