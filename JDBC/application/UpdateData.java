package application;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import db.DB;
import db.DbException;

public class UpdateData {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// UPDATE com prepareStatement
			connection = DB.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE seller SET Name = ? WHERE (Name = ?)");

			preparedStatement.setString(1, "Arthur");
			preparedStatement.setString(2, "Eva");

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows Affeted: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(preparedStatement);
			DB.closeConnection();
		}
	}
}
