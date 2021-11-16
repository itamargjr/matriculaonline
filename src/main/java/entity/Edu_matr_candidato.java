package entity;

public class Edu_matr_candidato {
	
	private Integer id_candidato;
	private Integer id_responsavel;
	private String nome_candidato;
	private String mae_candidato;
	private String pai_candidato;
	private String nascimento_candidato;
	private String alunodarede_candidato;
	private String matricularede_candidato;
	private String redeorigem_candidato;
	private String estciv_candidato;
	private String sexo_candidato;
	private String nacionalidade_candidato;
	private String email_candidato;
	private String celular_candidato;
	private String fixo_candidato;
	private String bairro_candidato;
	
	private String irmaonaescola_candidato;
	private String nomeirmao_candidato;
	private Integer id_escola;
	
	private Integer id_modensinovagas1; // primeira opção
	private Integer id_modensinovagas2; // primeira opção
	private Integer id_modensinovagas3; // primeira opção
	private Integer id_modensinovagas;  // Opção na qual foi selecionado
	
	private Integer ano_candidato;
	private String tipo_candidato;
	private String necespec_candidato;
	private String cid_candidato;

	public Edu_matr_candidato(Integer id_candidato, Integer id_responsavel, String nome_candidato, String mae_candidato,
			String pai_candidato, String nascimento_candidato, String alunodarede_candidato,
			String matricularede_candidato, String redeorigem_candidato, String estciv_candidato, String sexo_candidato,
			String nacionalidade_candidato, String email_candidato, String celular_candidato, String fixo_candidato,
			String bairro_candidato, String irmaonaescola_candidato, String nomeirmao_candidato, Integer id_escola,
			Integer id_modensinovagas1, Integer id_modensinovagas2, Integer id_modensinovagas3,
			Integer id_modensinovagas, Integer ano_candidato, String tipo_candidato, String necespec_candidato,
			String cid_candidato) {
		super();
		this.id_candidato = id_candidato;
		this.id_responsavel = id_responsavel;
		this.nome_candidato = nome_candidato;
		this.mae_candidato = mae_candidato;
		this.pai_candidato = pai_candidato;
		this.nascimento_candidato = nascimento_candidato;
		this.alunodarede_candidato = alunodarede_candidato;
		this.matricularede_candidato = matricularede_candidato;
		this.redeorigem_candidato = redeorigem_candidato;
		this.estciv_candidato = estciv_candidato;
		this.sexo_candidato = sexo_candidato;
		this.nacionalidade_candidato = nacionalidade_candidato;
		this.email_candidato = email_candidato;
		this.celular_candidato = celular_candidato;
		this.fixo_candidato = fixo_candidato;
		this.bairro_candidato = bairro_candidato;
		this.irmaonaescola_candidato = irmaonaescola_candidato;
		this.nomeirmao_candidato = nomeirmao_candidato;
		this.id_escola = id_escola;
		this.id_modensinovagas1 = id_modensinovagas1;
		this.id_modensinovagas2 = id_modensinovagas2;
		this.id_modensinovagas3 = id_modensinovagas3;
		this.id_modensinovagas = id_modensinovagas;
		this.ano_candidato = ano_candidato;
		this.tipo_candidato = tipo_candidato;
		this.necespec_candidato = necespec_candidato;
		this.cid_candidato = cid_candidato;
	}

	public Edu_matr_candidato() {
		super();
	}

	public Edu_matr_candidato(Integer id_candidato, String nome_candidato, String mae_candidato, String nascimento_candidato) {
		super();
		this.id_candidato = id_candidato;
		this.nome_candidato = nome_candidato;
		this.mae_candidato = mae_candidato;
		this.nascimento_candidato = nascimento_candidato;
	}

	public String getTipo_candidato() {
		return tipo_candidato;
	}

	public void setTipo_candidato(String tipo_candidato) {
		this.tipo_candidato = tipo_candidato;
	}

	public String getNecespec_candidato() {
		return necespec_candidato;
	}

	public void setNecespec_candidato(String necespec_candidato) {
		this.necespec_candidato = necespec_candidato;
	}

	public String getCid_candidato() {
		return cid_candidato;
	}

	public void setCid_candidato(String cid_candidato) {
		this.cid_candidato = cid_candidato;
	}

	public Integer getAno_candidato() {
		return ano_candidato;
	}

	public void setAno_candidato(Integer ano_candidato) {
		this.ano_candidato = ano_candidato;
	}

	public String getIrmaonaescola_candidato() {
		return irmaonaescola_candidato;
	}

	public void setIrmaonaescola_candidato(String irmaonaescola_candidato) {
		this.irmaonaescola_candidato = irmaonaescola_candidato;
	}

	public String getNomeirmao_candidato() {
		return nomeirmao_candidato;
	}

	public void setNomeirmao_candidato(String nomeirmao_candidato) {
		this.nomeirmao_candidato = nomeirmao_candidato;
	}

	public Integer getId_escola() {
		return id_escola;
	}

	public void setId_escola(Integer id_escola) {
		this.id_escola = id_escola;
	}

	public Integer getId_modensinovagas1() {
		return id_modensinovagas1;
	}

