package entity;

public class Cid10 {
	
	private String codigo_cid10;
	private String descricao_cid10;
	
	public Cid10() {
		super();
	}

	public Cid10(String codigo_cid10, String descricao_cid10) {
		super();
		this.codigo_cid10 = codigo_cid10;
		this.descricao_cid10 = descricao_cid10;
	}

	public String getCodigo_cid10() {
		return codigo_cid10;
	}

	public void setCodigo_cid10(String codigo_cid10) {
		this.codigo_cid10 = codigo_cid10;
	}

	public String getDescricao_cid10() {
		return descricao_cid10;
	}

	public void setDescricao_cid10(String descricao_cid10) {
		this.descricao_cid10 = descricao_cid10;
	}

	@Override
	public String toString() {
		return "Cid10 [codigo_cid10=" + codigo_cid10 + ", descricao_cid10=" + descricao_cid10 + "]";
	}

}
