package entity;

public class Edu_escolas_modensino {
	
	private Integer id_modensino;
	private String descricao_modensino;
	
	public Edu_escolas_modensino(Integer id_modensino, String descricao_modensino) {
		super();
		this.id_modensino = id_modensino;
		this.descricao_modensino = descricao_modensino;
	}

	public Edu_escolas_modensino() {
		super();
	}

	public Integer getId_modensino() {
		return id_modensino;
	}

	public void setId_modensino(Integer id_modensino) {
		this.id_modensino = id_modensino;
	}

	public String getDescricao_modensino() {
		return descricao_modensino;
	}

	public void setDescricao_modensino(String descricao_modensino) {
		this.descricao_modensino = descricao_modensino;
	}

	@Override
	public String toString() {
		return "Edu_escolas_modensino [id_modensino=" + id_modensino + ", descricao_modensino=" + descricao_modensino
				+ "]";
	}

}
