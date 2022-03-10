package models;

public class Habilidade implements Comparable<Habilidade>{

	private Integer turno;
	private String nome;
	
	public Habilidade(String nome, int turno) {
		this.nome = nome;
		this.turno = turno;
	}
	public int getTurno() {
		return turno;
	}
	public String getNome() {
		return nome;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	@Override
	public int compareTo(Habilidade other) {
		return turno.compareTo(other.getTurno());
	}
}
