package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammiDAO {

	public boolean isCorrect(String anagramma) {
		String sql = "select p.nome "
				+ "from parola p "
				+ "where nome = ?";
		
		boolean presente = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				presente = true;
			
			st.close();
			rs.close();
			conn.close();
			return presente;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERRORE in AnagrammiDAO");
			return presente;
		}
	}
}
