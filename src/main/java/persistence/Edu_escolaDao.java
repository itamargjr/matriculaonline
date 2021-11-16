package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Edu_escola;
import util.Biblioteca;

public class Edu_escolaDao extends Dao {
	
	public List<Edu_escola> findAll(Edu_escola escola) throws Exception{
		List<Edu_escola> lista =  new ArrayList<Edu_escola>();
		
		open();
		
		String statement = "select a.id_escola, a.nome_escola, a.telefone_escola, " +
		                   "a.id_funcescola, a.cnpj_escola, a.inep_escola, a.email_escola, " +
						   "a.vagaspcd_escola, a.vagasgeral_escola, a.bairro_escola, " +
		                   "b.nome_funcescola " +
						   "from edu_escolas a, edu_func_escola b " +
		                   "where a.id_funcescola = b.id_funcescola ";
		
		if ((escola.getId_escola()!=null)&&(escola.getId_escola()!=0)) {
			statement = statement + " and id_escola = '" + escola.getId_escola() + "'";
		}
		
		if ((escola.getNome_escola()!=null)&&(!escola.getNome_escola().equalsIgnoreCase(""))) {
			statement = statement + " and nome_escola like '%" +escola.getNome_escola() + "%'";
		}
		
		if ((escola.getBairro_escola()!=null)&&(!escola.getBairro_escola().equalsIgnoreCase(""))) {
			statement = statement + " and bairro_escola like '%" + escola.getBairro_escola() + "%'";
		}
		
		if ((escola.getId_funcescola()!=null)&&(escola.getId_funcescola()!=0)) {
			statement = statement + " and a.id_funcescola = '" + escola.getId_funcescola() + "'";
		}
		
		stmt = con.prepareStatement(statement + " order by nome_escola");
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Edu_escola e = new Edu_escola(rs.getInt("id_escola"), rs.getString("nome_escola"), rs.getString("telefone_escola"),
					                      rs.getInt("id_funcescola"), rs.getString("cnpj_escola"), rs.getString("inep_escola"),
					                      rs.getString("email_escola"), rs.getInt("vagaspcd_escola"), rs.getInt("vagasgeral_escola"),
					                      rs.getString("bairro_escola"), rs.getString("nome_funcescola"));
			lista.add(e);
		}
		
		close();
		
		return lista;
	}
	
	public Integer retornaId(String nome) throws Exception{
		Integer IdEscola = 0;
		
		open();
		
		stmt = con.prepareStatement("select id_escola from edu_escolas where nome_escola = '" + nome + "'");
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			IdEscola = rs.getInt("id_escola");
		}
		
		close();
		
		return IdEscola;
	}
	

	
	public String retornaNome(Integer Id) throws Exception{
		String nome = "";
		
		open();
		
		stmt = con.prepareStatement("select nome_escola from edu_escolas where id_escola = " + Id);
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			nome = rs.getString("nome_escola");
		}
		
		close();
		
		return nome;
	}
	
	public List<Edu_escola> listar() throws Exception{
		List<Edu_escola> lista =  new ArrayList<Edu_escola>();
		
		open();
		
		String statement = "select a.id_escola, a.nome_escola, a.telefone_escola, " +
		                   "a.id_funcescola, a.cnpj_escola, a.inep_escola, a.email_escola, " +
						   "a.vagaspcd_escola, a.vagasgeral_escola, a.bairro_escola, " +
		                   "b.nome_funcescola " +
						   "from edu_escolas a, edu_func_escola b " +
		                   "where a.id_funcescola = b.id_funcescola ";
		
		stmt = con.prepareStatement(statement + " order by nome_escola");
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Edu_escola e = new Edu_escola(rs.getInt("id_escola"), rs.getString("nome_escola"), rs.getString("telefone_escola"),
					                      rs.getInt("id_funcescola"), rs.getString("cnpj_escola"), rs.getString("inep_escola"),
					                      rs.getString("email_escola"), rs.getInt("vagaspcd_escola"), rs.getInt("vagasgeral_escola"),
					                      rs.getString("bairro_escola"), rs.getString("nome_funcescola"));
			lista.add(e);
		}
		
		close();
		
		return lista;
	}
	
	public Integer gravar(Edu_escola escola) throws Exception {
		
		final Integer linhasafetadas; 
			
		String smtp = "insert into edu_escolas (id_escola, nome_escola, telefone_escola, id_funcescola, " +
		              "cnpj_escola, inep_escola, email_escola, vagaspcd_escola, vagasgeral_escola, bairro_escola) " +
			          "values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		
		open();	
		
		stmt = con.prepareStatement(smtp);
		
		//System.out.println(Biblioteca.LimpaStringCaracterSpecial(escola.getCnpj_escola()));

		stmt.setString(1, escola.getNome_escola());
		stmt.setString(2, Biblioteca.LimpaStringCaracterSpecial(escola.getTelefone_escola()));
		stmt.setInt(3, escola.getId_funcescola());
		stmt.setString(4, Biblioteca.LimpaStringCaracterSpecial(escola.getCnpj_escola()));
		stmt.setString(5, escola.getInep_escola());
		stmt.setString(6, escola.getEmail_escola());
		stmt.setInt(7, escola.getVagaspcd_escola());
		stmt.setInt(8, escola.getVagasgeral_escola());
		stmt.setString(9, escola.getBairro_escola());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
	
	public Integer alterar(Edu_escola escola) throws Exception {
		
		final Integer linhasafetadas; 
	
		String smtp = "update edu_escolas set nome_escola = ?, telefone_escola = ?, id_funcescola = ?, " +
		              "cnpj_escola = ?, inep_escola = ?, email_escola = ?, vagaspcd_escola = ?, " +
				      "vagasgeral_escola = ?, bairro_escola = ? " +
		              "where id_escola = ?";	

		open();	
		
		stmt = con.prepareStatement(smtp);
		
		
		stmt.setString(1, escola.getNome_escola());
		stmt.setString(2, escola.getTelefone_escola());
		stmt.setInt(3, escola.getId_funcescola());
		stmt.setString(4, escola.getCnpj_escola());
		stmt.setString(5, escola.getInep_escola());
		stmt.setString(6, escola.getEmail_escola());
		stmt.setInt(7, escola.getVagaspcd_escola());
		stmt.setInt(8, escola.getVagasgeral_escola());
		stmt.setString(9, escola.getBairro_escola());
		stmt.setInt(10, escola.getId_escola());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
	
	public Integer excluir(Edu_escola escola) throws Exception {
		
		final Integer linhasafetadas; 
		
		String smtp = "DELETE FROM edu_escolas WHERE id_escola = ?";	
		
		open();	
		
		stmt = con.prepareStatement(smtp);
		
		stmt.setInt(1, escola.getId_escola());
		
		linhasafetadas = stmt.executeUpdate();
		
		smtp = "DELETE FROM end_endereco WHERE identidade_endereco = " + escola.getId_escola() + " and tipo_endereco = 'E'";	
		
		stmt = con.prepareStatement(smtp);
		
		stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}

}
