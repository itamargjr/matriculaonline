package entity;

import java.io.Serializable;

public class Edu_escola implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -710092665726080947L;
	
	private Integer id_escola;
    private String nome_escola;
    private String telefone_escola;
    private Integer id_funcescola;
    private String cnpj_escola;
    private String inep_escola;
    private String email_escola;
    private Integer vagaspcd_escola;
    private Integer vagasgeral_escola;
    private String bairro_escola;
    
    private String nome_funcescola;
    
	public Edu_escola() {
		super();
	}

	public Edu_escola(Integer id_escola, String nome_escola, String telefone_escola, Integer id_funcescola,
			String cnpj_escola, String inep_escola, String email_escola, Integer vagaspcd_escola,
			Integer vagasgeral_escola, String bairro_escola, String nome_funcescola) {
		super();
		this.id_escola = id_escola;
		this.nome_escola = nome_escola;
		this.telefone_escola = telefone_escola;
		this.id_funcescola = id_funcescola;
		this.cnpj_escola = cnpj_escola;
		this.inep_escola = inep_escola;
		this.email_escola = email_escola;
		this.vagaspcd_escola = vagaspcd_escola;
		this.vagasgeral_escola = vagasgeral_escola;
		this.bairro_escola = bairro_escola;
		this.nome_funcescola = nome_funcescola;
	}

	public String getNome_funcescola() {
		return nome_funcescola;
	}

	public void setNome_funcescola(String nome_funcescola) {
		this.nome_funcescola = nome_funcescola;
	}

	public String getBairro_escola() {
		return bairro_escola;
	}

	public void setBairro_escola(String bairro_escola) {
		this.bairro_escola = bairro_escola;
	}

	public Integer getId_escola() {
		return id_escola;
	}

	public void setId_escola(Integer id_escola) {
		this.id_escola = id_escola;
	}

	public String getNome_escola() {
		return nome_escola;
	}

	public void setNome_escola(String nome_escola) {
		this.nome_escola = nome_escola;
	}

	public String getTelefone_escola() {
		return telefone_escola;
	}

	public void setTelefone_escola(String telefone_escola) {
		this.telefone_escola = telefone_escola;
	}

	public Integer getId_funcescola() {
		return id_funcescola;
	}

	public void setId_funcescola(Integer id_funcescola) {
		this.id_funcescola = id_funcescola;
	}

	public String getCnpj_escola() {
		return cnpj_escola;
	}

	public void setCnpj_escola(String cnpj_escola) {
		this.cnpj_escola = cnpj_escola;
	}

	public String getInep_escola() {
		return inep_escola;
	}

	public void setInep_escola(String inep_escola) {
		this.inep_escola = inep_escola;
	}

	public String getEmail_escola() {
		return email_escola;
	}

	public void setEmail_escola(String email_escola) {
		this.email_escola = email_escola;
	}

	public Integer getVagaspcd_escola() {
		return vagaspcd_escola;
	}

	public void setVagaspcd_escola(Integer vagaspcd_escola) {
		this.vagaspcd_escola = vagaspcd_escola;
	}

	public Integer getVagasgeral_escola() {
		return vagasgeral_escola;
	}

	public void setVagasgeral_escola(Integer vagasgeral_escola) {
		this.vagasgeral_escola = vagasgeral_escola;
	}

	@Override
	public String toString() {
		return "Edu_escola [id_escola=" + id_escola + ", nome_escola=" + nome_escola + ", telefone_escola="
				+ telefone_escola + ", id_funcescola=" + id_funcescola + ", cnpj_escola=" + cnpj_escola
				+ ", inep_escola=" + inep_escola + ", email_escola=" + email_escola + ", vagaspcd_escola="
				+ vagaspcd_escola + ", vagasgeral_escola=" + vagasgeral_escola + ", bairro_escola=" + bairro_escola
				+ ", nome_funcescola=" + nome_funcescola + "]";
	}
}
