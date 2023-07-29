
import java.awt.Color;
import java.awt.Graphics2D;

public class Retangulo extends Drawable {

	@Override
	public void toDraw(Graphics2D g2d, Color color) {
		g2d.setColor(color);
		g2d.fillRect(getPointerPosX() - 100, getPointerPosY() - 50, 200, 100);
	}
}
