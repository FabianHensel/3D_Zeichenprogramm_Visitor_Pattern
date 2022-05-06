package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * Klasse CalcVolumeVisitor: Berechnet das Volumen der 3D-Formen
 *
 */

public class CalcVolumeVisitor extends Visitor {
	
	private double calcVolume;
	
	// Berechnet das Volumen für einen Zylinder
	@Override
	public void visitCylinder(Cylinder cylinder) {
		calcVolume = Math.PI * Math.pow(cylinder.getRadius(), 2) * cylinder.getHeight();
	}
	
	// Berechnet das Volumen für einen Quader
	@Override
	public void visitCuboid(Cuboid cuboid) {
		calcVolume = cuboid.getHeight() * cuboid.getWidth() * cuboid.getDepth();	
	}
	
	// Berechnet das Volumen für einen Kegel
	@Override
	public void visitCone(Cone cone) {
		calcVolume = (1/3d) * Math.PI * Math.pow(cone.getRadius(), 2) * cone.getHeight(); 	
	}
	
	public double getCalcVolume() {
		return calcVolume;
	}
}
