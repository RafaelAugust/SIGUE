/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rafael, Eloise, Felipe
 */

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{   
   
    //AdmBean
    private int codadm;
    private String logon;
    private String senha;
    
    //AlunoBean 
    private int codmatricula;
    private int idSequencia;
    private String nome;
    private String sobrenome;
    private String datnasc;
    private String idade;
    private String sexo;
    private String mae;
    private String pai;
    private String fone;
    private String fonefixo;
    private String cidade;
    private String rua;
    private String bairro;
    private String n;
    private String uf;
    private String cep;
   
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
   
    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFonefixo() {
        return fonefixo;
    }

    public void setFonefixo(String fonefixo) {
        this.fonefixo = fonefixo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    public int getCodadm() {
        return codadm;
    }

    public void setCodadm(int codadm) {
        this.codadm = codadm;
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String logon) {
        this.logon = logon;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getIdSequencia() {
        return idSequencia;
    }

    public void setIdSequencia(int idSequencia) {
        this.idSequencia = idSequencia;
    }

    public int getCodmatricula(){
        int codmatricula = 0;
        int test = 0;
        
        if(test >= codmatricula){
                this.codmatricula = Integer.parseInt(datnasc) + Integer.parseInt(n) + test;
                test++;
                return this.codmatricula;
            }
        return codmatricula;
    }

    public void setCodmatricula(int codmatricula) {
        this.codmatricula = codmatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDatnasc() {
        return datnasc;
    }

    public void setDatnasc(String datnasc) {
        this.datnasc = datnasc;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }
    
}
