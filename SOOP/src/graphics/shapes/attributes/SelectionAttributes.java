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

	public void select(Shape shape)
	{
		this.selected = true;
		System.out.println(shape.getBounds() + "SELECTED");
	}

	public void unselect(Shape shape)
	{
		this.selected = false;
		System.out.println(shape.getBounds() + "UNSELECTED");
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
