/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafe;
import java.sql.*;

/**
 *
 * @author kayaya
 */
public class DB_connect {
    private Connection conn;
    private Statement stm;
    private ResultSet res;
    
    public DB_connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:derby://localhost:1527/gamecafe_db";
            String db_username = "gamecafe";
            String db_password = "ddjt";
            conn = DriverManager.getConnection(url,db_username,db_password);
            stm = conn.createStatement();
            System.out.println("Connected to database Successfully!");
            
        }catch(Exception e){
            System.out.println("Error message: "+e);
        }
    }
    
    public void getData(){
        try{
            String query = "SELECT * FROM membership";
            res = stm.executeQuery(query);
            System.out.println("Database data");
            while(res.next()){
                String nickname = res.getString("nickname");
                String age = res.getString("age");
                System.out.println("Name: "+nickname + " Age: "+age);
            }
            
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    
    public void insertData(){
        try{
            String new_nickname = "cielobear";
            int new_age = 20;
            String query = "INSERT INTO membership(id, nickname, age) VALUES (?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,2);
            st.setString(2, new_nickname);
            st.setInt(3, new_age);
            st.executeUpdate();
            //System.out.println("Row inserted sucessfully!");
   
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    
}
