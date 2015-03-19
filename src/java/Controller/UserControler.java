/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.UserBean;
import DAO.UserDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Rafael, Eloise, Felipe
 */

@ManagedBean
public class UserControler implements Serializable{

    private UserBean alunoB;    
    private DataModel listarAlunos;

    public  UserControler(){
        alunoB = new UserBean();
    }

    public UserBean getAlunoB() {
        return alunoB;
    }

    public void setAlunoB(UserBean alunoB){
        this.alunoB = alunoB;
    }
    
     public DataModel getListarAlunos(){
        UserDAO lis = new UserDAO();
        listarAlunos = new ListDataModel(lis.ListarAlunos());
        return listarAlunos;
    }

    public void setListarAlunos(DataModel listarAlunos) {
        this.listarAlunos = listarAlunos;
    }
    
    
    public void selecionarContato(){
        alunoB = (UserBean) listarAlunos.getRowData();
    }
    
   //metodos logar , salvar, alterar e excluir alunos    
   public String logarAdm(){
        UserDAO cod = new UserDAO();
        boolean tes = cod.logarAdm(alunoB);
       if(tes != false){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                   "Logado com SUCESSO", ""));
           return "index";
       }else{
        return "LoginPage";
       }
   }
   
   public String cadastrarAluno(){
       UserDAO cod = new UserDAO();
       if(cod.CadastrarAluno(alunoB)){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                   "Cadastrado com SUCESSO", ""));
           return "ListarAlunos";
       }
       return "Erro"; 
   }

   
   public String editarAluno(){
       UserDAO cod = new UserDAO();
       if(cod.AlterarAluno(alunoB)){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                   "Alteraco com SUCESSO", ""));
           return "ListarAlunos";
       }
      
       return "Erro"; 
   }

   
   public String excluirAluno(){
       UserDAO cod = new UserDAO();
       if(cod.DeletarAluno(alunoB)){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                   "Deletado com SUCESSO", ""));
           return "ListarAlunos";
       }
      
       return "Erro"; 
   }
   //fim
}


