package persistence;

import java.sql.Types;

import entity.Edu_matr_candidato;

public class Edu_matr_candidatoDao extends Dao {
	
	public Edu_matr_candidato login(Edu_matr_candidato cand)throws Exception{
		
		Edu_matr_candidato c = new Edu_matr_candidato();
		
		open();
		
		stmt = con.prepareStatement("select id_candidato, nome_candidato, mae_candidato, nascimento_candidato " +
		                            "from edu_matr_candidato where upper(nome_candidato) = ? and upper(mae_candidato) = ? and nascimento_candidato = ?");
		
		stmt.setString(1, cand.getNome_candidato().toUpperCase());
		stmt.setString(2, cand.getMae_candidato().toUpperCase());
		stmt.setString(2, cand.getNascimento_candidato());
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			
			c = new Edu_matr_candidato(rs.getInt("id_candidato"), rs.getString("nome_candidato"), rs.getString("mae_candidato"), 
					                   rs.getString("nascimento_candidato"));
			
		}
		
		return c;
		
	}
	
	public boolean testaCandidatoJaExiste(Edu_matr_candidato cand) throws Exception{
		Boolean JaExiste = false;
		
		open();
		
		String statement = "select id_candidato from edu_matr_candidato " +
                		   "where cpf_candidato = '" + cand.getCpf_candidato()   + "'";
		
		stmt = con.prepareStatement(statement);
		
		rs = stmt.executeQuery();
		
//		System.out.println(statement);
		
		if (rs.next()) {
			
			JaExiste = true;
			
		}
		
		return JaExiste;
	}
	

	
	public String testaCandidatoJaMatriculado(Edu_matr_candidato cand) throws Exception{
		String escola = "";
		
		open();
		
		String statement = "SELECT " +
						   "  a.id_candidato, a.cpf_candidato, a.nome_candidato, b.id_escola, " +
						   "  c.nome_escola " +
						   "FROM " +
						   "  edu_matr_candidatofase1 a, edu_escolas_matricula b, edu_escolas c " +
						   "WHERE " +
						   "  a.id_candidato = b.id_candidato AND " +
						   "  a.ano_candidato = b.ano_matricula AND " +
						   "  b.id_escola = c.id_escola and " +
						   "  a.cpf_candidato = '" + cand.getCpf_candidato()   + "'";
		
		stmt = con.prepareStatement(statement);
		
		rs = stmt.executeQuery();
		
//		System.out.println(statement);
		
		if (rs.next()) {
			
			escola = rs.getString("nome_escola");
			
		}
		
		return escola;
	}
	
	public Integer gravar(Edu_matr_candidato cand) throws Exception{
		
		Integer idCandidato = 0; 
		
		open();	
		
		stmt = con.prepareStatement("select max(id_candidato) as id_candidato from edu_matr_candidato ");
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			idCandidato = rs.getInt("id_candidato") + 1;
		} else {
			idCandidato = 1;
		}
		
		String smtp = "insert into edu_matr_candidato (id_responsavel, nome_candidato, mae_candidato, " +
	                  "pai_candidato, nascimento_candidato, alunodarede_candidato, matricularede_candidato, " +
	                  "redeorigem_candidato, estciv_candidato, sexo_candidato, nacionalidade_candidato, email_candidato, " +
	                  "celular_candidato, fixo_candidato, bairro_candidato, irmaonaescola_candidato, nomeirmao_candidato, " + 
	                  "id_escola, id_modensinovagas1, id_modensinovagas2, id_modensinovagas3, " +
	                  "id_modensinovagas, ano_candidato, id_candidato, tipo_candidato, necespec_candidato, cid_candidato, cpf_candidato, datainscricao_candidato) " +
		              "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DATE_FORMAT(sysdate(),'%d/%m/%Y'))";	
	
		
	
		stmt = con.prepareStatement(smtp);
	
	//System.out.println(Biblioteca.LimpaStringCaracterSpecial(escola.getCnpj_escola()));

		stmt.setInt(1, cand.getId_responsavel());
		stmt.setString(2, cand.getNome_candidato());
		stmt.setString(3, cand.getMae_candidato());
		stmt.setString(4, cand.getPai_candidato());
		stmt.setString(5, cand.getNascimento_candidato());
		stmt.setString(6, cand.getAlunodarede_candidato());
		stmt.setString(7, cand.getMatricularede_candidato());
		stmt.setString(8, cand.getRedeorigem_candidato());
		stmt.setString(9, cand.getEstciv_candidato());
		stmt.setString(10, cand.getSexo_candidato());
		stmt.setString(11, cand.getNacionalidade_candidato());
		stmt.setString(12, cand.getEmail_candidato());
		stmt.setString(13, cand.getCelular_candidato());
		stmt.setString(14, cand.getFixo_candidato());
		stmt.setString(15, cand.getBairro_candidato());
		stmt.setString(16, cand.getIrmaonaescola_candidato());
		stmt.setString(17, cand.getNomeirmao_candidato());
		
		if ((cand.getId_escola()==null)||(cand.getId_escola()==0)) {
			stmt.setNull(18, Types.INTEGER);
		} else {
			stmt.setInt(18, cand.getId_escola());
		}
		
		if ((cand.getId_modensinovagas1()==null)||(cand.getId_modensinovagas1()==0)) {
			stmt.setInt(19, 212); // criei uma escola SEMED, uma etapa fake e uma s?rie fake para n?o dar pau nas procuras, nos casos em que nenhuma escola for escolhida
		} else {
			stmt.setInt(19, cand.getId_modensinovagas1());
		}
		
		if ((cand.getId_modensinovagas2()==null)||(cand.getId_modensinovagas2()==0)) {
			stmt.setNull(20, Types.INTEGER);
		} else {
			stmt.setInt(20, cand.getId_modensinovagas2());
		}
		
		if ((cand.getId_modensinovagas3()==null)||(cand.getId_modensinovagas3()==0)) {
			stmt.setNull(21, Types.INTEGER);
		} else {
			stmt.setInt(21, cand.getId_modensinovagas3());
		}
		
		if ((cand.getId_modensinovagas()==null)||(cand.getId_modensinovagas()==0)) {
			stmt.setNull(22, Types.INTEGER);
		} else {
			stmt.setInt(22, cand.getId_modensinovagas());
		}
		
		if ((cand.getAno_candidato()==null)||(cand.getAno_candidato()==0)) {
			stmt.setNull(23, Types.INTEGER);
		} else {
			stmt.setInt(23, cand.getAno_candidato());
		}
		
		stmt.setInt(24, idCandidato);
		stmt.setString(25, cand.getTipo_candidato());
		stmt.setString(26, cand.getNecespec_candidato());
		stmt.setString(27, cand.getCid_candidato());
		stmt.setString(28, cand.getCpf_candidato());

		Integer linhasafetadas = stmt.executeUpdate();
		
		if (linhasafetadas==0) {
			idCandidato = 0;			
		}
		
		return idCandidato;		
	}
	
	public Integer gravarfase2(Edu_matr_candidato cand) throws Exception{
		
		Integer idCandidato = 0; 
		
		open();	
		
		stmt = con.prepareStatement("select max(id_candidato) as id_candidato from edu_matr_candidato ");
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			idCandidato = rs.getInt("id_candidato") + 1;
		} else {
			idCandidato = 1;
		}
		
		String smtp = "insert into edu_matr_candidato (id_responsavel, nome_candidato, mae_candidato, " +
	                  "pai_candidato, nascimento_candidato, alunodarede_candidato, matricularede_candidato, " +
	                  "redeorigem_candidato, estciv_candidato, sexo_candidato, nacionalidade_candidato, email_candidato, " +
	                  "celular_candidato, fixo_candidato, bairro_candidato, irmaonaescola_candidato, nomeirmao_candidato, " + 
	                  "id_escola, id_modensinovagas1, id_modensinovagas2, id_modensinovagas3, " +
	                  "id_modensinovagas, ano_candidato, id_candidato, tipo_candidato, necespec_candidato, cid_candidato, cpf_candidato, datainscricao_candidato) " +
		              "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DATE_FORMAT(sysdate(),'%d/%m/%Y'))";	
	
		
	
		stmt = con.prepareStatement(smtp);
	
	//System.out.println(Biblioteca.LimpaStringCaracterSpecial(escola.getCnpj_escola()));

		stmt.setInt(1, cand.getId_responsavel());
		stmt.setString(2, cand.getNome_candidato());
		stmt.setString(3, cand.getMae_candidato());
		stmt.setString(4, cand.getPai_candidato());
		stmt.setString(5, cand.getNascimento_candidato());
		stmt.setString(6, cand.getAlunodarede_candidato());
		stmt.setString(7, cand.getMatricularede_candidato());
		stmt.setString(8, cand.getRedeorigem_candidato());
		stmt.setString(9, cand.getEstciv_candidato());
		stmt.setString(10, cand.getSexo_candidato());
		stmt.setString(11, cand.getNacionalidade_candidato());
		stmt.setString(12, cand.getEmail_candidato());
		stmt.setString(13, cand.getCelular_candidato());
		stmt.setString(14, cand.getFixo_candidato());
		stmt.setString(15, cand.getBairro_candidato());
		stmt.setString(16, cand.getIrmaonaescola_candidato());
		stmt.setString(17, cand.getNomeirmao_candidato());
		
		if ((cand.getId_escola()==null)||(cand.getId_escola()==0)) {
			stmt.setNull(18, Types.INTEGER);
		} else {
			stmt.setInt(18, cand.getId_escola());
		}
		
		if ((cand.getId_modensinovagas1()==null)||(cand.getId_modensinovagas1()==0)) {
			stmt.setInt(19, 212); // criei uma escola SEMED, uma etapa fake e uma s?rie fake para n?o dar pau nas procuras, nos casos em que nenhuma escola for escolhida
			stmt.setInt(22, 212);
		} else {
			stmt.setInt(19, cand.getId_modensinovagas1());
			stmt.setInt(22, cand.getId_modensinovagas1());
		}
		
		if ((cand.getId_modensinovagas2()==null)||(cand.getId_modensinovagas2()==0)) {
			stmt.setNull(20, Types.INTEGER);
		} else {
			stmt.setInt(20, cand.getId_modensinovagas2());
		}
		
		if ((cand.getId_modensinovagas3()==null)||(cand.getId_modensinovagas3()==0)) {
			stmt.setNull(21, Types.INTEGER);
		} else {
			stmt.setInt(21, cand.getId_modensinovagas3());
		}
		
//		if ((cand.getId_modensinovagas()==null)||(cand.getId_modensinovagas()==0)) {
//			stmt.setNull(22, Types.INTEGER);
//		} else {
//			stmt.setInt(22, cand.getId_modensinovagas());
//		}
		
		if ((cand.getAno_candidato()==null)||(cand.getAno_candidato()==0)) {
			stmt.setNull(23, Types.INTEGER);
		} else {
			stmt.setInt(23, cand.getAno_candidato());
		}
		
		stmt.setInt(24, idCandidato);
		stmt.setString(25, cand.getTipo_candidato());
		stmt.setString(26, cand.getNecespec_candidato());
		stmt.setString(27, cand.getCid_candidato());
		stmt.setString(28, cand.getCpf_candidato());

		Integer linhasafetadas = stmt.executeUpdate();
		
		if (linhasafetadas==0) {
			idCandidato = 0;			
		}
		
		return idCandidato;		
	}

}
