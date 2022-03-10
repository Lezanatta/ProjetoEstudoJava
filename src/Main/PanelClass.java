package Main;

import java.awt.Color;
import java.awt.Label;
import java.util.List;

import javax.swing.JPanel;

public class PanelClass extends JPanel  {
	private static final long serialVersionUID = 1L;
	private static int ConstanteY = 20;
	
	public PanelClass() {
		setBackground(Color.DARK_GRAY);
	}
	
	public void adicionarTurnosPanel(List<Integer> turnos,List<Label> listLblTurnos) {
		listLblTurnos.clear();	
		for (int i = 0; i < turnos.size(); i++) {
			ConstanteY += 30;
			listLblTurnos.add(new Label(String.valueOf(turnos.get(i))));
			listLblTurnos.get(i).setBounds(250, ConstanteY, 80, 20);
			listLblTurnos.get(i).setForeground(Color.white);
			add(listLblTurnos.get(i));
		}
		ConstanteY = 20;
	}
	
	public void adicionarHabilidadesPanel(List<String> nomes, List<Label> listLblHabilidades) {
		listLblHabilidades.clear();
		for (int i = 0; i < nomes.size(); i++) {
			listLblHabilidades.add(new Label(nomes.get(i)));
			ConstanteY += 30;
			listLblHabilidades.get(i).setBounds(100, ConstanteY, 80, 20);
			listLblHabilidades.get(i).setForeground(Color.white);
			add(listLblHabilidades.get(i));
		}
		ConstanteY = 20;
	}
}
