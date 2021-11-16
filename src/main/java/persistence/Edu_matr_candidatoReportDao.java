package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Edu_matr_candidatoReport;

public class Edu_matr_candidatoReportDao extends Dao {
	
	public List<Edu_matr_candidatoReport> findCandidato(Integer cand) throws Exception {
		List<Edu_matr_candidatoReport> lista = new ArrayList<Edu_matr_candidatoReport>();
		
		open();
		
		String statement = "select " + 
				"  aa.*, " + 
				"  bb.nome_escola as nome_escola1, cc.nome_escola as nome_escola2, " +
				"  dd.nome_escola as nome_escola3, " +
				"  gg.descricao_modensino, ff.descricao_modensinoanos " +
				"from ( " +
				"select " +
				"  a.id_candidato, a.id_responsavel, a.nome_candidato, a.mae_candidato,  " +
				"  a.pai_candidato, a.nascimento_candidato, a.alunodarede_candidato,  " +
				"  a.matricularede_candidato, a.redeorigem_candidato, a.estciv_candidato,  " +
				"  a.sexo_candidato, a.nacionalidade_candidato, a.email_candidato, " +
				"  a.celular_candidato, a.fixo_candidato, a.bairro_candidato,  " +
				"  a.irmaonaescola_candidato, a.nomeirmao_candidato,  " +
				"  a.id_escola, a.id_modensinovagas1, a.id_modensinovagas2,  " +
				"  a.id_modensinovagas3, a.id_modensinovagas, a.ano_candidato, " +
				"  a.tipo_candidato, a.necespec_candidato, a.cid_candidato, " +
 
				"  b.nome_responsavel, b.tipo_responsavel, b.cpf_responsavel,  " +
				"  b.email_responsavel, b.celular_responsavel, b.identidade_responsavel,  " +
				"  b.emissoridt_responsavel, " +

				"  c.nome_escola, " +

				"  d.id_escola as id_escola1, " +

				"  e.id_escola as id_escola2, " +

				"  f.id_escola as id_escola3, " +

				"  g.id_escola as id_escolaselecionada, " +

				"  h.tipo_endereco, h.identidade_endereco, h.cep_endereco,  " +
				"  h.uf_endereco, h.logradouro_endereco, h.numero_endereco,  " +
				"  h.complemento_endereco, h.codigo_municipio, h.bairro_endereco, " +
				"  i.descricao_cid10 " +
				"from " +
				"  edu_matr_candidato a  " +
				"    left outer join edu_escolas c on (a.id_escola = c.id_escola) " +
				"    left outer join edu_escolas_modensinovagas d on (a.id_modensinovagas1 = d.id_modensinovagas) " +
				"    left outer join edu_escolas_modensinovagas e on (a.id_modensinovagas2 = e.id_modensinovagas) " +
				"    left outer join edu_escolas_modensinovagas f on (a.id_modensinovagas3 = f.id_modensinovagas) " +
				"    left outer join edu_escolas_modensinovagas g on (a.id_modensinovagas = g.id_modensinovagas)  " +
				"    left outer join cid10 i on (a.cid_candidato = i.codigo_cid10),  " +
				"  edu_matr_responsavel b, end_endereco h " +
				"where " +
				"  a.id_candidato = " + cand + " and " +
				"  a.id_responsavel = b.id_responsavel AND " +
				"  a.id_candidato = h.identidade_endereco AND " +
				"  h.tipo_endereco = 'C' " +
				") aa " +
				"  left outer join edu_escolas bb on (aa.id_escola1 = bb.id_escola) " +
				"  left outer join edu_escolas cc on (aa.id_escola2 = cc.id_escola) " +
				"  left outer join edu_escolas dd on (aa.id_escola3 = dd.id_escola), " +
				"  edu_escolas_modensinovagas ee, edu_escolas_modensinoanos ff, " +
				"  edu_escolas_modensino gg " +
				"where " +
				"  aa.id_modensinovagas1 = ee.id_modensinovagas and " +
				"  ee.id_modensinoanos   = ff.id_modensinoanos  and " +
				"  ff.id_modensino       = gg.id_modensino ";
		
		stmt = con.prepareStatement(statement);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Edu_matr_candidatoReport item = new Edu_matr_candidatoReport(rs.getInt("id_candidato"),
					rs.getInt("id_responsavel"),
					rs.getString("nome_candidato"),
					rs.getString("mae_candidato"),
					rs.getString("pai_candidato"),
					rs.getString("nascimento_candidato"),
					rs.getString("alunodarede_candidato"),
					rs.getString("matricularede_candidato"),
					rs.getString("redeorigem_candidato"),
					rs.getString("estciv_candidato"),
					rs.getString("sexo_candidato"),
					rs.getString("nacionalidade_candidato"),
					rs.getString("email_candidato"),
					rs.getString("celular_candidato"),
					rs.getString("fixo_candidato"),
					rs.getString("bairro_candidato"),
					
					rs.getString("irmaonaescola_candidato"),
					rs.getString("nomeirmao_candidato"),
					rs.getInt("id_escola"),
					
					rs.getInt("id_modensinovagas1"), 
					rs.getInt("id_modensinovagas2"), 
					rs.getInt("id_modensinovagas3"), 
					rs.getInt("id_modensinovagas"),  
					
					rs.getInt("ano_candidato"),
					
					rs.getString("nome_responsavel"),
					rs.getString("tipo_responsavel"),
					rs.getString("cpf_responsavel"),
					rs.getString("email_responsavel"),
					rs.getString("celular_responsavel"),
					rs.getInt("identidade_responsavel"),
					rs.getString("emissoridt_responsavel"),
					
					rs.getString("nome_escola"),

					rs.getInt("id_escola1"),
					rs.getInt("id_escola2"),
					rs.getInt("id_escola3"),
					rs.getInt("id_escolaselecionada"),

					rs.getString("tipo_endereco"), 
					rs.getString("identidade_endereco"), 
					rs.getString("cep_endereco"), 
					rs.getString("uf_endereco"), 
					rs.getString("logradouro_endereco"), 
					rs.getString("numero_endereco"), 
					rs.getString("complemento_endereco"), 
					rs.getString("codigo_municipio"), 
					rs.getString("bairro_endereco"), 
					rs.getString("nome_escola1"), 
					rs.getString("nome_escola2"), 
					rs.getString("nome_escola3"), 
					null, //rs.getString("nome_escolaselecionada"), // eu não tenho a escola selecionada neste momento
					rs.getString("descricao_modensino"),
					rs.getString("descricao_modensinoanos"), 
					rs.getString("tipo_candidato"), 
					rs.getString("necespec_candidato"), 
					rs.getString("cid_candidato"), 
					rs.getString("descricao_cid10"));
			
			lista.add(item);
		}						  
		
