package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.ProfessorEfetivo;

@ManagedBean
@SessionScoped
public class ProfessorEfetivoBean implements Serializable {
	private static final long serialVersionUID = 1424062305625773522L;
	private ProfessorEfetivo professorefetivo = new ProfessorEfetivo();
    private List<ProfessorEfetivo> lista;

	public ProfessorEfetivo getProfessorefetivo() {
		return professorefetivo;
	}

	public void setProfessorefetivo(ProfessorEfetivo professorefetivo) {
		this.professorefetivo = professorefetivo;
	}
	
    public String cadastra() {
    	FacesContext context = FacesContext.getCurrentInstance();
        boolean retorno = professorefetivo.create();
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
        return "cadastrar_efetivo";
    }

    public String editar(ProfessorEfetivo professorefetivo){
        this.professorefetivo = professorefetivo;
        return "editar_efetivo";
    }

    public String atualizar(ProfessorEfetivo professorefetivo){
    	FacesContext context = FacesContext.getCurrentInstance();
    	boolean retorno = professorefetivo.update();
    	if(!retorno) {
        	String msg = "Erro ao atualizar dados do professor";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage(null, mensagem);
        }
        else
            lista = professorefetivo.listAll();
        return "listar_efetivo";
    }

    public String excluir(ProfessorEfetivo professorefetivo){
    	FacesContext context = FacesContext.getCurrentInstance();
        boolean retorno = professorefetivo.delete();
        if(!retorno) {
        	String msg = "Erro ao excluir professor";
        	FacesMessage mensagem = new FacesMessage(msg);
        	mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        	context.addMessage(null, mensagem);
        }
        else
        	lista = professorefetivo.listAll();
        return "listar_efetivo";
    }

    public List<ProfessorEfetivo> getLista() {
    	if(lista == null)
           lista = professorefetivo.listAll();
        return lista;
    }

    public void limpa() {
        this.professorefetivo = new ProfessorEfetivo();
        professorefetivo.setNome(null);
        professorefetivo.setMatricula(0);
        professorefetivo.setSalario(0);
     }

    
}
