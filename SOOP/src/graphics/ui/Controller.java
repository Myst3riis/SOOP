package graphics.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.ui.ShapesView;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.shapes.ui.ShapeDraftman;

public class Controller implements MouseListener, MouseMotionListener, KeyListener
{
	private Object model;
	private View view;
	private int offsetX;
	private int offsetY;

	public Controller(Object newModel)
	{
		model = newModel;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	final public View getView()
	{
		return this.view;
	}

	public void setModel(Object model)
	{
		this.model = model;
	}

	public Object getModel()
	{
		return this.model;
	}

	public void mousePressed(MouseEvent e)
	{
		for (Iterator<Shape> it = ((SCollection) model).iterator(); it.hasNext();)
		{
			Shape shape = it.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");
			if (shape.getBounds().contains(e.getX(), e.getY()))
			{
				selection.select(shape);
				((ShapesView) this.view).paintComponent(this.view.getGraphics());
				offsetX = e.getX() - shape.getBounds().x;
				offsetY = e.getY() - shape.getBounds().y;
			}
			else if (selection.isSelected())
			{
				selection.unselect(shape);
				((ShapesView) this.view).paintComponent(this.view.getGraphics());
			}
		}
	}

	public void mouseReleased(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseMoved(MouseEvent evt)
	{
	}

	public void mouseDragged(MouseEvent evt)
	{
		for (Iterator<Shape> it = ((SCollection) model).iterator(); it.hasNext();)
		{

			Shape shape = it.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");
			if (selection.isSelected())
			{
				selection.drag();
				int dx = evt.getX();
				int dy = evt.getY();
				
				int x = shape.getBounds().x;
				int y = shape.getBounds().y;
				int width = shape.getBounds().width;
				int height = shape.getBounds().height;
				
				Graphics g = this.view.getGraphics();
				g.clearRect(x,y, width, height);
				g.clearRect(x - ShapeDraftman.selectSquareSize, y - ShapeDraftman.selectSquareSize, ShapeDraftman.selectSquareSize,ShapeDraftman.selectSquareSize);
				g.clearRect(x + width, y + height, ShapeDraftman.selectSquareSize, ShapeDraftman.selectSquareSize);
				g.setColor(Color.WHITE);
				g.drawRect(x, y, width, height);
				
				shape.translate(dx - offsetX, dy - offsetY);
				
				((ShapesView) this.view).paintComponent(this.view.getGraphics());
				
			}
		}
	}

	public void keyTyped(KeyEvent evt)
	{

		// CTRL

		// SUPPR
	}

	public void keyPressed(KeyEvent evt)
	{
	}

	public void keyReleased(KeyEvent evt)
	{
	}
}
