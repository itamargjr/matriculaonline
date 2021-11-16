package entity;

public class Edu_escolas_modensinoanos {
	
	private Integer id_modensinoanos;
	private Integer id_modensino;
	private String descricao_modensinoanos;
	
	private String descricao_modensino;

	public Edu_escolas_modensinoanos(Integer id_modensinoanos, Integer id_modensino, String descricao_modensinoanos,
			String descricao_modensino) {
		super();
		this.id_modensinoanos = id_modensinoanos;
		this.id_modensino = id_modensino;
		this.descricao_modensinoanos = descricao_modensinoanos;
		this.descricao_modensino = descricao_modensino;
	}

	public Edu_escolas_modensinoanos() {
		super();
	}

	public String getDescricao_modensino() {
		return descricao_modensino;
	}

	public void setDescricao_modensino(String descricao_modensino) {
		this.descricao_modensino = descricao_modensino;
	}

	public Integer getId_modensinoanos() {
		return id_modensinoanos;
	}

	public void setId_modensinoanos(Integer id_modensinoanos) {
		this.id_modensinoanos = id_modensinoanos;
	}

	public Integer getId_modensino() {
		return id_modensino;
	}

	public void setId_modensino(Integer id_modensino) {
		this.id_modensino = id_modensino;
	}

	public String getDescricao_modensinoanos() {
		return descricao_modensinoanos;
	}

	public void setDescricao_modensinoanos(String descricao_modensinoanos) {
		this.descricao_modensinoanos = descricao_modensinoanos;
	}

	@Override
	public String toString() {
		return "Edu_escolas_modensinoanos [id_modensinoanos=" + id_modensinoanos + ", id_modensino=" + id_modensino
				+ ", descricao_modensinoanos=" + descricao_modensinoanos + ", descricao_modensino="
				+ descricao_modensino + "]";
	}

}
