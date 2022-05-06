package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 01.03.2021
 * Klasse Cuboid: Die konkrete Elementklasse Cuboid
 *
 */

public class Cuboid extends Shape3D {

	private double height;
	private double width;
	private double depth;
	
	/**
	 * @param pointX : Koordinate x für die räumliche Bestimmung
	 * @param pointY : Koordinate y für die räumliche Bestimmung
	 * @param pointZ : Koordinate z für die räumliche Bestimmung
	 * @param height : Die Höhe des Quaders
	 * @param width : Die Breite des Quaders
	 * @param depth : Die Tiefe des Quaders
	 */
	public Cuboid(double pointX, double pointY, double pointZ, double height, double width, double depth) {
		super(pointX, pointY, pointZ);
		this.height = Math.abs(height);
		this.width = Math.abs(width);
		this.depth = Math.abs(depth);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitCuboid(this);
	}
	
	/**
	 * @return Diagonale des Quaders 
	 */
	// Berechnet die Diagonale eines Quaders
	public double calcDiagonal() {
		return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2) + Math.pow(depth, 2));
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getDepth() {
		return depth;
	}
	
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		return "Quader | Diagonale=" + Math.round(100.0 * calcDiagonal()) / 100.0;
	}
}
