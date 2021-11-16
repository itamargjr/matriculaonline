package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Cid10;

public class Cid10Dao extends Dao {
	
	public List<Cid10> findAll() throws Exception
	{
		List<Cid10> lista = new ArrayList<Cid10>();
		
		open();
		
		stmt = con.prepareStatement("select codigo_cid10, descricao_cid10 " +
						   			"from cid10 order by descricao_cid10 ");
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Cid10 c = new Cid10(rs.getString("codigo_cid10"), rs.getString("descricao_cid10"));
			
			lista.add(c);
			
		}
		
		return lista;
	}

}
