package model;

import java.io.Serializable;
import java.util.List;
import dao.ProfessorEfetivoDAO;

public class ProfessorEfetivo extends Professor implements Serializable {
	private static final long serialVersionUID = -8181299970844935165L;
	private double salario;
	
	//construtores
	public ProfessorEfetivo() {}
	public ProfessorEfetivo(String nome, long matricula, double salario) {
		super(nome, matricula);
		this.salario = salario;
	}
	
	//getters e setters
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	//toString
	@Override
	public String toString() {
		return "ProfessorEfetivo [" + super.toString() + "salario = " + salario + "]";
	}

	// Métodos
	public boolean create() {
		return ProfessorEfetivoDAO.create(this);
	}

	public List<ProfessorEfetivo> listAll() {
		return ProfessorEfetivoDAO.listAll();
	}

	public boolean update() {
		return ProfessorEfetivoDAO.update(this);
	}

	public boolean delete() {
		return ProfessorEfetivoDAO.delete(this);
	}
}
