/*To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.HistoricoBean;
import Bean.UserBean;
import Utilitario.Conexao;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael, Eloise, Felipe
 */

public class UserDAO {
    
    public Connection conexao;
    public String CadastrarAluno;
    public String DeletarAluno;
    public String pesquisaraluno;
    public String AlterarAluno;
    public String ListarHistorico01;
    public String ListarHistorico02;
    
    public String AlterarHistorico;
    public String DeletarHistorico;
    public String logarUser;
   
    public  UserDAO(){
        Conexao con = new Conexao();
        this.conexao = con.GetConnection();
        
       
        logarUser = "SELECT codadm FROM adm WHERE login = ? AND senha = ?;";
        
        CadastrarAluno = "INSERT INTO alunos(codaluno,nome, sobrenome, datnasc, sexo,"
                        + " idade, pai, mae, cidade, bairro, rua, n, uf, cep, fone, fonefixo)"
                        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"
                        + "INSERT INTO historico(codaluno, nome, sobrenome) VALUES(?,?,?);";
        
         
        DeletarAluno = "DELETE FROM alunos WHERE codaluno = ?;";
       
        
        
        AlterarAluno = "UPDATE alunos SET nome = ?, sobrenome = ?, datnasc = ?,"
                + " sexo = ?, pai = ?, mae = ?,  cidade = ?, bairro = ?, rua = ?,"
                + " n = ?, uf = ?, cep = ?, fone = ?, fonefixo = ?;";
        
        ListarHistorico01 = "SELECT idhistorico FROM aluno WHERE nome = ? sobrenome = ?;";
        
        ListarHistorico02 = "SELECT * FROM historico WHERE idhistorico = ?;";
            
        AlterarHistorico = "UPDATE historico SET port = ?, mat = ?, cien = ?, geo = ?, hist = ?;";
        
        DeletarHistorico = "DELETE FROM historico WHERE idhistorico = ?;";
    }
    
    public boolean logarAdm(UserBean adm){
        try{
            if(conexao != null){ 
                PreparedStatement stm = conexao.prepareStatement(logarUser);
                stm.setString(1, adm.getLogon());
                stm.setString(2, adm.getSenha());
                
                ResultSet ds = stm.executeQuery();
                
                if(ds.next()){
                    return true;
                }
                
                
            }else{
                System.out.print("erro ao logar");  
            }
          
        } catch (Exception ex) {
             System.out.print("erro ao logar, ex" + ex); 
        }
        
        return false;
    }
   
    public boolean CadastrarAluno(UserBean Aluno){
        try
        {
            if(conexao != null)
            {
                PreparedStatement stm = conexao.prepareStatement(CadastrarAluno);
                    stm.setInt(1,   Aluno.getCodmatricula());
                    stm.setString(2,  Aluno.getNome());
                    stm.setString(3,  Aluno.getSobrenome());
                    stm.setString(4,  Aluno.getDatnasc());
                    stm.setString(5,  Aluno.getSexo());
                    stm.setString(6,  Aluno.getIdade());
                    stm.setString(7,  Aluno.getPai());
                    stm.setString(8,  Aluno.getMae());
                    stm.setString(9,  Aluno.getCidade());
                    stm.setString(10,  Aluno.getBairro());
                    stm.setString(11, Aluno.getRua());
                    stm.setString(12, Aluno.getN());
                    stm.setString(13, Aluno.getUf());
                    stm.setString(14, Aluno.getCep());
                    stm.setString(15, Aluno.getFone());
                    stm.setString(16, Aluno.getFonefixo());
                    
                    stm.setInt(17, Aluno.getCodmatricula());
                    stm.setString(18, Aluno.getNome());
                    stm.setString(19, Aluno.getSobrenome());
                    
                    
                stm.execute();
                
                conexao.close(); 
                stm.close();
                
                return true;
            }
            else
            {
              System.out.print("erro ao Cadastrar, "); 
            }
           
        }
        catch(Exception erro)
        {
            System.out.print("erro ao Cadastrar, " + erro); 
        }
        
    return false;
    }
    
    public boolean DeletarAluno(UserBean deletaluno){
    try
        {
            if(conexao != null)
            {
                PreparedStatement stm = conexao.prepareStatement(DeletarAluno);
                stm.setInt(1, deletaluno.getIdSequencia());
               
                stm.execute();
                
                conexao.close(); 
                stm.close();
                
                return true;
            }else{
                System.out.print("erro ao Deletar !! 149 line"); 
            }
           
        }
        catch(Exception erro)
        {
             System.out.print("erro ao Deletar, ex" + erro); 
        }
        
    
    return false;
    }
    
