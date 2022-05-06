package hensel.hausarbeit_visitor;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * JUnit 5 Testklasse ConeTest
 *
 */

public class ConeTest {

	Cone cone = new Cone(-2, 5, -4, -2.54, 3.76);
	
	RotateVisitor rotate = new RotateVisitor(10, 25, 359);
	TranslateVisitor translate = new TranslateVisitor(-2, 5, -3);
	ScaleVisitor scale = new ScaleVisitor(3, 4, -7);
	CalcVolumeVisitor calcVolume = new CalcVolumeVisitor();
	
	@Test
	public void testCalcSideSlope() {
		assertEquals(4.53753236, cone.calcSideSlope(), 0.00000001);
	}
	
	@Test
	public void testAcceptCone() {
		cone.accept(rotate);
		cone.accept(translate);
		cone.accept(scale);
		cone.accept(calcVolume);
		
		assertEquals(-3.0119397, rotate.getRotate()[0], 0.00000001);
		assertEquals(5.67206095, rotate.getRotate()[1], 0.00000001);
		assertEquals(-1.93802573, rotate.getRotate()[2], 0.00000001);
		
		assertEquals(-4, translate.getTranslate()[0], 0.00000001);
		assertEquals(10, translate.getTranslate()[1], 0.00000001);
		assertEquals(-7, translate.getTranslate()[2], 0.00000001);
		
		assertEquals(-6, scale.getScale()[0], 0.00000001);
		assertEquals(20, scale.getScale()[1], 0.00000001);
		assertEquals(28, scale.getScale()[2], 0.00000001);
		
		assertEquals(12.7, cone.getRadius(), 0.00000001);
		assertEquals(15.04, cone.getHeight(), 0.00000001);
		
		// Neuer Radius: 12.7 und neue Höhe: 15.04
		assertEquals(2540.2934952, calcVolume.getCalcVolume(), 0.00000001);
	}
}
