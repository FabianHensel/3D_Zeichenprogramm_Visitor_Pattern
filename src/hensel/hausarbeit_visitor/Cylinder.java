package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 01.03.2021
 * Klasse Cylinder: Die konkrete Elementklasse Cylinder
 * 
 */

public class Cylinder extends Shape3D {

	private double radius;
	private double height;
	
	/**
	 * @param pointX : Koordinate x für die räumliche Bestimmung
	 * @param pointY : Koordinate y für die räumliche Bestimmung
	 * @param pointZ : Koordinate z für die räumliche Bestimmung
	 * @param radius : Der Radius des Zylinders
	 * @param height : Die Höhe des Zylinders
	 */
	public Cylinder(double pointX, double pointY, double pointZ, double radius, double height) {
		super(pointX, pointY, pointZ);
		this.radius = Math.abs(radius);
		this.height = Math.abs(height);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitCylinder(this);
	}
	
	/**
	 * @return Mantelfläche des Zylinders
	 */
	// Berechnet die Mantelfläche eines Zylinders
	public double calcOuterSurface() {
		return Math.PI * radius * 2 * height;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Zylinder | Mantelfläche=" + Math.round(100.0 * calcOuterSurface()) / 100.0;
	}
}
