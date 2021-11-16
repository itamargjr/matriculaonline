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

import entity.Edu_escola;
import entity.Edu_func_escola;
import entity.End_endereco;
import persistence.Edu_escolaDao;
import persistence.Edu_func_escolaDao;

@ManagedBean
@ViewScoped
public class EscolaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5546739322868742791L;
	
	public Edu_escola escola;
	public End_endereco endereco;
	
	public List<Edu_escola> escolalista;
	public List<Edu_func_escola> edu_func_escolalista;
	public List<End_endereco> enderecolista;
	
	public Boolean renderizarBotaocadastrar;
	public Boolean renderizarBotaoAtualizar;
	public Boolean renderizarBotaoExcluir;
	
	public EscolaBean() {
		
		escola = new Edu_escola();
		
		escolalista = new ArrayList<Edu_escola>();
		
		renderizarBotaocadastrar = false;
		renderizarBotaoAtualizar = false;
		renderizarBotaoExcluir = false;
		
		Edu_func_escolaDao fd = new Edu_func_escolaDao();
		
		try {
			
			edu_func_escolalista = fd.findAllPorTipo("D");
			
			//System.out.println(edu_func_escolalista);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
	}
	
	@PostConstruct
	public void init() {
		carregalistadasession();
		
		limpalistadasession();		
	}
	
	@SuppressWarnings("unchecked") // isso é necessário para o eclipse não colocar warning na atribuição abaixo porque não entende que o objeto retornado é realmente uma lista
	public void carregalistadasession() {					
		escolalista = (List<Edu_escola>) new PaginasBean().GetPropriedadeSessionScope("escolalista");
	}
	
	public void limpalistadasession() {					
		new PaginasBean().RemovePropriedadeSessionScope("escolalista");
	}

	public End_endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(End_endereco endereco) {
		this.endereco = endereco;
	}

	public List<End_endereco> getEnderecolista() {
		return enderecolista;
	}

	public void setEnderecolista(List<End_endereco> enderecolista) {
		this.enderecolista = enderecolista;
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

	public List<Edu_escola> getEscolalista() {
		return escolalista;
	}

	public void setEscolalista(List<Edu_escola> escolalista) {
		this.escolalista = escolalista;
	}

	public Edu_escola getEscola() {
		return escola;
	}

	public void setEscola(Edu_escola escola) {
		this.escola = escola;
	}
	
	public void Limpar() {
		escola = new Edu_escola();
		
		escolalista = new ArrayList<Edu_escola>();
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
		Edu_escolaDao ed = new Edu_escolaDao();
		
		try {
			
			escolalista = ed.findAll(escola);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Cadastrar() {
		Integer linhas = 0;
		
		Edu_escolaDao ed = new Edu_escolaDao();
		
		try {
			
			linhas = ed.gravar(escola);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso! " + linhas + " registro incluído", ""));
			
			escola = new Edu_escola();
			
			buscar();
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Atualizar() {
		Integer linhas = 0;
		
		Edu_escolaDao ed = new Edu_escolaDao();
		
		try {
			
			linhas = ed.alterar(escola);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração efetuada com sucesso! " + linhas + " registros alterados", ""));
			
			escola = new Edu_escola();
			
			buscar();
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Excluir(){
		Integer linhas = 0;
		
		try {
	
			Edu_escolaDao ed = new Edu_escolaDao();
			
			linhas = ed.excluir(escola);
			
			escola = new Edu_escola();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão efetuada com sucesso! " + linhas + " registros ecluídos", ""));
			
			buscar();

		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public String Listar() {
		try {
			
			Edu_escolaDao ed = new Edu_escolaDao();
			
			escolalista = ed.findAll(escola);
			
			new PaginasBean().SetPropriedadeSessionScope("escolalista", escolalista);
			
			return "ListarEscolasRel.xhtml?faces-redirect=true";
			
			
		} catch  (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		return null;
		
	}
}
