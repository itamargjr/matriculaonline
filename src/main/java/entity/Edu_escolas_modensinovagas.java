package entity;

public class Edu_escolas_modensinovagas {
	private Integer id_modensinovagas;
	private Integer ano_modensinovagas;
	private Integer id_escola;
	private Integer id_modensinoanos;
	private Integer vagas_modensinovagas;
	
	private String nome_escola;
	private String descricao_modensinoanos;
	private Integer id_modensino;
	private String descricao_modensino;
	
	public Edu_escolas_modensinovagas(Integer id_modensinovagas, Integer ano_modensinovagas, Integer id_escola,
			Integer id_modensinoanos, Integer vagas_modensinovagas, String nome_escola, String descricao_modensinoanos,
			Integer id_modensino, String descricao_modensino) {
		super();
		this.id_modensinovagas = id_modensinovagas;
		this.ano_modensinovagas = ano_modensinovagas;
		this.id_escola = id_escola;
		this.id_modensinoanos = id_modensinoanos;
		this.vagas_modensinovagas = vagas_modensinovagas;
		this.nome_escola = nome_escola;
		this.descricao_modensinoanos = descricao_modensinoanos;
		this.id_modensino = id_modensino;
		this.descricao_modensino = descricao_modensino;
	}

	public Edu_escolas_modensinovagas() {
		super();
	}

	public Integer getId_modensinovagas() {
		return id_modensinovagas;
	}

	public void setId_modensinovagas(Integer id_modensinovagas) {
		this.id_modensinovagas = id_modensinovagas;
	}

	public Integer getAno_modensinovagas() {
		return ano_modensinovagas;
	}

	public void setAno_modensinovagas(Integer ano_modensinovagas) {
		this.ano_modensinovagas = ano_modensinovagas;
	}

	public Integer getId_escola() {
		return id_escola;
	}

	public void setId_escola(Integer id_escola) {
		this.id_escola = id_escola;
	}

	public Integer getId_modensinoanos() {
		return id_modensinoanos;
	}

	public void setId_modensinoanos(Integer id_modensinoanos) {
		this.id_modensinoanos = id_modensinoanos;
	}

	public Integer getVagas_modensinovagas() {
		return vagas_modensinovagas;
	}

	public void setVagas_modensinovagas(Integer vagas_modensinovagas) {
		this.vagas_modensinovagas = vagas_modensinovagas;
	}

	public String getNome_escola() {
		return nome_escola;
	}

	public void setNome_escola(String nome_escola) {
		this.nome_escola = nome_escola;
	}

	public String getDescricao_modensinoanos() {
		return descricao_modensinoanos;
	}

	public void setDescricao_modensinoanos(String descricao_modensinoanos) {
		this.descricao_modensinoanos = descricao_modensinoanos;
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
		return "Edu_escolas_modensinovagas [id_modensinovagas=" + id_modensinovagas + ", ano_modensinovagas="
				+ ano_modensinovagas + ", id_escola=" + id_escola + ", id_modensinoanos=" + id_modensinoanos
				+ ", vagas_modensinovagas=" + vagas_modensinovagas + ", nome_escola=" + nome_escola
				+ ", descricao_modensinoanos=" + descricao_modensinoanos + ", id_modensino=" + id_modensino
				+ ", descricao_modensino=" + descricao_modensino + "]";
	}

}
