package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Main {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DB.getConnection(); // conectando no banco
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * from department");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(resultSet);
			DB.closeStatement(statement);
			DB.closeConnection(); // encerrando acesso ao banco
		}
	}

}
