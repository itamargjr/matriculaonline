package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Edu_escolas_modensinovagas;

public class Edu_escolas_modensinovagasDao extends Dao {
	
	public List<Edu_escolas_modensinovagas> findAll(Edu_escolas_modensinovagas vagas) throws Exception{
		List<Edu_escolas_modensinovagas> lista =  new ArrayList<Edu_escolas_modensinovagas>();
		
		open();
		
		String statement = "select " +
		                   "  a.id_modensinovagas, a.ano_modensinovagas, a.id_escola, a.id_modensinoanos, a.vagas_modensinovagas, " +
		                   "  b.id_modensino, b.descricao_modensinoanos, " +
		                   "  c.descricao_modensino, " +
		                   "  d.nome_escola " +
						   "from " +
		                   "  edu_escolas_modensinovagas a, edu_escolas_modensinoanos b, " +
		                   "  edu_escolas_modensino c, edu_escolas d " +
		                   "where " +
		                   "  a.id_modensinoanos = b.id_modensinoanos and " +
		                   "  b.id_modensino = c.id_modensino and " +
		                   "  a.id_escola = d.id_escola ";
		
		if ((vagas.getAno_modensinovagas()!=null)&&(vagas.getAno_modensinovagas()!=0)) {
			statement = statement + " and a.ano_modensinovagas = '" + vagas.getAno_modensinovagas() + "'";
		}
		
		if ((vagas.getId_escola()!=null)&&(vagas.getId_escola()!=0)) {
			statement = statement + " and a.id_escola = '" + vagas.getId_escola() + "'";
		}
		
		if ((vagas.getNome_escola()!=null)&&(!vagas.getNome_escola().equalsIgnoreCase(""))) {
			statement = statement + " and d.nome_escola like '%" +vagas.getNome_escola() + "%'";
		}
		
		if ((vagas.getId_modensinoanos()!=null)&&(vagas.getId_modensinoanos()!=0)) {
			statement = statement + " and a.id_modensinoanos = '" + vagas.getId_modensinoanos() + "'";
		}
		
		if ((vagas.getId_modensino()!=null)&&(vagas.getId_modensino()!=0)) {
			
			if (vagas.getId_modensino()>3) { // gambiarra para pegar o EJA anos iniciais e finais juntos
				statement = statement + " and b.id_modensino >= '" + vagas.getId_modensino() + "'";
			} else {
			
				statement = statement + " and b.id_modensino = '" + vagas.getId_modensino() + "'";
			}
		}
		
		if ((vagas.getDescricao_modensinoanos()!=null)&&(!vagas.getDescricao_modensinoanos().equalsIgnoreCase(""))) {
			statement = statement + " and b.descricao_modensinoanos = '" + vagas.getDescricao_modensinoanos() + "'";
		}
		
		if ((vagas.getDescricao_modensino()!=null)&&(!vagas.getDescricao_modensino().equalsIgnoreCase(""))) {
			statement = statement + " and c.descricao_modensino = '" + vagas.getDescricao_modensino() + "'";
		}
		
		stmt = con.prepareStatement(statement + " order by a.ano_modensinovagas, c.descricao_modensino, b.descricao_modensinoanos, d.nome_escola");
		
		//System.out.println(statement);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Edu_escolas_modensinovagas v = new Edu_escolas_modensinovagas(rs.getInt("id_modensinovagas"), rs.getInt("ano_modensinovagas"), 
					                                                      rs.getInt("id_escola"), rs.getInt("id_modensinoanos"), rs.getInt("vagas_modensinovagas"),
					                                                      rs.getString("nome_escola"), rs.getString("descricao_modensinoanos"), 
					                                                      rs.getInt("id_modensino"), rs.getString("descricao_modensino"));
			lista.add(v);
		}
		
		
		return lista;
	}

}
