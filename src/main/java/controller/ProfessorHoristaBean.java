package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.ProfessorHorista;

@ManagedBean
@SessionScoped
public class ProfessorHoristaBean implements Serializable {
	private static final long serialVersionUID = 5217272073334905064L;
	private ProfessorHorista professorhorista = new ProfessorHorista();
    private List<ProfessorHorista> lista;

	public ProfessorHorista getProfessorhorista() {
		return professorhorista;
	}

	public void setProfessorhorista(ProfessorHorista professorhorista) {
		this.professorhorista = professorhorista;
	}
	
    public String cadastra() {
    	FacesContext context = FacesContext.getCurrentInstance();
        boolean retorno = professorhorista.create();
        if(!retorno) {
        	String msg = "Erro ao cadastrar usuário";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage(null, mensagem);
        } else {
        	String msg = "Usuário cadastrado com sucesso";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        	context.addMessage(null, mensagem);
        	limpa();
        }
        return "cadastrar_horista";
    }

    public String editar(ProfessorHorista professorhorista){
        this.professorhorista = professorhorista;
        return "editar_horista";
    }

    public String atualizar(ProfessorHorista professorhorista){
    	FacesContext context = FacesContext.getCurrentInstance();
    	boolean retorno = professorhorista.update();
    	if(!retorno) {
        	String msg = "Erro ao atualizar dados do professor";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage(null, mensagem);
        }
        else
            lista = professorhorista.listAll();
        return "listar_horista";
    }

    public String excluir(ProfessorHorista professorhorista){
    	FacesContext context = FacesContext.getCurrentInstance();
        boolean retorno = professorhorista.delete();
        if(!retorno) {
        	String msg = "Erro ao excluir professor";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage(null, mensagem);
        }
        else
        	lista = professorhorista.listAll();
        return "listar_horista";
    }

    public List<ProfessorHorista> getLista() {
    	if(lista == null)
           lista = professorhorista.listAll();
        return lista;
    }

    public void limpa() {
        this.professorhorista = new ProfessorHorista();
        professorhorista.setNome(null);
        professorhorista.setMatricula(0);
        professorhorista.setTotalHoras(0);
        professorhorista.setValorHora(0);
     }

    
}
