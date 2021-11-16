package report;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import entity.Edu_matr_candidatoReport;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSReportCandidato implements JRDataSource {
	
	private Iterator<Edu_matr_candidatoReport> dados;
	
	private Edu_matr_candidatoReport registro;
	
	public DSReportCandidato(List<Edu_matr_candidatoReport> lista) {
		dados = lista.iterator();
	}
	
	@Override
	public Object getFieldValue(JRField field) throws JRException {
		if(field.getName().equalsIgnoreCase("id_candidato")){
			return new BigDecimal(registro.getId_candidato());
		}
		
		if(field.getName().equalsIgnoreCase("id_responsavel")){
			return new BigDecimal(registro.getId_responsavel());
		}
		
		if(field.getName().equalsIgnoreCase("nome_candidato")){
			return registro.getNome_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("mae_candidato")){
			return registro.getMae_candidato();
		}

		if(field.getName().equalsIgnoreCase("pai_candidato")){
			return registro.getPai_candidato();
		}
		if(field.getName().equalsIgnoreCase("nascimento_candidato")){
			return registro.getNascimento_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("alunodarede_candidato")){
			return registro.getAlunodarede_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("matricularede_candidato")){
			return registro.getMatricularede_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("redeorigem_candidato")){
			return registro.getRedeorigem_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("estciv_candidato")){
			return registro.getEstciv_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("sexo_candidato")){
			return registro.getSexo_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("nacionalidade_candidato")){
			return registro.getNacionalidade_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("email_candidato")){
			return registro.getEmail_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("celular_candidato")){
			return registro.getCelular_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("fixo_candidato")){
			return registro.getFixo_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("bairro_candidato")){
			return registro.getBairro_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("irmaonaescola_candidato")){
			return registro.getIrmaonaescola_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("nomeirmao_candidato")){
			return registro.getNomeirmao_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("id_escola")){
			return new BigDecimal(registro.getId_escola());
		}
		
		if(field.getName().equalsIgnoreCase("id_modensinovagas1")){
			return new BigDecimal(registro.getId_modensinovagas1());
		}
		
		if(field.getName().equalsIgnoreCase("id_modensinovagas2")){
			return new BigDecimal(registro.getId_modensinovagas2());
		}
		
		if(field.getName().equalsIgnoreCase("id_modensinovagas3")){
			return new BigDecimal(registro.getId_modensinovagas3());
		}
		
		if(field.getName().equalsIgnoreCase("id_modensinovagas")){
			return new BigDecimal(registro.getId_modensinovagas());
		}
		
		if(field.getName().equalsIgnoreCase("ano_candidato")){
			return new BigDecimal(registro.getAno_candidato());
		}
		
		if(field.getName().equalsIgnoreCase("nome_responsavel")){
			return registro.getNome_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("tipo_responsavel")){
			return registro.getTipo_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("cpf_responsavel")){
			return registro.getCpf_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("email_responsavel")){
			return registro.getEmail_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("celular_responsavel")){
			return registro.getCelular_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("identidade_responsavel")){
			return registro.getIdentidade_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("emissoridt_responsavel")){
			return registro.getEmissoridt_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("nome_escola")){
			return registro.getNome_escola();
		}
		
		if(field.getName().equalsIgnoreCase("id_escola1")){
			return new BigDecimal(registro.getId_escola1());
		}
		
		if(field.getName().equalsIgnoreCase("id_escola2")){
			return new BigDecimal(registro.getId_escola2());
		}
		
		if(field.getName().equalsIgnoreCase("id_escola3")){
			return new BigDecimal(registro.getId_escola3());
		}
		
		if(field.getName().equalsIgnoreCase("id_escolaselecionada")){
			return new BigDecimal(registro.getId_escolaselecionada());
		}
		
		if(field.getName().equalsIgnoreCase("tipo_endereco")){
			return registro.getTipo_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("identidade_endereco")){
			return registro.getIdentidade_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("cep_endereco")){
			return registro.getCep_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("uf_endereco")){
			return registro.getUf_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("logradouro_endereco")){
			return registro.getLogradouro_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("numero_endereco")){
			return registro.getNumero_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("complemento_endereco")){
			return registro.getComplemento_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("codigo_municipio")){
			return registro.getCodigo_municipio();
		}
		
		if(field.getName().equalsIgnoreCase("bairro_endereco")){
			return registro.getBairro_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("nome_escola1")){
			return registro.getNome_escola1();
		}
		
		if(field.getName().equalsIgnoreCase("nome_escola2")){
			return registro.getNome_escola2();
		}
		
		if(field.getName().equalsIgnoreCase("nome_escola3")){
			return registro.getNome_escola3();
		}
		
		if(field.getName().equalsIgnoreCase("nome_escolaselecionada")){
			return registro.getNome_escolaselecionada();
		}
		
		if(field.getName().equalsIgnoreCase("descricao_modensino")){
			return registro.getDescricao_modensino();
		}
		
		if(field.getName().equalsIgnoreCase("descricao_modensinoanos")){
			return registro.getDescricao_modensinoanos();
		}
		
		if(field.getName().equalsIgnoreCase("tipo_candidato")){
			return registro.getTipo_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("necespec_candidato")){
			return registro.getNecespec_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("cid_candidato")){
			return registro.getCid_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("descricao_cid10")){
			return registro.getDescricao_cid10();
		}
		
		return null;
	}

	@Override
	public boolean next() throws JRException {
		if(dados.hasNext()){
			registro = dados.next();
			return true;
		}
		return false;
	}

}
