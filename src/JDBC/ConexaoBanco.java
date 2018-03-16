
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * essa classe é reponsável por fazer a conexão por meio de funções do JDBC ao banco de dados.
 */
public class ConexaoBanco {
    /**
     * esse método é responsável por armazenar variáveis usadas para a chamada do banco por meio dos drivers.
     * @return  é um valor booleano que caso seja true retornará uma conexão caso não, uma mensagem de erro.
     */
    
    public Connection getConnection(){
        try {
            String nomeUsuario = "root";
            String senhaUsuario = "3306root";
            String enderecoServidor ="localhost";
            String nomeBanco = "clientecadastro";
            
            return DriverManager.getConnection("jdbc:mysql://"+enderecoServidor+
                    "/"+nomeBanco, nomeUsuario, senhaUsuario);
        } catch (SQLException ex) {
            System.out.println("ERRO, NÃO CONECTADO");
            throw new RuntimeException(ex);
        }
        
    
    }
    
}
