package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassesDoJogo {

	private List<Habilidade> habilidades = new ArrayList<Habilidade>();
	private List<Habilidade> habilidadesEmUso = new ArrayList<Habilidade>();
	
	public List<Habilidade> getHabilidades(){
		return habilidades;
	}
	public List<Habilidade> getHabilidadesEmUso(){
		ordenarListaHabilidadesEmUso();
		return habilidadesEmUso;
	}
	
	public void adicionarHabilidade(String nome, int turno) {
		habilidades.add(new Habilidade(nome,turno));
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
	public void utilizarHabilidade(String nome, int turno) {
		habilidadesEmUso.add(new Habilidade(nome, turno));
		ordenarListaHabilidadesEmUso();
	}
	
	private List<Habilidade> ordenarListaHabilidadesEmUso() {
		Comparator<Habilidade> comp = (s1, s2) -> s1.compareTo(s2);
		habilidadesEmUso = habilidadesEmUso.stream().sorted(comp).collect(Collectors.toList());
		return habilidadesEmUso;
	}
}
