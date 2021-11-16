package entity;

public class Edu_matr_candidatoReport {
	
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
	
	private String nome_responsavel;
	private String tipo_responsavel;
	private String cpf_responsavel;
	private String email_responsavel;
	private String celular_responsavel;
	private Integer identidade_responsavel;
	private String emissoridt_responsavel;
	
	private String nome_escola;

	private Integer id_escola1;
	private Integer id_escola2;
	private Integer id_escola3;
	private Integer id_escolaselecionada;

	private String tipo_endereco; 
	private String identidade_endereco; 
	private String cep_endereco; 
	private String uf_endereco; 
	private String logradouro_endereco; 
	private String numero_endereco; 
	private String complemento_endereco; 
	private String codigo_municipio; 
	private String bairro_endereco;
	
	private String nome_escola1;
	private String nome_escola2;
	private String nome_escola3;
	private String nome_escolaselecionada;
	
	private String descricao_modensino;
	private String descricao_modensinoanos;
	
	private String tipo_candidato;
	private String necespec_candidato;
	private String cid_candidato;
	private String descricao_cid10;

	public Edu_matr_candidatoReport(Integer id_candidato, Integer id_responsavel, String nome_candidato,
			String mae_candidato, String pai_candidato, String nascimento_candidato, String alunodarede_candidato,
			String matricularede_candidato, String redeorigem_candidato, String estciv_candidato, String sexo_candidato,
			String nacionalidade_candidato, String email_candidato, String celular_candidato, String fixo_candidato,
			String bairro_candidato, String irmaonaescola_candidato, String nomeirmao_candidato, Integer id_escola,
			Integer id_modensinovagas1, Integer id_modensinovagas2, Integer id_modensinovagas3,
			Integer id_modensinovagas, Integer ano_candidato, String nome_responsavel, String tipo_responsavel,
			String cpf_responsavel, String email_responsavel, String celular_responsavel,
			Integer identidade_responsavel, String emissoridt_responsavel, String nome_escola, Integer id_escola1,
			Integer id_escola2, Integer id_escola3, Integer id_escolaselecionada, String tipo_endereco,
			String identidade_endereco, String cep_endereco, String uf_endereco, String logradouro_endereco,
			String numero_endereco, String complemento_endereco, String codigo_municipio, String bairro_endereco,
			String nome_escola1, String nome_escola2, String nome_escola3, String nome_escolaselecionada,
			String descricao_modensino, String descricao_modensinoanos, String tipo_candidato,
			String necespec_candidato, String cid_candidato, String descricao_cid10) {
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
		this.nome_responsavel = nome_responsavel;
		this.tipo_responsavel = tipo_responsavel;
		this.cpf_responsavel = cpf_responsavel;
		this.email_responsavel = email_responsavel;
		this.celular_responsavel = celular_responsavel;
		this.identidade_responsavel = identidade_responsavel;
		this.emissoridt_responsavel = emissoridt_responsavel;
		this.nome_escola = nome_escola;
		this.id_escola1 = id_escola1;
		this.id_escola2 = id_escola2;
		this.id_escola3 = id_escola3;
		this.id_escolaselecionada = id_escolaselecionada;
		this.tipo_endereco = tipo_endereco;
		this.identidade_endereco = identidade_endereco;
		this.cep_endereco = cep_endereco;
		this.uf_endereco = uf_endereco;
		this.logradouro_endereco = logradouro_endereco;
		this.numero_endereco = numero_endereco;
		this.complemento_endereco = complemento_endereco;
		this.codigo_municipio = codigo_municipio;
		this.bairro_endereco = bairro_endereco;
		this.nome_escola1 = nome_escola1;
		this.nome_escola2 = nome_escola2;
		this.nome_escola3 = nome_escola3;
		this.nome_escolaselecionada = nome_escolaselecionada;
		this.descricao_modensino = descricao_modensino;
		this.descricao_modensinoanos = descricao_modensinoanos;
		this.tipo_candidato = tipo_candidato;
		this.necespec_candidato = necespec_candidato;
		this.cid_candidato = cid_candidato;
		this.descricao_cid10 = descricao_cid10;
	}

