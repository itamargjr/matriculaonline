package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Edu_func_escola;
import util.Biblioteca;

public class Edu_func_escolaDao extends Dao {
	
	public List<Edu_func_escola> findAll(Edu_func_escola func) throws Exception{
		List<Edu_func_escola> lista =  new ArrayList<Edu_func_escola>();
		
		open();
		
		String statement = "select id_funcescola, nome_funcescola, cpf_funcescola, email_funcescola, " +
						   "celular_funcescola, matriculapref_funcescola, tipo_funcescola " +
                           "from edu_func_escola  where 1 = 1 ";
		
		if ((func.getId_funcescola()!=null)&&(func.getId_funcescola()!=0)) {
			statement = statement + " and id_funcescola = '" + func.getId_funcescola() + "'";
		}
		
		if ((func.getNome_funcescola()!=null)&&(!func.getNome_funcescola().equalsIgnoreCase(""))) {
			statement = statement + " and nome_escola like '%" +func.getNome_funcescola() + "%'";
		}
		
		if ((func.getEmail_funcescola()!=null)&&(!func.getEmail_funcescola().equalsIgnoreCase(""))) {
			statement = statement + " and email_funcescola like '%" + func.getEmail_funcescola() + "%'";
		}

		if ((func.getTipo_funcescola()!=null)&&(!func.getTipo_funcescola().equalsIgnoreCase(""))) {
			statement = statement + " and tipo_funcescola = '" + func.getTipo_funcescola() + "'";
		}
		
		stmt = con.prepareStatement(statement + " order by nome_funcescola");
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Edu_func_escola e = new Edu_func_escola(rs.getInt("id_funcescola"), rs.getString("nome_funcescola"), 
					                                rs.getString("cpf_funcescola"), rs.getString("email_funcescola"), 
					                                rs.getString("celular_funcescola"), rs.getString("matriculapref_funcescola"),
					                                rs.getString("tipo_funcescola"));
			lista.add(e);
		}
		
		close();
		
		return lista;
	}
	
	public List<Edu_func_escola> findAllPorTipo(String tipo) throws Exception{
		List<Edu_func_escola> lista =  new ArrayList<Edu_func_escola>();
		
		open();
		
		String statement = "select id_funcescola, nome_funcescola, cpf_funcescola, email_funcescola, " +
						   "celular_funcescola, matriculapref_funcescola, tipo_funcescola " +
                           "from edu_func_escola where tipo_funcescola = '" + tipo + "'" +
						   " order by nome_funcescola";
		
		stmt = con.prepareStatement(statement);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			Edu_func_escola e = new Edu_func_escola(rs.getInt("id_funcescola"), rs.getString("nome_funcescola"), 
					                                rs.getString("cpf_funcescola"), rs.getString("email_funcescola"), 
					                                rs.getString("celular_funcescola"), rs.getString("matriculapref_funcescola"),
					                                rs.getString("tipo_funcescola"));
			lista.add(e);
		}
		
		close();
		
		return lista;
	}
	
	public Integer gravar(Edu_func_escola func) throws Exception {
		
		final Integer linhasafetadas; 
			
		String smtp = "insert into edu_func_escola (id_funcescola, nome_funcescola, cpf_funcescola, email_funcescola, " +
		              "celular_funcescola, matriculapref_funcescola, tipo_funcescola) " +
			          "values (null, ?, ?, ?, ?, ?, ?)";	
		
		open();	
		
		//System.out.println(Biblioteca.LimpaStringCaracterSpecial(func.getCpf_funcescola()));
		
		stmt = con.prepareStatement(smtp);

		stmt.setString(1, func.getNome_funcescola());
		stmt.setString(2, Biblioteca.LimpaStringCaracterSpecial(func.getCpf_funcescola()));
		stmt.setString(3, func.getEmail_funcescola());
		stmt.setString(4, Biblioteca.LimpaStringCaracterSpecial(func.getCelular_funcescola()));
		stmt.setString(5, func.getMatriculapref_funcescola());
		stmt.setString(6, func.getTipo_funcescola());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
	
	public Integer alterar(Edu_func_escola func) throws Exception {
		
		final Integer linhasafetadas; 
	
		String smtp = "update edu_func_escola set nome_funcescola = ?, " +
		              "cpf_funcescola = ?, email_funcescola = ?, " +
				      "celular_funcescola = ?, matriculapref_funcescola = ?, " +
		              "tipo_funcescola = ? " +
		              "where id_funcescola = ?";	

		open();	
		
		stmt = con.prepareStatement(smtp);
		
		
		stmt.setString(1, func.getNome_funcescola());
		stmt.setString(2, Biblioteca.LimpaStringCaracterSpecial(func.getCpf_funcescola()));
		stmt.setString(3, func.getEmail_funcescola());
		stmt.setString(4, Biblioteca.LimpaStringCaracterSpecial(func.getCelular_funcescola()));
		stmt.setString(5, func.getMatriculapref_funcescola());
		stmt.setString(6, func.getTipo_funcescola());
		stmt.setInt(7, func.getId_funcescola());
		
		linhasafetadas = stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
	
	public Integer excluir(Edu_func_escola func) throws Exception {
		
		final Integer linhasafetadas; 
		
		String smtp = "DELETE FROM edu_func_escola WHERE id_funcescola = ?";	
		
		open();	
		
		stmt = con.prepareStatement(smtp);
		
		stmt.setInt(1, func.getId_funcescola());
		
		linhasafetadas = stmt.executeUpdate();
		
		smtp = "DELETE FROM end_endereco WHERE identidade_endereco = " + func.getId_funcescola() + " and tipo_endereco = '" + func.getTipo_funcescola() + "'";	
		
		stmt = con.prepareStatement(smtp);
		
		stmt.executeUpdate();
		
		close();
		
		return linhasafetadas;
	
	}
}
