package Main;

import Services.ComponentesServices;

public class Program {

	public static void main(String[] args) {
		new FrameClass(new ComponentesServices(new PanelClass()),"TESTANDO").setVisible(true);
	}
}
