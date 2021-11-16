package manager;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Cid10;
import persistence.Cid10Dao;

@ManagedBean
@ViewScoped
public class Cid10Bean {
	
	public Cid10 cid10;
	
	public List<Cid10> cid10lista;
	
	public Cid10Bean() {
		
		try {
			
			cid10lista = new Cid10Dao().findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
	}

	public Cid10 getCid10() {
		return cid10;
	}

	public void setCid10(Cid10 cid10) {
		this.cid10 = cid10;
	}

	public List<Cid10> getCid10lista() {
		return cid10lista;
	}

	public void setCid10lista(List<Cid10> cid10lista) {
		this.cid10lista = cid10lista;
	}

}
