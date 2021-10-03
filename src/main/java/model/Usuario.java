package model;

import java.io.Serializable;

import dao.UsuarioDAO;

public class Usuario implements Serializable {
	private static final long serialVersionUID = -2049786516866164937L;
	private String nome;
	private String senha;
	
	//construtores
	public Usuario() {};
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	//getters e setters	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	//função para validar login
    public boolean validar() {
        return UsuarioDAO.validar(this);
    }

	//toString
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", senha=" + senha + "]";
	}
}

