package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 01.03.2021
 * Klasse Cone: Die konkrete Elementklasse Cone
 * 
 */

public class Cone extends Shape3D {

	private double radius;
	private double height;
	
	/**
	 * @param pointX : Koordinate x für die räumliche Bestimmung
	 * @param pointY : Koordinate y für die räumliche Bestimmung
	 * @param pointZ : Koordinate z für die räumliche Bestimmung
	 * @param radius : Der Radius für den Kegel
	 * @param height : Die Höhe für den Kegel
	 */
	public Cone(double pointX, double pointY, double pointZ, double radius, double height) {
		super(pointX, pointY, pointZ);
		this.radius = Math.abs(radius);
		this.height = Math.abs(height);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitCone(this);
	}
	
	/**
	 * @return Seitenschräge des Kegels
	 */
	// Berechnet die Seitenschräge eines Kegels
	public double calcSideSlope() {
		return Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
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
		return "Kegel | Seitenschräge=" + Math.round(100.0 * calcSideSlope()) / 100.0;
	}
}
