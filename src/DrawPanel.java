
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private String shapeSelected;
	private String colorSelected;
	private Graphics2D g2d;

	MouseAdapter adapter = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);

			g2d = (Graphics2D) getGraphics();
			Drawable drawable = null;

			switch (shapeSelected) {
			case "Circulo":
				drawable = new Circulo();
				break;
			case "Quadrado":
				drawable = new Quadrado();
				break;
			case "Retangulo":
				drawable = new Retangulo();
				break;
			case "Triangulo":
				drawable = new Triangulo();
				break;
			}

			drawable.setPoiterPosX(e.getX());
			drawable.setPointerPosY(e.getY());
			drawable.toDraw(g2d, translateColor(getColorSelected()));
		}

	};

	public void setShapeSelected(String shape) {
		this.shapeSelected = shape;
	}

	public void setColorSelected(String color) {
		this.colorSelected = color;
	}

	public String getShapeSelected() {
		return this.shapeSelected;
	}

	public String getColorSelected() {
		return this.colorSelected;
	}

	public Color translateColor(String color) {

		switch (colorSelected) {
		case "Amarelo":
			return Color.YELLOW;
		case "Azul":
			return Color.BLUE;
		case "Verde":
			return Color.GREEN;
		case "Vermelho":
			return Color.RED;
		default:
			return Color.BLACK;
		}
	}

	public void setup() {
		setBackground(Color.WHITE);
		addMouseListener(adapter);
	}
}
