package graphics.shapes.attributes;

import graphics.shapes.Shape;

public class SelectionAttributes extends Attributes
{
	public static final String ID = "selection";
	
	private boolean selected = false;

	public boolean isSelected()
	{
		return this.selected;
	}

	public void select(Shape shp)
	{
		this.selected = true;
		System.out.println(shp.getLoc() + "SELECTED");
	}

	public void unselect(Shape shp)
	{
		this.selected = false;
		System.out.println(shp.getLoc() +"UNSELECTED");
	}

	public void toggleSelection()
	{
		this.selected = !this.selected;
	}

	@Override
	public String getID()
	{
		return this.ID;
	}
}
