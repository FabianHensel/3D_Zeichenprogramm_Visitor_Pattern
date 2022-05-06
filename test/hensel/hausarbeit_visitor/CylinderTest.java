package hensel.hausarbeit_visitor;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * JUnit Testklasse CylinderTest
 *
 */

public class CylinderTest {

	Cylinder cylinder = new Cylinder(4, 5, 6, 1.54, -3.54);
	
	RotateVisitor rotate = new RotateVisitor(5, 45, -205);
	TranslateVisitor translate = new TranslateVisitor(1, -19, 13);
	ScaleVisitor scale = new ScaleVisitor(7, 2, -15);
	CalcVolumeVisitor calcVolume = new CalcVolumeVisitor();
	
	@Test
	public void testCalcOuterSurface() {
		assertEquals(34.25341302, cylinder.calcOuterSurface(), 0.00000001);
	}
	
	@Test
	public void testAccept() {
		cylinder.accept(rotate);
		cylinder.accept(translate);
		cylinder.accept(scale);
		cylinder.accept(calcVolume);
		
		assertEquals(-8.55725218, rotate.getRotate()[0], 0.00000001);
		assertEquals(-0.9285896, rotate.getRotate()[1], 0.00000001);
		assertEquals(1.70621111, rotate.getRotate()[2], 0.00000001);
		
		assertEquals(5, translate.getTranslate()[0], 0.00000001);
		assertEquals(-14, translate.getTranslate()[1], 0.00000001);
		assertEquals(19, translate.getTranslate()[2], 0.00000001);
		
		assertEquals(28, scale.getScale()[0], 0.00000001);
		assertEquals(10, scale.getScale()[1], 0.00000001);
		assertEquals(-90, scale.getScale()[2], 0.00000001);
		
		assertEquals(16.94, cylinder.getRadius(), 0.00000001);
		assertEquals(7.08, cylinder.getHeight(), 0.00000001);
		
		// Neuer Radius: 16.94 und neue Höhe: 7.08
		assertEquals(6382.78098226, calcVolume.getCalcVolume(), 0.00000001);
	}

}