	public void setId_modensinovagas1(Integer id_modensinovagas1) {
		this.id_modensinovagas1 = id_modensinovagas1;
	}

	public Integer getId_modensinovagas2() {
		return id_modensinovagas2;
	}

	public void setId_modensinovagas2(Integer id_modensinovagas2) {
		this.id_modensinovagas2 = id_modensinovagas2;
	}

	public Integer getId_modensinovagas3() {
		return id_modensinovagas3;
	}

	public void setId_modensinovagas3(Integer id_modensinovagas3) {
		this.id_modensinovagas3 = id_modensinovagas3;
	}

	public Integer getId_modensinovagas() {
		return id_modensinovagas;
	}

	public void setId_modensinovagas(Integer id_modensinovagas) {
		this.id_modensinovagas = id_modensinovagas;
	}

	public String getBairro_candidato() {
		return bairro_candidato;
	}

	public void setBairro_candidato(String bairro_candidato) {
		this.bairro_candidato = bairro_candidato;
	}

	public Integer getId_candidato() {
		return id_candidato;
	}

	public void setId_candidato(Integer id_candidato) {
		this.id_candidato = id_candidato;
	}

	public Integer getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Integer id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNome_candidato() {
		return nome_candidato;
	}

	public void setNome_candidato(String nome_candidato) {
		this.nome_candidato = nome_candidato;
	}

	public String getMae_candidato() {
		return mae_candidato;
	}

	public void setMae_candidato(String mae_candidato) {
		this.mae_candidato = mae_candidato;
	}

	public String getPai_candidato() {
		return pai_candidato;
	}

	public void setPai_candidato(String pai_candidato) {
		this.pai_candidato = pai_candidato;
	}

	public String getNascimento_candidato() {
		return nascimento_candidato;
	}

	public void setNascimento_candidato(String nascimento_candidato) {
		this.nascimento_candidato = nascimento_candidato;
	}

	public String getAlunodarede_candidato() {
		return alunodarede_candidato;
	}

	public void setAlunodarede_candidato(String alunodarede_candidato) {
		this.alunodarede_candidato = alunodarede_candidato;
	}

	public String getMatricularede_candidato() {
		return matricularede_candidato;
	}

	public void setMatricularede_candidato(String matricularede_candidato) {
		this.matricularede_candidato = matricularede_candidato;
	}

	public String getRedeorigem_candidato() {
		return redeorigem_candidato;
	}

	public void setRedeorigem_candidato(String redeorigem_candidato) {
		this.redeorigem_candidato = redeorigem_candidato;
	}

	public String getEstciv_candidato() {
		return estciv_candidato;
	}

	public void setEstciv_candidato(String estciv_candidato) {
		this.estciv_candidato = estciv_candidato;
	}

	public String getSexo_candidato() {
		return sexo_candidato;
	}

	public void setSexo_candidato(String sexo_candidato) {
		this.sexo_candidato = sexo_candidato;
	}

	public String getNacionalidade_candidato() {
		return nacionalidade_candidato;
	}

	public void setNacionalidade_candidato(String nacionalidade_candidato) {
		this.nacionalidade_candidato = nacionalidade_candidato;
	}

	public String getEmail_candidato() {
		return email_candidato;
	}

	public void setEmail_candidato(String email_candidato) {
		this.email_candidato = email_candidato;
	}

	public String getCelular_candidato() {
		return celular_candidato;
	}

	public void setCelular_candidato(String celular_candidato) {
		this.celular_candidato = celular_candidato;
	}

	public String getFixo_candidato() {
		return fixo_candidato;
	}

	public void setFixo_candidato(String fixo_candidato) {
		this.fixo_candidato = fixo_candidato;
	}

	@Override
	public String toString() {
		return "Edu_matr_candidato [id_candidato=" + id_candidato + ", id_responsavel=" + id_responsavel
				+ ", nome_candidato=" + nome_candidato + ", mae_candidato=" + mae_candidato + ", pai_candidato="
				+ pai_candidato + ", nascimento_candidato=" + nascimento_candidato + ", alunodarede_candidato="
				+ alunodarede_candidato + ", matricularede_candidato=" + matricularede_candidato
				+ ", redeorigem_candidato=" + redeorigem_candidato + ", estciv_candidato=" + estciv_candidato
				+ ", sexo_candidato=" + sexo_candidato + ", nacionalidade_candidato=" + nacionalidade_candidato
				+ ", email_candidato=" + email_candidato + ", celular_candidato=" + celular_candidato
				+ ", fixo_candidato=" + fixo_candidato + ", bairro_candidato=" + bairro_candidato
				+ ", irmaonaescola_candidato=" + irmaonaescola_candidato + ", nomeirmao_candidato="
				+ nomeirmao_candidato + ", id_escola=" + id_escola + ", id_modensinovagas1=" + id_modensinovagas1
				+ ", id_modensinovagas2=" + id_modensinovagas2 + ", id_modensinovagas3=" + id_modensinovagas3
				+ ", id_modensinovagas=" + id_modensinovagas + ", ano_candidato=" + ano_candidato + ", tipo_candidato="
				+ tipo_candidato + ", necespec_candidato=" + necespec_candidato + ", cid_candidato=" + cid_candidato
				+ "]";
	}
}
