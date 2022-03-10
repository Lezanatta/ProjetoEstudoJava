package models;

public class Viking extends ClassesDoJogo{
	
	public Viking() {
		criarHabilidadesViking();
	}
	
	public void criarHabilidadesViking() {
		adicionarHabilidade("habilidade01",20);
		adicionarHabilidade("habilidade02",22);
		adicionarHabilidade("habilidade03",19);
		adicionarHabilidade("habilidade04",15);
	}
}
