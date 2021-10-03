package model;

import java.io.Serializable;
import java.util.List;

import dao.ProfessorHoristaDAO;

public class ProfessorHorista extends Professor  implements Serializable {
		private static final long serialVersionUID = 4321531690818426210L;
		private int totalHoras;
		private double valorHora;
		
		//construtores
		public ProfessorHorista() {}
		public ProfessorHorista(String nome, long matricula, int totalHoras, double valorHora) {
			super(nome, matricula);
			this.totalHoras = totalHoras;
			this.valorHora = valorHora;
		}

		//getters e setters
		public int getTotalHoras() {
			return totalHoras;
		}
		public void setTotalHoras(int totalHoras) {
			this.totalHoras = totalHoras;
		}
		public double getValorHora() {
			return valorHora;
		}
		public void setValorHora(double valorHora) {
			this.valorHora = valorHora;
		}
		
		//toString
		@Override
		public String toString() {
			return "ProfessorEfetivo [" + super.toString() + "totalHoras = " + totalHoras + "; valorHora = " + valorHora + "]";
		}

		// Métodos
		public boolean create() {
			return new ProfessorHoristaDAO().create(this);
		}

		public List<ProfessorHorista> listAll() {
			return new ProfessorHoristaDAO().listAll();
		}

		public boolean update() {
			return new ProfessorHoristaDAO().update(this);
		}

		public boolean delete() {
			return new ProfessorHoristaDAO().delete(this);
		}


}
