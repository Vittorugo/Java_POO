package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class InsertData {

	public static void main(String[] args) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {

			connection = DB.getConnection(); // conectando ao banco

			preparedStatement = connection.prepareStatement("INSERT INTO "
					+ "seller (Name, Email, BirthDate, BaseSalary, departmentId) " + "values (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, "Joao");
			preparedStatement.setString(2, "joao@java.com");
			preparedStatement.setDate(3, new java.sql.Date(dateFormat.parse("28/02/1998").getTime()));
			preparedStatement.setDouble(4, 1350.95);
			preparedStatement.setInt(5, 2);

			int affectedRows = preparedStatement.executeUpdate(); // Inserindo os dados na tabela
			DB.closeStatement(preparedStatement);

			if (affectedRows > 0) {

				System.out.println("Total de linhas inseridas: " + affectedRows);

				// ResultSet rs = preparedStatement.getGeneratedKeys();

			} else {
				System.out.println("Nenhuma linha afetada!");
			}

			preparedStatement = connection.prepareStatement("SELECT * FROM seller");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + resultSet.getString(2));
			}

		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(resultSet);
			DB.closeStatement(statement);
			DB.closeStatement(preparedStatement);
			DB.closeConnection();
		}
	}

}
