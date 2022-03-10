package Services;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Main.FrameClass;
import Main.PanelClass;
import models.Viking;

public class ComponentesServices implements ActionListener {
	private final static int vazio = 0;
	private PanelClass panel;
	private Label lblHabilidade, lblTurno;
	Viking viking = new Viking();
	private Button btnClasse, btnPassarTurno;

	private List<Button> listBtnHabilidadesViking = new ArrayList<Button>();
	private List<Label> listLblHabilidades = new ArrayList<Label>();
	private List<Label> listLblTurnos = new ArrayList<Label>();

	public ComponentesServices(PanelClass panel) {
		this.panel = panel;
		this.panel.setLayout(null);
		AdicionarTelaInicial(panel);
	}

	public void AdicionarTelaInicial(PanelClass panel) {
		panel.removeAll();

		lblHabilidade = new Label("Habilidade");
		lblHabilidade.setBounds(100, 20, 80, 20);
		lblHabilidade.setForeground(Color.GREEN);
		this.panel.add(lblHabilidade);

		lblTurno = new Label("Turno");
		lblTurno.setBounds(250, 20, 80, 20);
		lblTurno.setForeground(Color.GREEN);
		this.panel.add(lblTurno);

		btnClasse = new Button("Classe");
		btnClasse.setBounds(500, 150, 90, 30);
		btnClasse.setBackground(Color.BLACK);
		btnClasse.setForeground(Color.WHITE);
		btnClasse.addActionListener(this);
		this.panel.add(btnClasse);

		btnPassarTurno = new Button("Passar Turno");
		btnPassarTurno.setBounds(500, 350, 90, 30);
		btnPassarTurno.setBackground(Color.BLACK);
		btnPassarTurno.setForeground(Color.WHITE);
		btnPassarTurno.addActionListener(this);
		this.panel.add(btnPassarTurno);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Classe")
			CriarFrameHabilidades();

		if (listBtnHabilidadesViking.size() != vazio)
			verificarHabilidades(event);

		if (event.getActionCommand() == "Passar Turno")
			verificarPassoTurno();
	}

	private void verificarPassoTurno() {
		if (viking.getHabilidadesEmUso().size() != vazio) {
			viking.getHabilidadesEmUso().forEach(x -> x.setTurno(x.getTurno() - 1));
			viking.getHabilidadesEmUso().removeIf(x -> x.getTurno() <= 0);
			AdicionarTelaInicial(panel);
			panel.adicionarTurnosPanel(getListTurno(), listLblTurnos);
			panel.adicionarHabilidadesPanel(getListHabilidades(), listLblHabilidades);
		}
	}

	private void verificarHabilidades(ActionEvent event) {
		for (int i = 0; i < listBtnHabilidadesViking.size(); i++) {
			if (event.getActionCommand() == listBtnHabilidadesViking.get(i).getActionCommand()) {
				viking.utilizarHabilidade(viking.getHabilidades().get(i).getNome(),
						viking.getHabilidades().get(i).getTurno());
				AdicionarTelaInicial(panel);
				panel.adicionarTurnosPanel(getListTurno(), listLblTurnos);
				panel.adicionarHabilidadesPanel(getListHabilidades(), listLblHabilidades);
			}
		}
	}

	public void CriarFrameHabilidades() {
		PanelClass pc = new PanelClass();
		pc.setSize(350, 200);
		new FrameClass("Habilidades", pc).setVisible(true);
		adicionarHabilidadeBtn(pc);
	}

	private List<String> getListHabilidades() {
		return viking.getHabilidadesEmUso().stream().map(x -> x.getNome()).collect(Collectors.toList());
	}

	private List<Integer> getListTurno() {
		return viking.getHabilidadesEmUso().stream().map(x -> x.getTurno()).collect(Collectors.toList());
	}

	public void adicionarHabilidadeBtn(PanelClass panel) {
		listBtnHabilidadesViking.clear();
		for (int i = 0; i < viking.getHabilidades().size(); i++) {
			listBtnHabilidadesViking.add(new Button(viking.getHabilidades().get(i).getNome()));
			listBtnHabilidadesViking.get(i).addActionListener(this);
			panel.add(listBtnHabilidadesViking.get(i));
		}
	}

	public PanelClass getPanel() {
		return panel;
	}
}
