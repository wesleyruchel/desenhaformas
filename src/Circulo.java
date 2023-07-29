
import java.awt.Color;
import java.awt.Graphics2D;

public class Circulo extends Drawable {

	@Override
	public void toDraw(Graphics2D g2d, Color color) {
		g2d.setColor(color);
		g2d.fillOval(getPointerPosX() - 50, getPointerPosY() - 50, 100, 100);
	}
}
