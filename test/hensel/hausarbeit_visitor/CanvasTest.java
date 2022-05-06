package hensel.hausarbeit_visitor;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * JUnit 5 Testklasse CanvasTest
 *
 */

public class CanvasTest {

	Canvas canvas = new Canvas();
	Shape3D cylinder = new Cylinder(5, 3, 2, -5, 10);
	Shape3D cone = new Cone(5, 8, 3, 6, -10);
	Shape3D cuboid = new Cuboid(4, 7, 9, 3, 4, -5);
	
	@Before
	public void before() {
		canvas.clearCanvas();
		canvas.addShape(cylinder);
		canvas.addShape(cone);
		canvas.addShape(cuboid);
		canvas.setDecimalPlace(3);
	}
	
	@Test
	public void testRemoveSingleShape() {
		canvas.removeSingleShape(cone);
		assertEquals(2, canvas.getShapes().size());
		assertSame(cylinder, canvas.getShapes().get(0));
		assertSame(cuboid, canvas.getShapes().get(1));
	}
	
	@Test
	public void testRotateAllShapes() {
		canvas.rotateAllShapes(20, 45, 120);
		
		assertEquals(-4.643, cylinder.getPointX(), 0.001);
		assertEquals(3.773, cylinder.getPointY(), 0.001);
		assertEquals(-1.481, cylinder.getPointZ(), 0.001);
		
		assertEquals(-9.353, cone.getPointX(), 0.001);
		assertEquals(3.217, cone.getPointY(), 0.001);
		assertEquals(0.392, cone.getPointZ(), 0.001);
		
		assertEquals(-8.281, cuboid.getPointX(), 0.001);
		assertEquals(7.344, cuboid.getPointY(), 0.001);
		assertEquals(4.844, cuboid.getPointZ(), 0.001);
		
		// Konsolenausgabe muss erfolgen
		canvas.clearCanvas();
		canvas.rotateAllShapes(300, 230, 100);
	}
	
	@Test 
	public void testRotateSingleShape() {
		canvas.rotateSingleShape(-201, -25, 375, 1);
		
		assertEquals(5.61, cylinder.getPointX(), 0.001);
		assertEquals(-2.138, cylinder.getPointY(), 0.001);
		assertEquals(1.395, cylinder.getPointZ(), 0.001);
		
		// Konsolenausgabe muss erfolgen
		canvas.rotateSingleShape(4, 112, 45, 4);
	}
	
	@Test 
	public void testScaleAllShapes() {
		canvas.scaleAllShapes(3, 1, 2);
		
		assertEquals(15, cylinder.getPointX(), 0.001);
		assertEquals(3, cylinder.getPointY(), 0.001);
		assertEquals(4, cylinder.getPointZ(), 0.001);
		
		assertEquals(15, cone.getPointX(), 0.001);
		assertEquals(8, cone.getPointY(), 0.001);
		assertEquals(6, cone.getPointZ(), 0.001);
		
		assertEquals(12, cuboid.getPointX(), 0.001);
		assertEquals(7, cuboid.getPointY(), 0.001);
		assertEquals(18, cuboid.getPointZ(), 0.001);
		
		// Konsolenausgabe muss erfolgen
		canvas.clearCanvas();
		canvas.scaleAllShapes(3, 2, 1);
	}

	@Test 
	public void testScaleSingleShape() {
		canvas.scaleSingleShape(5, 9, 1, 2);
		
		assertEquals(25, cone.getPointX(), 0.001);
		assertEquals(72, cone.getPointY(), 0.001);
		assertEquals(3, cone.getPointZ(), 0.001);
		
		// Konsolenausgabe muss erfolgen
		canvas.scaleSingleShape(5, -3, 2, -1);
	}
	
	@Test
	public void testTranslateAllShapes() {
		canvas.translateAllShapes(5, -9, 2);
		
		assertEquals(10, cylinder.getPointX(), 0.001);
		assertEquals(-6, cylinder.getPointY(), 0.001);
		assertEquals(4, cylinder.getPointZ(), 0.001);
		
		assertEquals(10, cone.getPointX(), 0.001);
		assertEquals(-1, cone.getPointY(), 0.001);
		assertEquals(5, cone.getPointZ(), 0.001);
		
		assertEquals(9, cuboid.getPointX(), 0.001);
		assertEquals(-2, cuboid.getPointY(), 0.001);
		assertEquals(11, cuboid.getPointZ(), 0.001);
		
		// Konsolenausgabe muss erfolgen
		canvas.clearCanvas();
		canvas.translateAllShapes(3, 2, 1);
	}
	
	@Test
	public void testTranslateSingleShape() {
		canvas.translateSingleShape(2, 4, 7, 3);
		
		assertEquals(6, cuboid.getPointX(), 0.001);
		assertEquals(11, cuboid.getPointY(), 0.001);
		assertEquals(16, cuboid.getPointZ(), 0.001);
		
		// Konsolenausgabe muss erfolgen
		canvas.translateSingleShape(4, 2, 0, 7);
	}
	
	@Test
	public void testCalcTotalVolume() {
		assertEquals(1222.389, canvas.calcTotalVolume(), 0.001);
	}
	
	@Test 
	public void testCalcVolumeSingleShape() {
		assertEquals(60.0, canvas.calcVolumeSingleShape(3), 0.001);
	}
}