	public Edu_matr_candidatoReport() {
		super();
	}

	public String getDescricao_cid10() {
		return descricao_cid10;
	}

	public void setDescricao_cid10(String descricao_cid10) {
		this.descricao_cid10 = descricao_cid10;
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

	public String getDescricao_modensino() {
		return descricao_modensino;
	}

	public void setDescricao_modensino(String descricao_modensino) {
		this.descricao_modensino = descricao_modensino;
	}

	public String getDescricao_modensinoanos() {
		return descricao_modensinoanos;
	}

	public void setDescricao_modensinoanos(String descricao_modensinoanos) {
		this.descricao_modensinoanos = descricao_modensinoanos;
	}

	public String getNome_escola1() {
		return nome_escola1;
	}

	public void setNome_escola1(String nome_escola1) {
		this.nome_escola1 = nome_escola1;
	}

	public String getNome_escola2() {
		return nome_escola2;
	}

	public void setNome_escola2(String nome_escola2) {
		this.nome_escola2 = nome_escola2;
	}

	public String getNome_escola3() {
		return nome_escola3;
	}

	public void setNome_escola3(String nome_escola3) {
		this.nome_escola3 = nome_escola3;
	}

	public String getNome_escolaselecionada() {
		return nome_escolaselecionada;
	}

	public void setNome_escolaselecionada(String nome_escolaselecionada) {
		this.nome_escolaselecionada = nome_escolaselecionada;
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

	public String getBairro_candidato() {
		return bairro_candidato;
	}

	public void setBairro_candidato(String bairro_candidato) {
		this.bairro_candidato = bairro_candidato;
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

	public Integer getAno_candidato() {
		return ano_candidato;
	}

	public void setAno_candidato(Integer ano_candidato) {
		this.ano_candidato = ano_candidato;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public String getTipo_responsavel() {
		return tipo_responsavel;
	}

	public void setTipo_responsavel(String tipo_responsavel) {
		this.tipo_responsavel = tipo_responsavel;
	}

	public String getCpf_responsavel() {
		return cpf_responsavel;
	}

	public void setCpf_responsavel(String cpf_responsavel) {
		this.cpf_responsavel = cpf_responsavel;
	}

	public String getEmail_responsavel() {
		return email_responsavel;
	}

	public void setEmail_responsavel(String email_responsavel) {
		this.email_responsavel = email_responsavel;
	}

	public String getCelular_responsavel() {
		return celular_responsavel;
	}

	public void setCelular_responsavel(String celular_responsavel) {
		this.celular_responsavel = celular_responsavel;
	}

	public Integer getIdentidade_responsavel() {
		return identidade_responsavel;
	}

	public void setIdentidade_responsavel(Integer identidade_responsavel) {
		this.identidade_responsavel = identidade_responsavel;
	}

	public String getEmissoridt_responsavel() {
		return emissoridt_responsavel;
	}

	public void setEmissoridt_responsavel(String emissoridt_responsavel) {
		this.emissoridt_responsavel = emissoridt_responsavel;
	}

	public String getNome_escola() {
		return nome_escola;
	}

	public void setNome_escola(String nome_escola) {
		this.nome_escola = nome_escola;
	}

	public Integer getId_escola1() {
		return id_escola1;
	}

	public void setId_escola1(Integer id_escola1) {
		this.id_escola1 = id_escola1;
	}

	public Integer getId_escola2() {
		return id_escola2;
	}

	public void setId_escola2(Integer id_escola2) {
		this.id_escola2 = id_escola2;
	}

	public Integer getId_escola3() {
		return id_escola3;
	}

	public void setId_escola3(Integer id_escola3) {
		this.id_escola3 = id_escola3;
	}

	public Integer getId_escolaselecionada() {
		return id_escolaselecionada;
	}

	public void setId_escolaselecionada(Integer id_escolaselecionada) {
		this.id_escolaselecionada = id_escolaselecionada;
	}

	public String getTipo_endereco() {
		return tipo_endereco;
	}

	public void setTipo_endereco(String tipo_endereco) {
		this.tipo_endereco = tipo_endereco;
	}

	public String getIdentidade_endereco() {
		return identidade_endereco;
	}

	public void setIdentidade_endereco(String identidade_endereco) {
		this.identidade_endereco = identidade_endereco;
	}

	public String getCep_endereco() {
		return cep_endereco;
	}

	public void setCep_endereco(String cep_endereco) {
		this.cep_endereco = cep_endereco;
	}

	public String getUf_endereco() {
		return uf_endereco;
	}

	public void setUf_endereco(String uf_endereco) {
		this.uf_endereco = uf_endereco;
	}

	public String getLogradouro_endereco() {
		return logradouro_endereco;
	}

	public void setLogradouro_endereco(String logradouro_endereco) {
		this.logradouro_endereco = logradouro_endereco;
	}

	public String getNumero_endereco() {
		return numero_endereco;
	}

	public void setNumero_endereco(String numero_endereco) {
		this.numero_endereco = numero_endereco;
	}

	public String getComplemento_endereco() {
		return complemento_endereco;
	}

	public void setComplemento_endereco(String complemento_endereco) {
		this.complemento_endereco = complemento_endereco;
	}

	public String getCodigo_municipio() {
		return codigo_municipio;
	}

	public void setCodigo_municipio(String codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}

	public String getBairro_endereco() {
		return bairro_endereco;
	}

	public void setBairro_endereco(String bairro_endereco) {
		this.bairro_endereco = bairro_endereco;
	}

	@Override
	public String toString() {
		return "Edu_matr_candidatoReport [id_candidato=" + id_candidato + ", id_responsavel=" + id_responsavel
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
				+ ", id_modensinovagas=" + id_modensinovagas + ", ano_candidato=" + ano_candidato
				+ ", nome_responsavel=" + nome_responsavel + ", tipo_responsavel=" + tipo_responsavel
				+ ", cpf_responsavel=" + cpf_responsavel + ", email_responsavel=" + email_responsavel
				+ ", celular_responsavel=" + celular_responsavel + ", identidade_responsavel=" + identidade_responsavel
				+ ", emissoridt_responsavel=" + emissoridt_responsavel + ", nome_escola=" + nome_escola
				+ ", id_escola1=" + id_escola1 + ", id_escola2=" + id_escola2 + ", id_escola3=" + id_escola3
				+ ", id_escolaselecionada=" + id_escolaselecionada + ", tipo_endereco=" + tipo_endereco
				+ ", identidade_endereco=" + identidade_endereco + ", cep_endereco=" + cep_endereco + ", uf_endereco="
				+ uf_endereco + ", logradouro_endereco=" + logradouro_endereco + ", numero_endereco=" + numero_endereco
				+ ", complemento_endereco=" + complemento_endereco + ", codigo_municipio=" + codigo_municipio
				+ ", bairro_endereco=" + bairro_endereco + ", nome_escola1=" + nome_escola1 + ", nome_escola2="
				+ nome_escola2 + ", nome_escola3=" + nome_escola3 + ", nome_escolaselecionada=" + nome_escolaselecionada
				+ ", descricao_modensino=" + descricao_modensino + ", descricao_modensinoanos="
				+ descricao_modensinoanos + ", tipo_candidato=" + tipo_candidato + ", necespec_candidato="
				+ necespec_candidato + ", cid_candidato=" + cid_candidato + ", descricao_cid10=" + descricao_cid10
				+ "]";
	}
}
