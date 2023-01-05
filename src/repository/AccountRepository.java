package repository;

import java.sql.*;
import java.util.ArrayList;

import module.Account;

public class AccountRepository {

	String jdbcUrl = "jdbc:mysql://localhost:3306/word_scrumble";
	String dbUserName = "root";
	String dbPassword = "root"; 

	public void  save(Account account) { 

		try {
			Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
			String query ="INSERT INTO user_account VALUES(?,?,?,?)";

			PreparedStatement myStmt = con.prepareStatement(query);
			myStmt.setInt(1, 0);  // id is auto-increment
			myStmt.setString(2, account.getFull_name());
			myStmt.setString(3, account.getEmail());
			myStmt.setString(4, account.getUsername()); 
			myStmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    public ArrayList<String> getUsername(){
        ArrayList<String> users = new ArrayList<String>();

		try {
			Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);

			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user_account");

			while(rs.next()) { 
				String username = rs.getString("username"); 
                users.add(username); 
			}

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}


        return users;
    }
}
