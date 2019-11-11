package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Transation {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DB.getConnection();
			statement  = connection.createStatement();
			
			connection.setAutoCommit(false); // N�o comitar as altera��es no banco automaticamente.
			
			int rowsAffected = statement.executeUpdate("UPDATE seller SET BaseSalary = (BaseSalary + BaseSalary * 0.20) WHERE DepartmentId = 1"); // aumento de sal�rio para funcionarios do departamento 1.
			
			int rowsAffected2 = statement.executeUpdate("UPDATE seller SET Name = 'Joao' WHERE Name= 'Donald Blue'");
			//int rowsAffected2 = statement.executeUpdate("UPDATE seller SET Name = Joao WHERE Name= Donald Blue");  // Fake error! Descomentar para testar aplica��o!
			
			connection.commit(); // Comitar altera��es caso n�o ocorra erros no programa.
			
			System.out.println("UPDATE SUCCESS!");
			
		} catch (SQLException e) {
			try {
				connection.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			}
			catch (SQLException e2) {
				throw new DbException("Fail trying rollback! Caused by: " + e.getMessage());
			}
		}finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}

	}

}
