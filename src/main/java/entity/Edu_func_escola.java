package entity;

import java.io.Serializable;

public class Edu_func_escola implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2684247097836264651L;
	
	private Integer id_funcescola;
	private String nome_funcescola;
	private String cpf_funcescola;
	private String email_funcescola; 
	private String celular_funcescola;
	private String matriculapref_funcescola;
	private String tipo_funcescola;
	
	public Edu_func_escola() {
		super();
	}

	public Edu_func_escola(Integer id_funcescola, String nome_funcescola, String cpf_funcescola,
			String email_funcescola, String celular_funcescola, String matriculapref_funcescola,
			String tipo_funcescola) {
		super();
		this.id_funcescola = id_funcescola;
		this.nome_funcescola = nome_funcescola;
		this.cpf_funcescola = cpf_funcescola;
		this.email_funcescola = email_funcescola;
		this.celular_funcescola = celular_funcescola;
		this.matriculapref_funcescola = matriculapref_funcescola;
		this.tipo_funcescola = tipo_funcescola;
	}

	public String getTipo_funcescola() {
		return tipo_funcescola;
	}

	public void setTipo_funcescola(String tipo_funcescola) {
		this.tipo_funcescola = tipo_funcescola;
	}

	public Integer getId_funcescola() {
		return id_funcescola;
	}

	public void setId_funcescola(Integer id_funcescola) {
		this.id_funcescola = id_funcescola;
	}

	public String getNome_funcescola() {
		return nome_funcescola;
	}

	public void setNome_funcescola(String nome_funcescola) {
		this.nome_funcescola = nome_funcescola;
	}

	public String getCpf_funcescola() {
		return cpf_funcescola;
	}

	public void setCpf_funcescola(String cpf_funcescola) {
		this.cpf_funcescola = cpf_funcescola;
	}

	public String getEmail_funcescola() {
		return email_funcescola;
	}

	public void setEmail_funcescola(String email_funcescola) {
		this.email_funcescola = email_funcescola;
	}

	public String getCelular_funcescola() {
		return celular_funcescola;
	}

	public void setCelular_funcescola(String celular_funcescola) {
		this.celular_funcescola = celular_funcescola;
	}

	public String getMatriculapref_funcescola() {
		return matriculapref_funcescola;
	}

	public void setMatriculapref_funcescola(String matriculapref_funcescola) {
		this.matriculapref_funcescola = matriculapref_funcescola;
	}

	@Override
	public String toString() {
		return "Edu_func_escola [id_funcescola=" + id_funcescola + ", nome_funcescola=" + nome_funcescola
				+ ", cpf_funcescola=" + cpf_funcescola + ", email_funcescola=" + email_funcescola
				+ ", celular_funcescola=" + celular_funcescola + ", matriculapref_funcescola="
				+ matriculapref_funcescola + ", tipo_funcescola=" + tipo_funcescola + "]";
	}
}
