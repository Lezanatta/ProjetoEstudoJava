package Main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import Services.ComponentesServices;

public class FrameClass extends JFrame {
	private static final long serialVersionUID = 1L;

	public FrameClass(ComponentesServices comp, String titulo) {
		super(titulo);
		setLocation(400, 100);
		setSize(650, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(comp.getPanel());
	}
	
	public FrameClass(String titulo, PanelClass panel) {
		super(titulo);
		setLayout(new BorderLayout());
		setLocation(400, 100);
		setSize(350, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
	}
}
