package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnect {

	public static void main(String[] args) throws Exception {

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
			PreparedStatement statement = con.prepareStatement("select * from aaa");
			ResultSet result = statement.executeQuery();
			while(result.next()){
				System.out.println(result.getString(1) + " " + result.getString(2));
			}
	}

}