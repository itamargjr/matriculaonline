package persistence;

import entity.Edu_escolas_modensinoanos;

public class Edu_escolas_modensinoanosDao extends Dao {
	
	public Edu_escolas_modensinoanos findAno(String desc) throws Exception{
		
		Edu_escolas_modensinoanos modensinoanos = new Edu_escolas_modensinoanos();
		
		open();
		
		String statement = "select " +
		                   "  a.id_modensinoanos, a.id_modensino, a.descricao_modensinoanos, " +
				           "  b.descricao_modensino " +
				           "from " +
		                   "  edu_escolas_modensinoanos a, edu_escolas_modensino b " +
				           "where " +
		                   "  a.id_modensino = b.id_modensino and " +
		                   "  a.descricao_modensinoanos	= '" + desc + "'";
		
		stmt = con.prepareStatement(statement);
		
		System.out.println(statement);
		
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			modensinoanos = new Edu_escolas_modensinoanos(rs.getInt("id_modensinoanos"), rs.getInt("id_modensino"), 
					                                      rs.getString("descricao_modensinoanos"), rs.getString("descricao_modensino"));
		}
		
		return modensinoanos;
		
	}

}
