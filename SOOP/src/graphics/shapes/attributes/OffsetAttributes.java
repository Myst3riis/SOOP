package graphics.shapes.attributes;

public class OffsetAttributes extends Attributes
{
	public static final String ID = "offset";
	
	private int offsetX;
	private int offsetY;
	
	public String getID()
	{
		return this.ID;
	}

	public int getOffsetX()
	{
		return offsetX;
	}

	public void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}

	public int getOffsetY()
	{
		return offsetY;
	}

	public void setOffsetY(int offsetY)
	{
		this.offsetY = offsetY;
	}
	
}
