package hensel.hausarbeit_visitor;

/**
 * 
 * @author Fabian Hensel
 * @since 01.03.2021
 * Klasse Main: Der Client
 *
 */

public class Main {

	public static void main(String[] args) {
		// Erzeugung eines Canvas Objekts
		Canvas canvas = new Canvas();
		
		// Vier Nachkommastellen werden festgelegt
		canvas.setDecimalPlace(4);
		
		// Erzeugung der konkreten Elementobjekte
		Shape3D cylinder = new Cylinder(5, 3, 2, 5, 10);
		Shape3D cone = new Cone(5, 8, 3, 5, 10);
		Shape3D cuboid = new Cuboid(5, 8, 9, 3, 4, 5);
		
		// Einfügen in die Zeichenfläche
		canvas.addShape(cylinder);
		canvas.addShape(cone);
		canvas.addShape(cuboid);
		
		// canvas.clearCanvas();
		// canvas.removeSingleShape(cone);
		
		// Aufruf der Canvas Methoden
		canvas.rotateAllShapes(20, 20, 20);
		canvas.rotateSingleShape(20, 20, 20, 1);
		canvas.scaleAllShapes(3, 2, -4);
		canvas.scaleSingleShape(3, 1, -5, 2);
		canvas.translateAllShapes(4, 7, 9);
		canvas.translateSingleShape(3, 1, 5, 3);
		
		System.out.println(canvas.calcTotalVolume());
		System.out.println(canvas.calcVolumeSingleShape(1));
	}
}
