package Controller;

import Model.ConexaoBancoDeDados;
import Model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    
   public Usuario authenticate(String email, String senha) {
        String query = "SELECT * FROM Usuario WHERE email = ? AND senha = ?";
        try (Connection connection = ConexaoBancoDeDados.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
 
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
               if(resultSet.next()){
                
                // captura do banco de dados do usuario
                int id = resultSet.getInt("id_cliente");
                String nome = resultSet.getString("nome");
                String senhusuario = resultSet.getString("senha");
                String emailusuario = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                Date data = resultSet.getDate("data_nascimento");
                // mandando um usuário para tela de login
                return new Usuario(emailusuario, senhusuario, data, cpf, nome);
            }// fim d if
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar o usuário: " + e.getMessage());
            return null;
        }
        return null;
    }
}
