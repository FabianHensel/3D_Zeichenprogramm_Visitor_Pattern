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
	 * @param pointX : Koordinate x f�r die r�umliche Bestimmung
	 * @param pointY : Koordinate y f�r die r�umliche Bestimmung
	 * @param pointZ : Koordinate z f�r die r�umliche Bestimmung
	 * @param radius : Der Radius f�r den Kegel
	 * @param height : Die H�he f�r den Kegel
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
	 * @return Seitenschr�ge des Kegels
	 */
	// Berechnet die Seitenschr�ge eines Kegels
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
		return "Kegel | Seitenschr�ge=" + Math.round(100.0 * calcSideSlope()) / 100.0;
	}
}
