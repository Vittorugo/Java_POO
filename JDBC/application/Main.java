package application;

import java.sql.Connection;
import db.DB;

public class Main {

	public static void main(String[] args) {
		
		Connection connection = DB.getConnection(); // Conectando  ao bd
		DB.closeConnection(); // desconectando 
	}

}
