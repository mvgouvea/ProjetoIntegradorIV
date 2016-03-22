package br.com.controlepatrimonial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	private final static String DRIVER = "org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost:5432/db_contabil";
	private final static String USER = "postgres";
	private final static String PASSWORD = "root";
	
	public static Connection getConexao(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch (Exception e){
			System.err.println("Erro na conexão");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void fechar(Connection con, Statement st){
		fecharConexao(con, st, null);
	}
	public static void fechar(Connection con, Statement st,
			ResultSet result){
		fecharConexao(con, st, result);
	}
	
	private static void fecharConexao(Connection con, Statement st,
			ResultSet result){
		try {
			if (result != null) result.close();
			if (st != null) st.close();
			if (con != null)con.close();
		} catch(Exception ex){
			
		}
	}
	
}
