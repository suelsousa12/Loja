/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author devmat
 */
public class ConexaoBancoDeDados {
    
    // conexao com sql server
    /* criando uma variavel para capturar o endereco de conexao com o banco de dados
    JDBC: SQLSERVER - é o drive
    LOCALHOST - servidor 1433 - porta utilizada
    DATABASENAME= nome do seu banco de dados
    INTEGRATEDSECURITY E TRUSTSERVERCERTIFICATE É PARA LOGAR&*/
    
    private static final String url=
            "jdbc:sqlserver://localhost:1433;databaseName=loja;"
            + "integratedSecurity=true;"
            + "trustServerCertificate=true";
    public static Connection getConnection(){
        // criando um objeto do tipo Connection
        Connection conection = null;
        try{ // se não der erro nenhum
            //  estabeleça a conexão com o banco de dados
            conection = DriverManager.getConnection(url);
            System.out.println("Conexão bem sucedida !");
        }catch(SQLException e){ // caso dê algum erro
            System.out.println("Erro de conexão" + e);
        } // final do try catch
        return conection;
    }// final do getConnection     
}// final do public class
