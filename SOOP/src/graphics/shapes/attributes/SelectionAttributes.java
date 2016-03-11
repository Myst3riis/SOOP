package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes
{
	public static final String ID = "selection";
	
	private boolean selected;

	public boolean isSelected()
	{
		return this.selected;
	}

	public void select()
	{
		this.selected = true;
	}

	public void unselect()
	{
		this.selected = false;
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
