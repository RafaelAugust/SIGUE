/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class Conexao {
    private final String Drive = "org.postgresql.Driver";
    private  final String url = "jdbc:postgresql://localhost:5432/siguedb";
    private final String login ="user_rafael";
    private final String senha = "123456";
    private Connection con;
    
    public  Conexao(){
        try {
            Class.forName(Drive);
        } catch (Exception e) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
   }
    public Connection GetConnection(){
        try {
            con = DriverManager.getConnection(url, login, senha);
        } catch (Exception e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }
    public void desconect(){
        try {
         con.close();
         con = null;
        } catch (Exception e) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
