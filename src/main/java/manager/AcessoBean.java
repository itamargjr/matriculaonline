package manager;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entity.Edu_matr_candidato;
import persistence.Dao;
import persistence.Edu_matr_candidatoDao;

/**
 * Bean de controle de acesso.
 * Todas as fun��es relativas
 * ao acesso do sistema
 * 
 * @author itamar 
 *
 */

@ManagedBean
@SessionScoped
public class AcessoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8268179366139876532L;

	public Edu_matr_candidato candidato; 
	
	/* Fun��o que mostra em qual banco a aplica��o est� conectada e retorna a String */
	public String banco(){
		
		String cam;
		Dao db = new Dao();
		
		cam = db.caminho(); 

		return cam.substring(cam.length()-18, cam.length());
	}
	
	/* Fun��o que mostra o usu�rio logado */
	public String usuariologado(){
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); 
		
		if (session.getAttribute("loginusulogado")==null) {
			return "";
		} else {
			return session.getAttribute("loginusulogado").toString();
		}		
	}
	
	public AcessoBean() {
		candidato = new Edu_matr_candidato();
	}
	
	public Edu_matr_candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Edu_matr_candidato candidato) {
		this.candidato = candidato;
	}

	/**
	 * Fun��o de acesso ao sistema.
	 * recebe login e senha do 
	 * usu�rio e critica a 
	 * exist�ncia
	 * 
	 */

	public String login(){
		
		Edu_matr_candidatoDao cd = new Edu_matr_candidatoDao();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		try {
			Edu_matr_candidato candidatologado = cd.login(candidato);
			
			if (candidatologado.getNome_candidato()==null) {						
				FacesMessage msg = new FacesMessage("Candidato n�o encontrado", "Candidato inexistente, ou dados inv�lidos!");
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
				session.setAttribute("idusulogado", 0);
				
				return null;
			}else {
				
				candidato = new Edu_matr_candidato();
				
				FacesMessage msg = new FacesMessage("Bem vindo", candidatologado.getNome_candidato());
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
							
				session.setAttribute("nomecandidatologado", candidatologado.getNome_candidato());
				session.setAttribute("idcandidatologado", candidatologado.getId_candidato());
				
				return "principal.xhtml?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();

			FacesMessage msg = new FacesMessage("Erro ao efetuar login",e.getMessage());
				
			FacesContext.getCurrentInstance().addMessage(null, msg);			
					
			session.setAttribute("idusulogado", 0);
			
			return null;
		}		
	}
	
	/**
	 * Fun��o de sa�da do sistema
	 * que limpa os dados da sess�o
	 * e redireciona o usu�rio para a 
	 * tela de login
	 * 
	 */

	public String logout(){
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		session.setAttribute("idcandidatologado", 0);
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "principal.xhtml?faces-redirect=true";		
	}
	
	/**
	 * Fun��o para confirmar se
	 * existe algum usu�rio logado
	 * 
	 * A l�gica �: se o atributo
	 * login_usu da classe acessousuarios
	 * n�o est� nulo, ent�o ele est�
	 * logado 
	 * 
	 */
	
	public boolean isLogado(){
		//return usuarios.getLogin_usu() != null;
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Integer candlog = (Integer) session.getAttribute("idcandidatologado");

		return candlog !=null;
	}
	
}
