package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import entity.Edu_func_escola;
import persistence.Edu_func_escolaDao;

@ManagedBean
@ViewScoped
public class Edu_func_escolaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8384038501073279652L;
	
	public Edu_func_escola edu_func_escola;
	
	public List<Edu_func_escola> edu_func_escolalista;
	
	public Boolean renderizarBotaocadastrar;
	public Boolean renderizarBotaoAtualizar;
	public Boolean renderizarBotaoExcluir;
	
	public Edu_func_escolaBean() {
		
		edu_func_escola = new Edu_func_escola();
		
		edu_func_escolalista = new ArrayList<Edu_func_escola>();
		
	}
	
	@PostConstruct
	public void init() {
		carregalistadasession();
		
		limpalistadasession();		
	}
	
	@SuppressWarnings("unchecked") // isso é necessário para o eclipse não colocar warning na atribuição abaixo porque não entende que o objeto retornado é realmente uma lista
	public void carregalistadasession() {					
		edu_func_escolalista = (List<Edu_func_escola>) new PaginasBean().GetPropriedadeSessionScope("edu_func_escolalista");
	}
	
	public void limpalistadasession() {					
		new PaginasBean().RemovePropriedadeSessionScope("escolalista");
	}

	public Edu_func_escola getEdu_func_escola() {
		return edu_func_escola;
	}

	public void setEdu_func_escola(Edu_func_escola edu_func_escola) {
		this.edu_func_escola = edu_func_escola;
	}

	public List<Edu_func_escola> getEdu_func_escolalista() {
		return edu_func_escolalista;
	}

	public void setEdu_func_escolalista(List<Edu_func_escola> edu_func_escolalista) {
		this.edu_func_escolalista = edu_func_escolalista;
	}

	public Boolean getRenderizarBotaocadastrar() {
		return renderizarBotaocadastrar;
	}

	public void setRenderizarBotaocadastrar(Boolean renderizarBotaocadastrar) {
		this.renderizarBotaocadastrar = renderizarBotaocadastrar;
	}

	public Boolean getRenderizarBotaoAtualizar() {
		return renderizarBotaoAtualizar;
	}

	public void setRenderizarBotaoAtualizar(Boolean renderizarBotaoAtualizar) {
		this.renderizarBotaoAtualizar = renderizarBotaoAtualizar;
	}

	public Boolean getRenderizarBotaoExcluir() {
		return renderizarBotaoExcluir;
	}

	public void setRenderizarBotaoExcluir(Boolean renderizarBotaoExcluir) {
		this.renderizarBotaoExcluir = renderizarBotaoExcluir;
	}
	
	public void Limpar() {
		edu_func_escola = new Edu_func_escola();
		
		edu_func_escolalista = new ArrayList<Edu_func_escola>();
	}
	
	public void AbreDialogoEditar() {
		renderizarBotaocadastrar = false;
		renderizarBotaoAtualizar = true;
		renderizarBotaoExcluir = false;
		
		PrimeFaces.current().executeScript("PF('dialogoCadastro').show();");
		
	}
	
	public void AbreDialogoExcluir() {
		renderizarBotaocadastrar = false;
		renderizarBotaoAtualizar = false;
		renderizarBotaoExcluir = true;
		
		PrimeFaces.current().executeScript("PF('dialogoCadastro').show();");
		
	}
	
	public void AbreDialogoCadastrar(){
		renderizarBotaocadastrar = true;
		renderizarBotaoAtualizar = false;
		renderizarBotaoExcluir = false;
		
		PrimeFaces.current().executeScript("PF('dialogoCadastro').show();");		
	}
	
	public void buscar() {
		Edu_func_escolaDao fd = new Edu_func_escolaDao();
		
		try {
			
			edu_func_escolalista = fd.findAll(edu_func_escola);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Cadastrar() {
		Integer linhas = 0;
		
		Edu_func_escolaDao fd = new Edu_func_escolaDao();
		
		try {
			
			linhas = fd.gravar(edu_func_escola);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistema gravado com sucesso! " + linhas + " registro incluído", ""));
			
			edu_func_escola = new Edu_func_escola();
			
			buscar();
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Atualizar() {
		Integer linhas = 0;
		
		Edu_func_escolaDao fd = new Edu_func_escolaDao();
		
		try {
			
			linhas = fd.alterar(edu_func_escola);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração efetuada com sucesso! " + linhas + " registros alterados", ""));
			
			edu_func_escola = new Edu_func_escola();
			
			buscar();
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Excluir(){
		Integer linhas = 0;
		
		try {
	
			Edu_func_escolaDao fd = new Edu_func_escolaDao();
			
			linhas = fd.excluir(edu_func_escola);
			
			edu_func_escola = new Edu_func_escola();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão efetuada com sucesso! " + linhas + " registros ecluídos", ""));
			
			buscar();

		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public String Listar() {
		try {
			
			Edu_func_escolaDao fd = new Edu_func_escolaDao();
			
			edu_func_escolalista = fd.findAll(edu_func_escola);
			
			new PaginasBean().SetPropriedadeSessionScope("edu_func_escolalista", edu_func_escolalista);
			
			return "ListarFuncionariosRel.xhtml?faces-redirect=true";
			
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		return null;
		
	}

}
