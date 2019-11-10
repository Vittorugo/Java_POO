package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection connection = null;
	
	// Conectar ao bd
	public static Connection getConnection() {
		
		if(connection == null) {
			try {
				Properties properties = loaProperties();
				String url = properties.getProperty("dburl");
				connection = DriverManager.getConnection(url, properties);
				
				System.out.println("Successfull connection!");
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return connection;
	}
	
	// Desconectar bd
	public static void closeConnection() {
		
		if(connection != null) {
			try {
				connection.close();	
				System.out.println("Disconnected databse!");
			} 
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Carregando as propriedade para conexao com o banco
	private static Properties loaProperties() {
		
		try(FileInputStream fs = new FileInputStream("C:\\Users\\hugo\\eclipse-workspace\\curso_java\\JDBC\\db.properties")){
			Properties properties = new Properties();
			properties.load(fs);
		
			return properties;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	// Finalizando o statement
	public static void closeStatement(Statement st) {
		if( st != null) {
			try {
				st.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Finalizando o resultSet
	public static void closeResultSet(ResultSet rs) {
		if( rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
