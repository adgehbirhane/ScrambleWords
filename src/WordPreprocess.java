import java.io.File;
import java.util.ArrayList;
import java.util.Scanner; 
import java.sql.*; 

import models.Account;

public class WordPreprocess {

    
    private static void analyze_words(ArrayList<String> words) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/word_scrumble";
        String dbUserName = "root";
        String dbPassword = "root";

        int total = 0;
        ArrayList<String> longest_words = new ArrayList<>();
        int[] counts = new int[24]; // longest word has 24 letters

        for (String word: words) {
            if (word.length() == 24) {
                longest_words.add(word);
            }
            total++;

//            if(word.length()>=5 && word.length()<=7){
//                try{
//                    Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
//                    String query = "INSERT INTO words VALUES(?,?,?);";
//
//                    PreparedStatement myStmt = con.prepareStatement(query);
//                    myStmt.setInt(1, 0);  // id is auto-increment
//                    myStmt.setString(2, word);
//                    myStmt.setInt(3, 1);
//                    myStmt.executeUpdate();
//                    con.close();
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//            if(word.length()>=8 && word.length()<=10){
//                try{
//                    Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
//                    String query = "INSERT INTO words VALUES(?,?,?);";
//
//                    PreparedStatement myStmt = con.prepareStatement(query);
//                    myStmt.setInt(1, 0);  // id is auto-increment
//                    myStmt.setString(2, word);
//                    myStmt.setInt(3, 2);
//                    myStmt.executeUpdate();
//                    con.close();
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//            if(word.length()>=11 && word.length()<=14){
//                try{
//                    Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
//                    String query = "INSERT INTO words VALUES(?,?,?);";
//
//                    PreparedStatement myStmt = con.prepareStatement(query);
//                    myStmt.setInt(1, 0);  // id is auto-increment
//                    myStmt.setString(2, word);
//                    myStmt.setInt(3, 3);
//                    myStmt.executeUpdate();
//                    con.close();
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//            if(word.length()>=15 && word.length()<=19){
//                try{
//                    Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
//                    String query = "INSERT INTO words VALUES(?,?,?);";
//
//                    PreparedStatement myStmt = con.prepareStatement(query);
//                    myStmt.setInt(1, 0);  // id is auto-increment
//                    myStmt.setString(2, word);
//                    myStmt.setInt(3, 4);
//                    myStmt.executeUpdate();
//                    con.close();
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }

//            if(word.length()>=20 && word.length()<=24){
//                try{
//                    Connection con = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
//                    String query = "INSERT INTO words VALUES(?,?,?);";
//
//                    PreparedStatement myStmt = con.prepareStatement(query);
//                    myStmt.setInt(1, 0);  // id is auto-increment
//                    myStmt.setString(2, word);
//                    myStmt.setInt(3, 5);
//                    myStmt.executeUpdate();
//                    con.close();
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
            

            counts[word.length() - 1]++;
        }

        System.out.println("Total number of words: " + total);

        int i = 1;
        int processedWord = 0;
        for (int count : counts) {
            System.out.println("Words with length " + i + " = " + count + " ");
            processedWord += count;
            i++;
        }
        System.out.println("\n---The processed words: "+processedWord);
        System.out.println("\n---The longest words---");
        for (String longest : longest_words) {
            System.out.println(longest);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> at_least_five = new ArrayList<>();
        String word;

        try {
            File f = new File("asset/word_list.txt");
            Scanner input = new Scanner(f);

            while (input.hasNextLine()) {
                word = input.nextLine();
                if (word.length() >= 5) {
                    at_least_five.add(word);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        analyze_words(at_least_five);
    }
}
