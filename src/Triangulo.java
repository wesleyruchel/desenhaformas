
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class Triangulo extends Drawable {

	@Override
	public void toDraw(Graphics2D g2d, Color color) {
		g2d.setColor(color);

		Point p2 = new Point(getPointerPosX() + 100, getPointerPosY());
		Point p3 = new Point(getPointerPosX() + 100 / 2, getPointerPosY() - 100);

		Polygon p = new Polygon();
		p.addPoint(p2.x, p2.y);
		p.addPoint(p3.x, p3.y);
		p.addPoint(getPointerPosX(), getPointerPosY());

		g2d.fillPolygon(p);
	}
}
