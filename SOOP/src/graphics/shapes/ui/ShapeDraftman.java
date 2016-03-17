package graphics.shapes.ui;

import java.awt.Graphics;
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

	public ShapeDraftman(Graphics g)
	{
		this.g = g;
		this.DEFAULTCOLORATTRIBUTES = new ColorAttributes();
	}

	
	@Override
	public void visitRectangle(SRectangle rect)
	{
		ColorAttributes color = (ColorAttributes)rect.getAttributes("colors");
		SelectionAttributes selection = (SelectionAttributes)rect.getAttributes("selection");
		
		if (color != null){
			if(color.filled){
				g.setColor(color.filledColor);
				g.fillRect(rect.getBounds().x, rect.getBounds().y, rect.getBounds().width, rect.getBounds().height);
			}
			if(color.stroked){
				g.setColor(color.strokedColor);
				g.drawRect(rect.getBounds().x, rect.getBounds().y, rect.getBounds().width, rect.getBounds().height);
			}
		}else{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawRect(rect.getBounds().x, rect.getBounds().y, rect.getBounds().width, rect.getBounds().height);
		}
		if (selection != null && selection.isSelected()){
			g.drawRect(rect.getBounds().x, rect.getBounds().y, 10, 10);
			
		}
			
	}

	
	@Override
	public void visitCircle(SCircle circ)
	{
		ColorAttributes color = (ColorAttributes)circ.getAttributes("colors");
		SelectionAttributes selection = (SelectionAttributes)circ.getAttributes("selection");
		if (color != null){
			if(color.filled){
				g.setColor(color.filledColor);
				g.fillOval(circ.getBounds().x, circ.getBounds().y, circ.getBounds().width, circ.getBounds().height);
			}
			if(color.stroked){
				g.setColor(color.strokedColor);
				g.drawOval(circ.getBounds().x, circ.getBounds().y, circ.getBounds().width, circ.getBounds().height);
			}
		}else{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawOval(circ.getBounds().x, circ.getBounds().y, circ.getBounds().width, circ.getBounds().height);
		}
		if (selection != null && selection.isSelected()){
			g.drawRect(circ.getBounds().x, circ.getBounds().y, 10, 10);
			System.out.println("JE SUIS PASSE");
		}else{
			g.clearRect(circ.getBounds().x, circ.getBounds().y, 10, 10);
		}
	}
	
	
	@Override
	public void visitText(SText text)
	{	
		ColorAttributes color = (ColorAttributes)text.getAttributes("colors");
		
		if (color != null){
			if(color.filled){
				g.setColor(color.filledColor);
				g.fillRect(text.getBounds().x, text.getBounds().y, text.getBounds().width, text.getBounds().height);
			}
			if(color.stroked){
				g.setColor(color.strokedColor);
				g.drawString(text.getText(), text.getLoc().x, text.getLoc().y);
			}
		}else{
			g.setColor(DEFAULTCOLORATTRIBUTES.strokedColor);
			g.drawString(text.getText(), text.getLoc().x, text.getLoc().y);
		}
	}
	

	@Override
	public void visitCollection(SCollection coll)
	{
		for(Iterator<Shape> it = coll.iterator(); it.hasNext();)
			it.next().accept(this);
	}


}