    public List<UserBean> ListarAlunos(){
        List<UserBean> lista = new ArrayList<UserBean>();
        try { 
            pesquisaraluno = "SELECT * FROM alunos;";
            if(conexao != null){
                PreparedStatement stm = conexao.prepareStatement(pesquisaraluno);                
                ResultSet rs = stm.executeQuery();
                
                while(rs.next()) {
                    UserBean aluno = new UserBean();
                    aluno.setIdSequencia(rs.getInt("codaluno"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setSobrenome(rs.getString("sobrenome"));
                    aluno.setDatnasc(rs.getString("datnasc"));
                    aluno.setSexo(rs.getString("sexo"));
                    aluno.setIdade(rs.getString("idade"));
                    aluno.setPai(rs.getString("pai"));
                    aluno.setMae(rs.getString("mae"));
                    aluno.setCidade(rs.getString("cidade"));
                    aluno.setBairro(rs.getString("bairro"));
                    aluno.setRua(rs.getString("rua"));
                    aluno.setN(rs.getString("n"));
                    aluno.setUf(rs.getString("uf"));
                    aluno.setCep(rs.getString("cep"));
                    aluno.setFone(rs.getString("fone"));
                    aluno.setFonefixo(rs.getString("fonefixo"));
                    
                    lista.add(aluno);
                }
                
             conexao.close();
             stm.close();
            
            }else{
                 System.out.print("erro ao Listar"); 
            }
            
        } catch (Exception e) {
             System.out.print("erro ao Listar " + e); 
        }
        return null;
    }

    public boolean AlterarAluno(UserBean alteraAluno){
        try
        {
            if(conexao != null)
            {
                PreparedStatement stm = conexao.prepareStatement(AlterarAluno);
                stm.setString(1, alteraAluno.getNome());
                stm.setString(2, alteraAluno.getSobrenome());
                stm.setString(3, alteraAluno.getDatnasc());
                stm.setString(4, alteraAluno.getSexo());
                stm.setString(5, alteraAluno.getIdade());
                stm.setString(6, alteraAluno.getPai());
                stm.setString(7, alteraAluno.getMae());
                stm.setString(8, alteraAluno.getCidade());
                stm.setString(9, alteraAluno.getBairro());
                stm.setString(10,  alteraAluno.getRua());
                stm.setString(11, alteraAluno.getN());
                stm.setString(12, alteraAluno.getUf());
                stm.setString(13, alteraAluno.getCep());
                stm.setString(14, alteraAluno.getFone());
                stm.setString(15, alteraAluno.getFonefixo());
                
                stm.executeUpdate();
                
                conexao.close(); 
                stm.close();
                
                return true;
            
            }else{
            
                JOptionPane.showMessageDialog(null,"Erro ao deletar user", null,
                     JOptionPane.INFORMATION_MESSAGE);
            }
           
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro De Catch Exception",
                    null, JOptionPane.INFORMATION_MESSAGE);
        }
    return false;
    }

    public boolean GerarHistorico(){
        
    return false;
    }
    
    public boolean DeletarHistorico(){
        
    return false;
    }
    
    
     public List<HistoricoBean> listaHistorico(HistoricoBean historico){
        
         List<HistoricoBean> List = new ArrayList<HistoricoBean>();
        try {   
            if(conexao != null){
                PreparedStatement stm = conexao.prepareStatement(ListarHistorico02);
                stm.setInt(1, historico.getCodhistorico());

                ResultSet rs = stm.executeQuery();

                    while (rs.next()) {
                    HistoricoBean hist = new HistoricoBean();
                        hist.setNotaport(rs.getString("port"));
                        hist.setNotamat(rs.getString("mat"));
                        hist.setNotacien(rs.getString("cien"));
                        hist.setNotageog(rs.getString("geog"));
                        hist.setNotahisto(rs.getString("histo"));
                        
                        List.add(hist);
                    }
                
             conexao.close();
             stm.close();
            
            }else{
                System.out.println("Erro");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    return null;
    }
    
    public boolean Historico(UserBean historico){
         try
        {
            if(conexao != null){
                PreparedStatement stm = conexao.prepareStatement(ListarHistorico01);
                stm.setString(1, historico.getNome());
                stm.setString(2, historico.getSobrenome());
                
                ResultSet t = stm.executeQuery();
                
                HistoricoBean hist = new HistoricoBean();   
                    hist.setCodhistorico(t.getInt("idhistorico"));
                    
                return true;
                
            }else{
                System.out.print("erro ao pegar idhistorico");  
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null," historico ", "erro de implementação",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Erro de exception !! em historico classDAO");
        }
         
      return false;
    }

    public boolean AlterarHistorico(){
        
        
    return false;
    }
     
    public boolean GerarPDF(){
        
    return false;
    }

   
}

