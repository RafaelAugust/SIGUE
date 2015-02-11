/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.HistoricoBean;
import Bean.UserBean;
import Utilitario.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Augusto 
 * 
 */
public class UserDAO {
    
    private Connection conexao;
    public String CadastrarAluno;
    public String DeletarAluno;
    public String ListarAluno;
    public String AlterarAluno;
    public String MostrarHistorico;
    public String AlterarHistorico;
    public String DeletarHistorico;
    
    public  UserDAO(){
        Conexao con = new Conexao();
        this.conexao = con.GetConnection();
        
        CadastrarAluno = "INSERT INTO alunos(nome, sobrenome, datnasc, sexo, idade, pai, mae)"
                        + " VALUES('?','?','?','?','?','?','?');";
        DeletarAluno = "";
        ListarAluno = "";
        AlterarAluno = "";
        MostrarHistorico = "";
        AlterarHistorico = "";
        DeletarHistorico = "";
    }
   
    public boolean CadastrarAluno(UserBean Aluno){
        try
        {
            if(conexao != null)
            {
                PreparedStatement stm = conexao.prepareStatement(CadastrarAluno);
                 stm.setString(1, Aluno.getNome());
                 
                 conexao.close(); 
                 stm.close();
            }else
            {
             JOptionPane.showMessageDialog(null,"Erro Conexao null", null, JOptionPane.INFORMATION_MESSAGE);
            }
           
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Erro De Catch Exception", null, JOptionPane.INFORMATION_MESSAGE);
        }
        
    return false;
    }
    
    public boolean DeletarAluno(){
    
    
    return false;
    }
    
    public List<UserBean> listarAlunos(UserBean user){
        
        
        
    return null;
    }

    public boolean AlterarAluno(){
        
        
    return false;
    }

    public boolean GerarHistorico(){
        
    return false;
    }
    
    public boolean DeletarHistorico(){
    
    
    return false;
    }
    
    public List<HistoricoBean> listaHistorico(HistoricoBean historico){
        
        
        
    return null;
    }

    public boolean AlterarHistorico(){
        
        
    return false;
    }
     
    public boolean GerarPDF(){
        
    return false;
    }
}

