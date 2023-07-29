
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Drawable {
	private Integer poiterPosX, pointerPosY;

	public abstract void toDraw(Graphics2D g2d, Color color);
	
	public Integer getPointerPosX() {
		return poiterPosX;
	}

	public void setPoiterPosX(Integer poiterPosX) {
		this.poiterPosX = poiterPosX;
	}

	public Integer getPointerPosY() {
		return pointerPosY;
	}

	public void setPointerPosY(Integer pointerPosY) {
		this.pointerPosY = pointerPosY;
	}
	
}
