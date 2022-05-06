package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 01.03.2021
 * Klasse Shape3D: Die abstrakte Oberklasse für die konkreten Elementklassen
 * 
 */

public abstract class Shape3D {

	private double pointX;
	private double pointY;
	private double pointZ;
	
	public Shape3D(double pointX, double pointY, double pointZ) {
		this.pointX = pointX;
		this.pointY = pointY;
		this.pointZ = pointZ;
	}
	
	/**
	 * @param visitor : Ein Objekt vom Typ Visitor, welches die jeweilige visit-Methode aufruft, welche wiederum das konkrete Element erhält
	 */
	// Die für das Visitor Pattern wichtige abstrakte accept-Methode
	public abstract void accept(Visitor visitor);
	
	public double getPointX() {
		return pointX;
	}
	
	public void setPointX(double pointX) {
		this.pointX = pointX;
	}
	
	public double getPointY() {
		return pointY;
	}
	
	public void setPointY(double pointY) {
		this.pointY = pointY;
	}
	
	public double getPointZ() {
		return pointZ;
	}
	
	public void setPointZ(double pointZ) {
		this.pointZ = pointZ;
	}
}
