package br.com.caelum.vraptor.blank;

public class Aluno {

	private int matricula;
	
	private String nome;
	
	private Sexo sexo;
	
	public Aluno() {}
	
	public Aluno(int matricula, String nome, Sexo sexo) {
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
}
