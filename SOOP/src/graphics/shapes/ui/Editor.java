package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.OffsetAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class Editor extends JFrame
{
	ShapesView sview;
	SCollection model;

	public Editor()
	{
		super("SOOP");

		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});

		this.buildModel();
		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(600, 600));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);
		this.setBackground(Color.WHITE);
	}

	private void buildModel()
	{

		this.model = new SCollection();
		this.model.addAttributes(new SelectionAttributes());
		
		SRectangle r = new SRectangle(new Point(200, 200), 50, 130);
		r.addAttributes(new ColorAttributes(true, true, Color.BLUE, Color.GREEN));
		r.addAttributes(new SelectionAttributes());
		r.addAttributes(new OffsetAttributes());
		this.model.add(r);
		
		SCircle c = new SCircle(new Point(100, 100), 25);
		c.addAttributes(new ColorAttributes(true, true, Color.BLUE, Color.YELLOW));
		c.addAttributes(new SelectionAttributes());
		c.addAttributes(new OffsetAttributes());
		this.model.add(c);
		
		SCircle c2 = new SCircle(new Point(150, 50), 100);
		c2.addAttributes(new SelectionAttributes());
		c2.addAttributes(new OffsetAttributes());
		this.model.add(c2);
		
		SText t = new SText(new Point(100, 100), "hello");
		t.addAttributes(new ColorAttributes(true, true, Color.YELLOW, Color.BLUE));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		t.addAttributes(new OffsetAttributes());
		this.model.add(t);
		
		/*
		SCollection sc = new SCollection();
		sc.addAttributes(new SelectionAttributes());
		sc.addAttributes(new OffsetAttributes());
		r = new SRectangle(new Point(30, 40), 30, 30);
		r.addAttributes(new ColorAttributes(true, true, Color.MAGENTA, Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		sc.add(r);
		c = new SCircle(new Point(150, 100), 20);
		c.addAttributes(new ColorAttributes(true, true, Color.BLUE, Color.DARK_GRAY));
		c.addAttributes(new SelectionAttributes());
		sc.add(c);
		this.model.add(sc);
		*/
	}

	public static void main(String[] args)
	{
		Editor self = new Editor();
		self.pack();
		self.model.updateBounds(self.sview.getGraphics());
		self.setVisible(true);
		System.out.println(self.model);
	}
}