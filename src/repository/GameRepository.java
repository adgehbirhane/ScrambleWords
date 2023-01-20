package repository;

import java.sql.*;
import java.util.ArrayList;

public class GameRepository {

    String jdbcUrl = "jdbc:mysql://localhost:3306/word_scrumble";
    String dbUserName = "root";
    String dbPassword = "root"; 
    
    public ArrayList<String> getWords(int level){

        ArrayList<String> words = new ArrayList<String>(); 
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
            String query = "SELECT * FROM words WHERE level = " + Integer.toString(level);
            ResultSet rs = con.createStatement().executeQuery(query);

            while (rs.next()) {
                String word = rs.getString("word");
                words.add(word);
            }
            
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return words;
    }  
}
