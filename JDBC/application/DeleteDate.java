package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class DeleteDate {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DB.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM seller WHERE  (DepartmentId = ?)");
			preparedStatement.setInt(1, 2);
			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println(rowsAffected);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(preparedStatement);
			DB.closeConnection();
		}
	}

}
