/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loja;


import static Model.ConexaoBancoDeDados.getConnection;

import java.sql.Connection;
import view.TelaLogin;


/**
 *
 * @author devmat
 */
public class Loja {

    public static void main(String[] args) {
        // criando um objeto da classe TelaDeLogin
         TelaLogin telalogin = new TelaLogin();
        // deixando a tela visivel
         telalogin.setVisible(true);
        Connection conexao = getConnection();
        if(conexao!=null){
            System.out.println("Conexão deu certo !");
        }else{
            System.out.println("Conexão deu errado !");
        }

        
    }
}
