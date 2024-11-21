/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ConexaoBancoDeDados;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author devmat
 */
public class UsuarioController {
    
    // criando metodo de inserir usuario no banco de dados
    
    public boolean cadastrandoUsuario(Usuario user){
        // comando do banco de dados para inserir
        String query = "INSERT INTO Usuario(nome,cpf,senha,email,data_nascimento)" + "VALUES(?,?,?,?,?)";
        
        // connection - conecta-se ao bando de dados
        // PreparedStatement manda o comando sql para executar no BD
        try(Connection connection = ConexaoBancoDeDados.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,user.getNome());
            preparedStatement.setString(2,user.getCpf());
            preparedStatement.setString(3,user.getSenha());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setDate(5,user.getDataNascimento());
            
            
            /*try(resultSet */
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
            
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro ao inserir dados!"+ e);
            return false;
        }// final do try catch
        
    }// fim do metodo cadastrandoUsuario
    
}
