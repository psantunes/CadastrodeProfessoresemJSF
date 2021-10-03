package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
	private static final long serialVersionUID = -1680981539097542373L;
	private Usuario usuario = new Usuario();

    public UsuarioBean() {
        this.usuario = new Usuario();
     }
 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public String validar() {
        if(usuario.validar()){
        	return "menu";
        }
        else {
        	FacesContext context = FacesContext.getCurrentInstance();
        	String msg = "Usuário ou senha inválidos. Tente novamente!";
            FacesMessage mensagem = new FacesMessage(msg);
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
           	context.addMessage(null, mensagem);
            return "index";
        }
    }
}
