
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class DrawShapesFrame extends JFrame {
	private Container container;
	private DrawPanel drawPanel;

	public void buildFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Desenha Formas");
		setSize(800, 600);
		setResizable(false);

		container = getContentPane();
		drawPanel = new DrawPanel();
		drawPanel.setup();
		container.add(drawPanel, BorderLayout.CENTER);

		JPanel menuPanel = new JPanel(new GridBagLayout());
		menuPanel.setBorder(BorderFactory.createTitledBorder("Opções"));
		container.add(menuPanel, BorderLayout.WEST);
		buildMenu(menuPanel);
	}

	private void buildMenu(JPanel menuPanel) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;

		JList<String> shapesList;
		DefaultListModel<String> listShapesModel = new DefaultListModel<>();
		listShapesModel.addElement("Circulo");
		listShapesModel.addElement("Quadrado");
		listShapesModel.addElement("Retangulo");
		listShapesModel.addElement("Triangulo");

		shapesList = new JList<>(listShapesModel);
		shapesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		gbc.gridy = 1;
		menuPanel.add(new JLabel("Forma"), gbc);

		gbc.gridy = 2;
		menuPanel.add(shapesList, gbc);

		drawPanel.setShapeSelected("Circulo");
		MouseAdapter shapeClick = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				drawPanel.setShapeSelected(listShapesModel.getElementAt(shapesList.getSelectedIndex()));
			}
		};

		shapesList.addMouseListener(shapeClick);

		/*--------------------------------------------------------------------------------------------------*/

		JList<String> colorsList;
		DefaultListModel<String> listColorsModel = new DefaultListModel<>();
		listColorsModel.addElement("Amarelo");
		listColorsModel.addElement("Azul");
		listColorsModel.addElement("Preto");
		listColorsModel.addElement("Verde");
		listColorsModel.addElement("Vermelho");

		colorsList = new JList<>(listColorsModel);
		colorsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		gbc.gridy = 3;
		menuPanel.add(new JLabel("Cor"), gbc);

		gbc.gridy = 4;
		menuPanel.add(colorsList, gbc);

		drawPanel.setColorSelected("Preto");
		MouseAdapter colorClick = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				drawPanel.setColorSelected(listColorsModel.getElementAt(colorsList.getSelectedIndex()));
			}
		};

		colorsList.addMouseListener(colorClick);
	}
}
