package hensel.hausarbeit_visitor;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * JUnit 5 Testklasse CuboidTest
 *
 */

public class CuboidTest {

	Cuboid cuboid = new Cuboid(3, 4, 5, 7.5, 3.5, -1.2);
	
	RotateVisitor rotate = new RotateVisitor(20, 30, 40);
	TranslateVisitor translate = new TranslateVisitor(2, 5, -3);
	ScaleVisitor scale = new ScaleVisitor(-3, 4, 7);
	CalcVolumeVisitor calcVolume = new CalcVolumeVisitor();
	
	@Test
	public void testCalcDiagonal() {
		assertEquals(8.36301381, cuboid.calcDiagonal(), 0.00000001);
	}
	
	@Test 
	public void testAccept() {
		cuboid.accept(rotate);
		cuboid.accept(translate);
		cuboid.accept(scale);
		cuboid.accept(calcVolume);
		
		assertEquals(2.99700333, rotate.getRotate()[0], 0.00000001);
		assertEquals(5.18913284, rotate.getRotate()[1], 0.00000001);
		assertEquals(3.75378093, rotate.getRotate()[2], 0.00000001);
		
		assertEquals(5, translate.getTranslate()[0], 0.00000001);
		assertEquals(9, translate.getTranslate()[1], 0.00000001);
		assertEquals(2, translate.getTranslate()[2], 0.00000001);
		
		assertEquals(-9, scale.getScale()[0], 0.00000001);
		assertEquals(16, scale.getScale()[1], 0.00000001);
		assertEquals(35, scale.getScale()[2], 0.00000001);
		
		assertEquals(30, cuboid.getHeight(), 0.00000001);
		assertEquals(10.5, cuboid.getWidth(), 0.00000001);
		assertEquals(8.4, cuboid.getDepth(), 0.00000001);
		
		// Neue Höhe: 30, neue Breite: 10.5 und neue Tiefe: 8.4
		assertEquals(2646, calcVolume.getCalcVolume(), 0.00000001);
	}
}
