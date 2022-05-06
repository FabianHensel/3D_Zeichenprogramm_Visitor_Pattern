package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * Klasse RotateVisitor: Beschreibt die Rotation einer 3D-Form
 *
 */

public class RotateVisitor extends Visitor {
	
	public double[] rotate;
	private double xAngle;
	private double yAngle;
	private double zAngle;
	
	/**
	 * @param allAngle : Winkel für alle Achsen
	 */
	// Ein Winkel für alle Achsen
	public RotateVisitor(int allAngle) {
		// Die Math.cos() und Math.sin() Methoden benötigen den Winkel im Bogenmaß
		xAngle = allAngle * Math.PI/180;
		yAngle = allAngle * Math.PI/180;
		zAngle = allAngle * Math.PI/180;
		rotate = new double[3];
	}
	
	/**
	 * @param xAngle : Der x-Winkel für die Rotation
	 * @param yAngle : Der y-Winkel für die Rotation
	 * @param zAngle : Der z-Winkel für die Rotation
	 */
	// Für jede Achse ein Winkel
	public RotateVisitor(int xAngle, int yAngle, int zAngle) {
		this.xAngle = xAngle * Math.PI/180;
		this.yAngle = yAngle * Math.PI/180;
		this.zAngle = zAngle * Math.PI/180;
		rotate = new double[3];
	}

	@Override
	public void visitCylinder(Cylinder cylinder) {
		// Rotation x-Achse
		rotate[0] = cylinder.getPointX();
		rotate[1] = cylinder.getPointY() * Math.cos(xAngle) - cylinder.getPointZ() * Math.sin(xAngle);
		rotate[2] = cylinder.getPointY() * Math.sin(xAngle) + cylinder.getPointZ() * Math.cos(xAngle);
		
		// Rotation y-Achse
		rotate[0] = rotate[2] * Math.sin(yAngle) + cylinder.getPointX() * Math.cos(yAngle);
		rotate[2] = rotate[2] * Math.cos(yAngle) - cylinder.getPointX() * Math.sin(yAngle);
		
		// Rotation z-Achse
		double newX = rotate[0];
		rotate[0] = newX * Math.cos(zAngle) - rotate[1] * Math.sin(zAngle);
		rotate[1] = newX * Math.sin(zAngle) + rotate[1] * Math.cos(zAngle);
	}
	
	@Override
	public void visitCuboid(Cuboid cuboid) {
		// Rotation x-Achse
		rotate[0] = cuboid.getPointX();
		rotate[1] = cuboid.getPointY() * Math.cos(xAngle) - cuboid.getPointZ() * Math.sin(xAngle);
		rotate[2] = cuboid.getPointY() * Math.sin(xAngle) + cuboid.getPointZ() * Math.cos(xAngle);
				
		// Rotation y-Achse
		rotate[0] = rotate[2] * Math.sin(yAngle) + cuboid.getPointX() * Math.cos(yAngle);
		rotate[2] = rotate[2] * Math.cos(yAngle) - cuboid.getPointX() * Math.sin(yAngle);
				
		// Rotation z-Achse
		double newX = rotate[0];
		rotate[0] = newX * Math.cos(zAngle) - rotate[1] * Math.sin(zAngle);
		rotate[1] = newX * Math.sin(zAngle) + rotate[1] * Math.cos(zAngle);
	}
	
	@Override
	public void visitCone(Cone cone) {
		// Rotation x-Achse
		rotate[0] = cone.getPointX();
		rotate[1] = cone.getPointY() * Math.cos(xAngle) - cone.getPointZ() * Math.sin(xAngle);
		rotate[2] = cone.getPointY() * Math.sin(xAngle) + cone.getPointZ() * Math.cos(xAngle);
				
		// Rotation y-Achse
		rotate[0] = rotate[2] * Math.sin(yAngle) + cone.getPointX() * Math.cos(yAngle);
		rotate[2] = rotate[2] * Math.cos(yAngle) - cone.getPointX() * Math.sin(yAngle);
				
		// Rotation z-Achse
		double newX = rotate[0];
		rotate[0] = newX * Math.cos(zAngle) - rotate[1] * Math.sin(zAngle);
		rotate[1] = newX * Math.sin(zAngle) + rotate[1] * Math.cos(zAngle);
	}
	
	public double[] getRotate() {
		return rotate;
	}
}
