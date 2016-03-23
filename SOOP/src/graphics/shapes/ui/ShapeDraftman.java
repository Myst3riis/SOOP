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
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftman implements ShapeVisitor
{
	public ColorAttributes DEFAULTCOLORATTRIBUTES;
	private Graphics g;
	private int selectSquareSize = 10;

	public ShapeDraftman(Graphics g)
	{
		this.g = g;
		this.DEFAULTCOLORATTRIBUTES = new ColorAttributes();
	}

	@Override
	public void visitRectangle(SRectangle rect)
	{
		ColorAttributes color = (ColorAttributes) rect.getAttributes("colors");

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

	}

	@Override
	public void visitCircle(SCircle circ)
	{
		ColorAttributes color = (ColorAttributes) circ.getAttributes("colors");
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

	}

	@Override
	public void visitText(SText text)
	{
		ColorAttributes color = (ColorAttributes) text.getAttributes("colors");
		FontAttributes font = (FontAttributes) text.getAttributes("font");

		font.setFontRenderContext(this.g);

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

	}

	@Override
	public void visitCollection(SCollection coll)
	{
		for (Iterator<Shape> it = coll.iterator(); it.hasNext();)
			it.next().accept(this);

		ColorAttributes color = (ColorAttributes) coll.getAttributes("colors");
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
	}

	public void SelectionSquares(Shape shape)
	{
		/* Sert à centraliser l'affichage des carrés de sélection */
		SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");

		int x = shape.getBounds().x;
		int y = shape.getBounds().y;
		int width = shape.getBounds().width;
		int height = shape.getBounds().height;
		int selectSquareSize = this.getSelectSquareSize();

		if (selection != null)
			if (selection.isSelected())
			{
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x - selectSquareSize, y - selectSquareSize, selectSquareSize, selectSquareSize);
				g.fillRect(x + width, y + height, selectSquareSize, selectSquareSize);
			}
			else if ((selection.isSelected() && selection.isDragged()) || !selection.isSelected())
			{
				g.clearRect(x - selectSquareSize, y - selectSquareSize, selectSquareSize, selectSquareSize);
				g.clearRect(x + width, y + height, selectSquareSize, selectSquareSize);
			}
	}

	public void updateGraphics(Graphics g)
	{
		this.g = g;
	}

	public int getSelectSquareSize()
	{
		return selectSquareSize;
	}

	public void setSelectSquareSize(int selectSquareSize)
	{
		this.selectSquareSize = selectSquareSize;
	}

}
