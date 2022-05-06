package hensel.hausarbeit_visitor;

import java.util.ArrayList;

/**
 * 
 * @author Fabian Hensel
 * @since 02.03.2021
 * Klasse Canvas: Die Zeichenfläche für alle 3D-Formen
 *
 */

public class Canvas {

	private ArrayList<Shape3D> shapes;
	// Zur Angabe der Nachkommastellen
	private String decimalPlace;
	
	public Canvas() {
		shapes = new ArrayList<Shape3D>();
		// Als Standard sind zwei Nachkommastellen gegeben
		decimalPlace = "1" + new String(new char[2]).replace("\0", "0");
	}
	
	/**
	 * @param shape : Ein Objekt vom Typ Shape3D
	 */
	// Fügt eine Form in das Array shapes ein
	public void addShape(Shape3D shape) {
		shapes.add(shape);
	}
	
	// Entfernt alle Formen
	public void clearCanvas() {
		shapes.clear();
	}
	
	/**
	 * @param shape : Ein Objekt vom Typ Shape3D
	 */
	// Entfernt eine Form nach Wahl
	public void removeSingleShape(Shape3D shape) {
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) == shape) 
				shapes.remove(i);
		}
	}
	/**
	 * @param decimalPlace : Die genaue Nachkommastelle
	 */
	// Eingabe der Nachkommastellen für die Werteausgabe, maximal acht und mindestens zwei
	public void setDecimalPlace(int decimalPlace) {
		if (decimalPlace > 1 && decimalPlace < 9) {
			this.decimalPlace = "1" + new String(new char[decimalPlace]).replace("\0", "0");
		}
		else {
			System.out.println("Keine zulässige Angabe. Es wird die Standardausgabe verwendet.\n\n");
		}	
	}
	
	/**
	 * @param xAngle : Der x-Winkel für die Rotation
	 * @param yAngle : Der y-Winkel für die Rotation
	 * @param zAngle : Der z-Winkel für die Rotation
	 */
	// Rotiert alle gegebenen Formen 
	public void rotateAllShapes(int xAngle, int yAngle, int zAngle) {
		if (shapes.isEmpty()) {
			System.out.println("Keine Formen zum rotieren gegeben.");
		}
		else {
			RotateVisitor rotate = new RotateVisitor(xAngle, yAngle, zAngle);
			System.out.println("Alle Formen wurden um die Achse x mit " + xAngle + "° ,y mit " + yAngle + "° und z mit " + zAngle + "° gedreht.\n");
			int count = 0;
			for (Shape3D shape : shapes) {
				count++;
				shape.accept(rotate);
				shape.setPointX(rotate.getRotate()[0]);
				shape.setPointY(rotate.getRotate()[1]);
				shape.setPointZ(rotate.getRotate()[2]);
				System.out.println(newPositionsTextShapes(count, shape));
			}
		}
		System.out.println("\n\n");
	}
	
	/**
	 * @param xAngle : Der x-Winkel für die Rotation
	 * @param yAngle : Der y-Winkel für die Rotation
	 * @param zAngle : Der z-Winkel für die Rotation
	 * @param index : Die genaue Position der gewünschten Form, beginnt ab 1
	 */
	// Rotiert eine Form nach Wahl
	public void rotateSingleShape(int xAngle, int yAngle, int zAngle, int index) {
		RotateVisitor rotate = new RotateVisitor(xAngle, yAngle, zAngle);
		try {
			shapes.get(index-1).accept(rotate);
			shapes.get(index-1).setPointX(rotate.getRotate()[0]);
			shapes.get(index-1).setPointY(rotate.getRotate()[1]);
			shapes.get(index-1).setPointZ(rotate.getRotate()[2]);
			System.out.println("Die gewählte Form wurde um die Achse x mit " + xAngle + "° ,y mit " + yAngle + "° und z mit " + zAngle + "° gedreht.\n");
			System.out.println(newPositionTextSingleShape(index));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Keine Form " + index + " zum rotieren gegeben.\n\n");
		}
	}
	
	/**
	 * @param sx : Skaliert in x-Richtung
	 * @param sy : Skaliert in y-Richtung
	 * @param sz : Skaliert in z-Richtung
	 */
	// Skaliert alle gegebenen Formen
	public void scaleAllShapes(int sx, int sy, int sz) {
		if (shapes.isEmpty()) {
			System.out.println("Keine Formen zum skalieren gegeben.");
		}
		else {
			ScaleVisitor scale = new ScaleVisitor(sx, sy, sz);
			System.out.println("Alle Formen wurden um die Faktoren sx=" + sx + ", sy=" + sy + " und sz=" + sz + " skaliert.\n");
			int count = 0;
			for (Shape3D shape : shapes) {
				count++;
				shape.accept(scale);
				shape.setPointX(scale.getScale()[0]);
				shape.setPointY(scale.getScale()[1]);
				shape.setPointZ(scale.getScale()[2]);
				System.out.println(newPositionsTextShapes(count, shape));
			}
		}
		System.out.println("\n\n");
	}
	
	/**
	 * @param sx : Skaliert in x-Richtung
	 * @param sy : Skaliert in y-Richtung
	 * @param sz : Skaliert in z-Richtung
	 * @param index : Die genaue Position der gewünschten Form, beginnt ab 1
	 */
	// Skaliert eine Form nach Wahl
	public void scaleSingleShape(int sx, int sy, int sz, int index) {
		ScaleVisitor scale = new ScaleVisitor(sx, sy, sz);
		try {
			shapes.get(index-1).accept(scale);
			shapes.get(index-1).setPointX(scale.getScale()[0]);
			shapes.get(index-1).setPointY(scale.getScale()[1]);
			shapes.get(index-1).setPointZ(scale.getScale()[2]);
			System.out.println("Die gewählte Form wurde um den Faktor sx=" + sx + ", sy=" + sy + " und sz=" + sz + " skaliert.\n");
			System.out.println(newPositionTextSingleShape(index));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Keine Form " + index + " zum skalieren gegeben.\n\n");
		}
	}
	
	/**
	 * @param tx : Translatiert in x-Richtung
	 * @param ty : Translatiert in y-Richtung
	 * @param tz : Translatiert in z-Richtung
	 */
	// Translatiert alle gegebenen Formen
	public void translateAllShapes(int tx, int ty, int tz) {
		if (shapes.isEmpty()) {
			System.out.println("Keine Formen zum translatieren gegeben.");
		}
		else {
			TranslateVisitor translate = new TranslateVisitor(tx, ty, tz);
			System.out.println("Alle Formen wurden um die Faktoren tx=" + tx + ", ty=" + ty + " und tz=" + tz + " translatiert.\n");
			int count = 0;
			for (Shape3D shape : shapes) {
				count++;
				shape.accept(translate);
				shape.setPointX(translate.getTranslate()[0]);
				shape.setPointY(translate.getTranslate()[1]);
				shape.setPointZ(translate.getTranslate()[2]);
				System.out.println(newPositionsTextShapes(count, shape));
			}
		}
		System.out.println("\n\n");
	}
	
	/**
	 * @param tx : Translatiert in x-Richtung
	 * @param ty : Translatiert in y-Richtung
	 * @param tz : Translatiert in z-Richtung
	 * @param index : Die genaue Position der gewünschten Form, beginnt ab 1
	 */
	// Translatiert eine Form nach Wahl
	public void translateSingleShape(int tx, int ty, int tz, int index) {
		TranslateVisitor translate = new TranslateVisitor(tx, ty, tz);
		try {
			shapes.get(index-1).accept(translate);
			shapes.get(index-1).setPointX(translate.getTranslate()[0]);
			shapes.get(index-1).setPointY(translate.getTranslate()[1]);
			shapes.get(index-1).setPointZ(translate.getTranslate()[2]);
			System.out.println("Die gewählte Form wurde um den Faktor tx=" + tx + ", ty=" + ty + " und tz=" + tz + " transliert.\n");
			System.out.println(newPositionTextSingleShape(index));
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Keine Form " + index + " zum translatieren gegeben.\n\n");
		}
	}
	
	/**
	 * @return Das Gesamtvolumen aller Formen
	 */
	// Berechnet das Gesamtvolumen aller Formen
	public double calcTotalVolume() {
		CalcVolumeVisitor calcVolume = new CalcVolumeVisitor();
		double totalVolume = 0;
		for (Shape3D shape : shapes) {
			shape.accept(calcVolume);
			totalVolume += calcVolume.getCalcVolume();
		}
		return Math.round(Double.parseDouble(decimalPlace) * totalVolume) / Double.parseDouble(decimalPlace);
	}
	
	/**
	 * @param index : Die genaue Position der gewünschten Form, beginnt ab 1
	 * @return Das jeweilige Volumen oder bei nicht-vorhandenem Index == 0
	 */
	// Berechnet das Volumen einer Form nach Wahl
	public double calcVolumeSingleShape(int index) {
		CalcVolumeVisitor calcVolume = new CalcVolumeVisitor();
		try {
			shapes.get(index-1).accept(calcVolume);
			return Math.round(Double.parseDouble(decimalPlace) * calcVolume.getCalcVolume()) / Double.parseDouble(decimalPlace);
		}
		catch (IndexOutOfBoundsException e){
			return 0;
		}
	}
	
	// Hilfsmethode zur Textausgabe
	private String newPositionTextSingleShape(int index) {
		return "Neue Position Form " + index + " (" +  shapes.get(index-1).toString() + 
				"): x=" + Math.round(Double.parseDouble(decimalPlace) * shapes.get(index-1).getPointX()) / Double.parseDouble(decimalPlace) + 
				" | y=" + Math.round(Double.parseDouble(decimalPlace) * shapes.get(index-1).getPointY()) / Double.parseDouble(decimalPlace) + 
			    " | z=" + Math.round(Double.parseDouble(decimalPlace) * shapes.get(index-1).getPointZ()) / Double.parseDouble(decimalPlace) + "\n\n";
	}
	
	// Hilfsmethode zur Textausgabe
	private String newPositionsTextShapes(int count, Shape3D shape) {
		return "Neue Position Form " + count + " (" + shape.toString() + 
				"): x=" + Math.round(Double.parseDouble(decimalPlace) * shape.getPointX()) / Double.parseDouble(decimalPlace) + 
				" | y=" + Math.round(Double.parseDouble(decimalPlace) * shape.getPointY()) / Double.parseDouble(decimalPlace) + 
				" | z=" + Math.round(Double.parseDouble(decimalPlace) * shape.getPointZ()) / Double.parseDouble(decimalPlace);
	}
	
	public ArrayList<Shape3D> getShapes() {
		return shapes;
	}
}
