package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.OffsetAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapesController implements MouseListener, MouseMotionListener, KeyListener, MouseWheelListener
{
	private SCollection model;
	private ShapesView sview;

	private int lastShapeRegisteredeX; // L'abscisse du curseur pour le drag
										// multiple
	private int lastShapeRegisteredeY; // L'ordonnée du curseur pour le drag
										// multiple

	private boolean ctrlPressed = false;
	private boolean shiftDown;
	private boolean shapeRegistered;

	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public ShapesController(SCollection model)
	{
		this.model = model;
	}

	public void setView(ShapesView sview)
	{
		this.sview = sview;
	}

	final public ShapesView getView()
	{
		return this.sview;
	}

	public void setModel(SCollection model)
	{
		this.model = model;
	}

	public Object getModel()
	{
		return this.model;
	}

	public void mousePressed(MouseEvent e)
	{
		this.shapeRegistered = false;

		for (Iterator<Shape> it = this.model.iterator(); it.hasNext();)
		{
			Shape shape = it.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");

			if (shape.getBounds().contains(e.getX(), e.getY()))
			{
				this.shapeRegistered = true;
				this.lastShapeRegisteredeX = e.getX();
				this.lastShapeRegisteredeY = e.getY();

				if (shiftDown)
				{
					if (!this.shapes.contains(shape))
					{
						this.sview.paintComponent(this.sview.getGraphics());
						this.shapes.add(shape);

						/*
						 * Si la forme "pressée" est une collection ajoute
						 * l'ensemble de ses formes à elle à la liste.
						 */
						/*
						 * En outre on s'assure que les formes ajoutées ici sont
						 * rajoutées après la collection.
						 */

						if (shape.getClass().getSimpleName().equals("SCollection"))
							for (Iterator<Shape> it2 = ((SCollection) shape).iterator(); it2.hasNext();)
							{
								Shape shape2 = it2.next();
								SelectionAttributes selection2 = (SelectionAttributes) shape2
										.getAttributes("selection");
								selection2.select();
								this.shapes.add(shape2);
								this.sview.getShapeDraftman().SelectionSquares(shape2);
							}
						selection.select();
						this.sview.getShapeDraftman().SelectionSquares(shape);
					}
					else
					{
						this.shapes.remove(shape);
						if (shape.getClass().getSimpleName().equals("SCollection"))
							for (Iterator<Shape> it2 = ((SCollection) shape).iterator(); it2.hasNext();)
							{
								Shape shape2 = it2.next();
								SelectionAttributes selection2 = (SelectionAttributes) shape2
										.getAttributes("selection");
								selection2.unselect();
								this.shapes.remove(shape2);
								this.sview.getShapeDraftman().SelectionSquares(shape2);
							}
						selection.unselect();
						this.sview.getShapeDraftman().SelectionSquares(shape);
						this.sview.paintComponent(this.sview.getGraphics());
					}
				}
				else
				{
					if (this.shapes.isEmpty())
					{
						this.sview.paintComponent(this.sview.getGraphics());
						this.shapes.add(shape);

						if (shape.getClass().getSimpleName().equals("SCollection"))
							for (Iterator<Shape> it2 = ((SCollection) shape).iterator(); it2.hasNext();)
							{
								Shape shape2 = it2.next();
								SelectionAttributes selection2 = (SelectionAttributes) shape2
										.getAttributes("selection");
								selection2.select();
								this.shapes.add(shape2);
								this.sview.getShapeDraftman().SelectionSquares(shape2);
							}

						selection.select();
						this.sview.getShapeDraftman().SelectionSquares(shape);
					}
					else if (this.shapes.size() == 1)
					{
						((SelectionAttributes) this.shapes.get(0).getAttributes("selection")).unselect();
						this.sview.getShapeDraftman().SelectionSquares(this.shapes.get(0));
						this.shapes.remove(0);
						this.sview.paintComponent(this.sview.getGraphics());
						this.shapes.add(shape);

						if (shape.getClass().getSimpleName().equals("SCollection"))
							for (Iterator<Shape> it2 = ((SCollection) shape).iterator(); it2.hasNext();)
							{
								Shape shape2 = it2.next();
								SelectionAttributes selection2 = (SelectionAttributes) shape2
										.getAttributes("selection");
								selection2.select();
								this.shapes.add(shape2);
								this.sview.getShapeDraftman().SelectionSquares(shape2);
							}

						selection.select();
						this.sview.getShapeDraftman().SelectionSquares(shape);
					}

					else if (this.shapes.get(0).getClass().getSimpleName().equals("SCollection"))
					{

						for (Iterator<Shape> it2 = ((SCollection) shapes.get(0)).iterator(); it2.hasNext();)
						{
							Shape shape2 = it2.next();
							SelectionAttributes selection2 = (SelectionAttributes) shape2.getAttributes("selection");
							selection2.unselect();
							this.shapes.remove(shape2);
							this.sview.getShapeDraftman().SelectionSquares(shape2);
						}

						this.shapes.remove(0);
						this.shapes.add(shape);

						if (shape.getClass().getSimpleName().equals("SCollection"))
							for (Iterator<Shape> it2 = ((SCollection) shape).iterator(); it2.hasNext();)
							{
								Shape shape2 = it2.next();
								SelectionAttributes selection2 = (SelectionAttributes) shape2
										.getAttributes("selection");
								selection2.select();
								this.shapes.add(shape2);
								this.sview.getShapeDraftman().SelectionSquares(shape2);
							}

						selection.select();
						this.sview.getShapeDraftman().SelectionSquares(shape);
					}
				}
			}
		}

		if (shapeRegistered)
		{
			for (Iterator<Shape> it = this.shapes.iterator(); it.hasNext();)
			{
				Shape shape = it.next();
				((OffsetAttributes) shape.getAttributes("offset"))
						.setOffsetX(this.lastShapeRegisteredeX - shape.getBounds().x);
				((OffsetAttributes) shape.getAttributes("offset"))
						.setOffsetY(this.lastShapeRegisteredeY - shape.getBounds().y);
			}
		}

		if (!shiftDown && !shapeRegistered)
		{
			int size = this.shapes.size(); // La taille de la liste diminue
											// aussi
											// !!!!
			for (int i = size - 1; i >= 0; i--)
			{ // Il faut bien savoir parcourir une liste en train d'être
				// dimunuée !!
				((SelectionAttributes) this.shapes.get(i).getAttributes("selection")).unselect();
				this.sview.getShapeDraftman().SelectionSquares(this.shapes.get(i));
				this.shapes.remove(this.shapes.get(i));
				this.sview.paintComponent(this.sview.getGraphics());
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
		for (Iterator<Shape> it = this.shapes.iterator(); it.hasNext();)
		{

			Shape shape = it.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");

			if (selection.isSelected() && !shiftDown)
			{
				selection.drag();
				int dx = evt.getX();
				int dy = evt.getY();
				int selectSquareSize = this.sview.getShapeDraftman().getSelectSquareSize();

				int x = shape.getBounds().x;
				int y = shape.getBounds().y;
				int width = shape.getBounds().width;
				int height = shape.getBounds().height;

				Graphics g = this.sview.getGraphics();
				/* Ici on cache le fond de la l'ancienne forme */
				g.clearRect(x, y, width, height);
				g.clearRect(x - selectSquareSize, y - selectSquareSize, selectSquareSize, selectSquareSize);
				g.clearRect(x + width, y + height, selectSquareSize, selectSquareSize);
				/* Ici on cache le contour de l'ancienne forme */
				g.setColor(Color.WHITE);
				g.drawRect(x, y, width, height);

				shape.translate(dx - ((OffsetAttributes) shape.getAttributes("offset")).getOffsetX(),
						dy - ((OffsetAttributes) shape.getAttributes("offset")).getOffsetY());
				this.sview.paintComponent(this.sview.getGraphics());
				this.sview.getShapeDraftman().SelectionSquares(shape);
				selection.unDrag();
			}
		}
	}

	public void keyTyped(KeyEvent evt)
	{
	}

	public void keyPressed(KeyEvent evt)
	{
		if (evt.getKeyCode() == 17 && !ctrlPressed)
			this.ctrlPressed = true;

		if (evt.getKeyCode() == 16 && !shiftDown)
		{
			this.shiftDown = true;
		}

	}

	public void keyReleased(KeyEvent evt)
	{
		if (evt.getKeyCode() == 17 && ctrlPressed)
			this.ctrlPressed = false;

		if (evt.getKeyCode() == 16 && shiftDown)
		{
			this.shiftDown = false;
		}
		if (evt.getKeyCode() == 127)
		{
			int size = this.model.size();
			for (int i = size - 1; i >= 0; i--)
			{
				if(((SelectionAttributes) this.model.get(i).getAttributes("selection")).isSelected()) {
					Graphics g = this.sview.getGraphics();
					int selectSquareSize = this.sview.getShapeDraftman().getSelectSquareSize();
					int x = this.model.get(i).getBounds().x;
					int y = this.model.get(i).getBounds().y;
					int width = this.model.get(i).getBounds().width;
					int height = this.model.get(i).getBounds().height;
					/* Ici on cache le fond de la l'ancienne forme */
					g.clearRect(x, y, width, height);
					g.clearRect(x - selectSquareSize, y - selectSquareSize, selectSquareSize, selectSquareSize);
					g.clearRect(x + width, y + height, selectSquareSize, selectSquareSize);
					/* Ici on cache le contour de l'ancienne forme */
					g.setColor(Color.WHITE);
					g.drawRect(x, y, width, height);
					this.model.remove(this.model.get(i));
					this.sview.paintComponent(this.sview.getGraphics());
				}
			}
			this.sview.paintComponent(this.sview.getGraphics());
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if (this.ctrlPressed)
			this.sview.getGrid().updateZoomLevel(e.getWheelRotation() * 2);
	}
}