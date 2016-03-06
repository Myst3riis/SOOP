package graphics.shapes;

public interface ShapeVisitor
{

	public abstract void visitRectangle(SRectangle rect);

	public abstract void visitCircle(SCircle circ);

	public abstract void visitText(SCircle text);

	public abstract void visitCollection(SCollection coll);

}
