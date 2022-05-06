package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 01.03.2021
 * Klasse Visitor: Die abstrakte Oberklasse der konkreten Besucherklassen
 *
 */

public abstract class Visitor {

	/**
	 * @param cylinder : Ein Objekt der konkreten Elementklasse Cylinder
	 */
	public abstract void visitCylinder(Cylinder cylinder);
	
	/**
	 * @param cuboid : Ein Objekt der konkreten Elementklasse Cuboid
	 */
	public abstract void visitCuboid(Cuboid cuboid);
	
	/**
	 * @param cone : Ein Objekt der konkreten Elementklasse Cone
	 */
	public abstract void visitCone(Cone cone);
}
