package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * Klasse ScaleVisitor: Beschreibt die Skalierung einer 3D-Form
 *
 */

public class ScaleVisitor extends Visitor {

	private double[] scale;
	private int sx;
	private int sy;
	private int sz;
	
	/**
	 * @param sAll : Skaliert für genau einen Wert in alle Richtungen
	 */
	// Ein Skalierfaktor für alle Koordinaten
	public ScaleVisitor(int sAll) {
		sx = sAll;
		sy = sAll;
		sz = sAll;
		scale = new double[3];
	}
	
	/**
	 * @param tx : Skaliert in x-Richtung
	 * @param ty : Skaliert in y-Richtung
	 * @param tz : Skaliert in z-Richtung
	 */
	// Für jede Koordinate ein Skalierfaktor
	public ScaleVisitor(int sx, int sy, int sz) {
		this.sx = sx;
		this.sy = sy;
		this.sz = sz;
		scale = new double[3];
	}
	
	@Override
	public void visitCylinder(Cylinder cylinder) {
		double newX = cylinder.getPointX() * sx;
		double newY = cylinder.getPointY() * sy;
		double newZ = cylinder.getPointZ() * sz;
		
		scale[0] = newX;
		scale[1] = newY;
		scale[2] = newZ;
		
		// Durch die Skalierung wird auch die Größe der Form geändert
		// Für den Radius wird der Durchschnitt ermittelt, d.h. der Zylinder (und auch der Kegel) bleiben immer rund und werden nicht oval.
		cylinder.setRadius((cylinder.getRadius() * Math.abs(sx) + cylinder.getRadius() * Math.abs(sz)) / 2);
		cylinder.setHeight(cylinder.getHeight() * Math.abs(sy));
	}
	
	@Override
	public void visitCuboid(Cuboid cuboid) {
		double newX = cuboid.getPointX() * sx;
		double newY = cuboid.getPointY() * sy;
		double newZ = cuboid.getPointZ() * sz;
		
		scale[0] = newX;
		scale[1] = newY;
		scale[2] = newZ;
		
		// Durch die Skalierung wird auch die Größe der Form geändert
		cuboid.setHeight(cuboid.getHeight() * Math.abs(sy));
		cuboid.setWidth(cuboid.getWidth() * Math.abs(sx));
		cuboid.setDepth(cuboid.getDepth() * Math.abs(sz));
	}
	
	@Override
	public void visitCone(Cone cone) {
		double newX = cone.getPointX() * sx;
		double newY = cone.getPointY() * sy;
		double newZ = cone.getPointZ() * sz;
		
		scale[0] = newX;
		scale[1] = newY;
		scale[2] = newZ;
		
		// Durch die Skalierung wird auch die Größe der Form geändert
		cone.setRadius((cone.getRadius() * Math.abs(sx) + cone.getRadius() * Math.abs(sz)) / 2);
		cone.setHeight(cone.getHeight() * Math.abs(sy));
	}
	
	public double[] getScale() {
		return scale;
	}
}
