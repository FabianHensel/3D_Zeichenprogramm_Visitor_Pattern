package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * Klasse TranslateVisitor: Beschreibt die Translation einer 3D-Form
 *
 */

public class TranslateVisitor extends Visitor {

	private double[] translate;
	private int tx;
	private int ty;
	private int tz;
	
	/**
	 * @param tAll : Translatiert für genau einen Wert in alle Richtungen
	 */
	// Ein Translatierfaktor für alle Koordinaten
	public TranslateVisitor(int tAll) {
		tx = tAll;
		ty = tAll;
		tz = tAll;
		translate = new double[3];
	}
	
	/**
	 * @param tx : Translatiert in x-Richtung
	 * @param ty : Translatiert in y-Richtung
	 * @param tz : Translatiert in z-Richtung
	 */
	// Für jede Koordinate ein Translatierfaktor
	public TranslateVisitor(int tx, int ty, int tz) {
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		translate = new double[3];
	}
	
	@Override
	public void visitCylinder(Cylinder cylinder) {
		double newX = cylinder.getPointX() + tx;
		double newY = cylinder.getPointY() + ty;
		double newZ = cylinder.getPointZ() + tz;
		
		translate[0] = newX;
		translate[1] = newY;
		translate[2] = newZ;
	}
	
	@Override
	public void visitCuboid(Cuboid cuboid) {
		double newX = cuboid.getPointX() + tx;
		double newY = cuboid.getPointY() + ty;
		double newZ = cuboid.getPointZ() + tz;
		
		translate[0] = newX;
		translate[1] = newY;
		translate[2] = newZ;
	}
	
	@Override
	public void visitCone(Cone cone) {
		double newX = cone.getPointX() + tx;
		double newY = cone.getPointY() + ty;
		double newZ = cone.getPointZ() + tz;
		
		translate[0] = newX;
		translate[1] = newY;
		translate[2] = newZ;
	}
	
	public double[] getTranslate() {
		return translate;
	}
}
