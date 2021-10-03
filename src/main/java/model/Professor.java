package model;

public class Professor {
	private String nome;
	private long matricula;

	//construtores
	public Professor() {};
	public Professor(String nome, long matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	//toString
	@Override
	public String toString() {
		return "Professor [nome = " + nome + ", matrícula = " + matricula + "]";
	}
		
}