		close();
		
		return lista;
	}
	
	public Edu_matr_candidatoReport findCandidatoConsulta(Edu_matr_candidatoReport cand) throws Exception {
		Edu_matr_candidatoReport c = new Edu_matr_candidatoReport();
		
		open();
		
		String statement = "select " + 
				"  aa.*, " + 
				"  bb.nome_escola as nome_escola1, cc.nome_escola as nome_escola2, " +
				"  dd.nome_escola as nome_escola3, " +
				"  gg.descricao_modensino, ff.descricao_modensinoanos " +
				"from ( " +
				"select " +
				"  a.id_candidato, a.id_responsavel, a.nome_candidato, a.mae_candidato,  " +
				"  a.pai_candidato, a.nascimento_candidato, a.alunodarede_candidato,  " +
				"  a.matricularede_candidato, a.redeorigem_candidato, a.estciv_candidato,  " +
				"  a.sexo_candidato, a.nacionalidade_candidato, a.email_candidato, " +
				"  a.celular_candidato, a.fixo_candidato, a.bairro_candidato,  " +
				"  a.irmaonaescola_candidato, a.nomeirmao_candidato,  " +
				"  a.id_escola, a.id_modensinovagas1, a.id_modensinovagas2,  " +
				"  a.id_modensinovagas3, a.id_modensinovagas, a.ano_candidato, " +
				"  a.tipo_candidato, a.necespec_candidato, a.cid_candidato, " +
 
				"  b.nome_responsavel, b.tipo_responsavel, b.cpf_responsavel,  " +
				"  b.email_responsavel, b.celular_responsavel, b.identidade_responsavel,  " +
				"  b.emissoridt_responsavel, " +

				"  c.nome_escola, " +

				"  d.id_escola as id_escola1, " +

				"  e.id_escola as id_escola2, " +

				"  f.id_escola as id_escola3, " +

				"  g.id_escola as id_escolaselecionada, " +

				"  h.tipo_endereco, h.identidade_endereco, h.cep_endereco,  " +
				"  h.uf_endereco, h.logradouro_endereco, h.numero_endereco,  " +
				"  h.complemento_endereco, h.codigo_municipio, h.bairro_endereco, " +
				"  i.descricao_cid10 " +
				"from " +
				"  edu_matr_candidato a  " +
				"    left outer join edu_escolas c on (a.id_escola = c.id_escola) " +
				"    left outer join edu_escolas_modensinovagas d on (a.id_modensinovagas1 = d.id_modensinovagas) " +
				"    left outer join edu_escolas_modensinovagas e on (a.id_modensinovagas2 = e.id_modensinovagas) " +
				"    left outer join edu_escolas_modensinovagas f on (a.id_modensinovagas3 = f.id_modensinovagas) " +
				"    left outer join edu_escolas_modensinovagas g on (a.id_modensinovagas = g.id_modensinovagas)  " +
				"    left outer join cid10 i on (a.cid_candidato = i.codigo_cid10),  " +
				"  edu_matr_responsavel b, end_endereco h " +
				"where " +
				"  a.nascimento_candidato = '" + cand.getNascimento_candidato() + "' and " +
				"  a.nome_candidato = '" + cand.getNome_candidato() + "' and " +
				"  a.email_candidato = '" + cand.getEmail_candidato() + "' and " +
				"  a.ano_candidato = '" + cand.getAno_candidato() + "' and " +
				"  a.id_responsavel = b.id_responsavel AND " +
				"  a.id_candidato = h.identidade_endereco AND " +
				"  h.tipo_endereco = 'C' " +
				") aa " +
				"  left outer join edu_escolas bb on (aa.id_escola1 = bb.id_escola) " +
				"  left outer join edu_escolas cc on (aa.id_escola2 = cc.id_escola) " +
				"  left outer join edu_escolas dd on (aa.id_escola3 = dd.id_escola), " +
				"  edu_escolas_modensinovagas ee, edu_escolas_modensinoanos ff, " +
				"  edu_escolas_modensino gg " +
				"where " +
				"  aa.id_modensinovagas1 = ee.id_modensinovagas and " +
				"  ee.id_modensinoanos   = ff.id_modensinoanos  and " +
				"  ff.id_modensino       = gg.id_modensino ";
		
		stmt = con.prepareStatement(statement);
		
		//System.out.println(statement);
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			c = new Edu_matr_candidatoReport(rs.getInt("id_candidato"),
					rs.getInt("id_responsavel"),
					rs.getString("nome_candidato"),
					rs.getString("mae_candidato"),
					rs.getString("pai_candidato"),
					rs.getString("nascimento_candidato"),
					rs.getString("alunodarede_candidato"),
					rs.getString("matricularede_candidato"),
					rs.getString("redeorigem_candidato"),
					rs.getString("estciv_candidato"),
					rs.getString("sexo_candidato"),
					rs.getString("nacionalidade_candidato"),
					rs.getString("email_candidato"),
					rs.getString("celular_candidato"),
					rs.getString("fixo_candidato"),
					rs.getString("bairro_candidato"),
					
					rs.getString("irmaonaescola_candidato"),
					rs.getString("nomeirmao_candidato"),
					rs.getInt("id_escola"),
					
					rs.getInt("id_modensinovagas1"), 
					rs.getInt("id_modensinovagas2"), 
					rs.getInt("id_modensinovagas3"), 
					rs.getInt("id_modensinovagas"),  
					
					rs.getInt("ano_candidato"),
					
					rs.getString("nome_responsavel"),
					rs.getString("tipo_responsavel"),
					rs.getString("cpf_responsavel"),
					rs.getString("email_responsavel"),
					rs.getString("celular_responsavel"),
					rs.getInt("identidade_responsavel"),
					rs.getString("emissoridt_responsavel"),
					
					rs.getString("nome_escola"),

					rs.getInt("id_escola1"),
					rs.getInt("id_escola2"),
					rs.getInt("id_escola3"),
					rs.getInt("id_escolaselecionada"),

					rs.getString("tipo_endereco"), 
					rs.getString("identidade_endereco"), 
					rs.getString("cep_endereco"), 
					rs.getString("uf_endereco"), 
					rs.getString("logradouro_endereco"), 
					rs.getString("numero_endereco"), 
					rs.getString("complemento_endereco"), 
					rs.getString("codigo_municipio"), 
					rs.getString("bairro_endereco"), 
					rs.getString("nome_escola1"), 
					rs.getString("nome_escola2"), 
					rs.getString("nome_escola3"), 
					null, //rs.getString("nome_escolaselecionada"), // eu não tenho a escola selecionada neste momento
					rs.getString("descricao_modensino"),
					rs.getString("descricao_modensinoanos"), 
					rs.getString("tipo_candidato"), 
					rs.getString("necespec_candidato"), 
					rs.getString("cid_candidato"), 
					rs.getString("descricao_cid10"));

		}						  
		
		close();
		
		return c;
	}
	
	public void cancelaInscricao(Edu_matr_candidatoReport cand) throws Exception {
		open();
		
		stmt = con.prepareStatement("delete from edu_matr_candidato where id_candidato = ?");
		
		stmt.setInt(1, cand.getId_candidato());
		
		Integer linhasafetadas = stmt.executeUpdate();
		
		if (linhasafetadas==0) {
			throw new Exception("Erro ao cancelar candidato");
		} else {
			stmt = con.prepareStatement("delete from end_endereco where identidade_endereco = ? and tipo_endereco = 'C'");
			
			stmt.setInt(1, cand.getId_candidato());
			
			stmt.executeUpdate();
		}
		
		close();
	}

}
