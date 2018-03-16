
package DAO;

import JDBC.ConexaoBanco;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * essa classe é responsável por criar um objeto de acesso a dados no caso o cliente que acessa dados da tabela cliente no banco.
 */

public class ClienteDAO {
    
    private Connection con;
    
    /**
     * esse construtor instância uma nova conexão.
     */
    public ClienteDAO(){
        this.con = new ConexaoBanco().getConnection();
    
    }
    
    /**
     * esse método é responsável por adicionar valores no banco.
     * possui variáveis que serão preparadas e posteriormente setadas nas tabelas do banco.
     * @param p é um objeto de Cliente.
     * @return  retorna um valor booleano caso esse seja verdadeiro os dados serão adicionados caso não, retornará falso.
     */
    public boolean adiciona(Cliente p){
        
        try {
            String sql = "INSERT INTO cliente(nome,numCompras, debito) VALUES (?,?,?);";
            PreparedStatement stnt =  con.prepareStatement(sql);
            
            stnt.setString(1, p.getNome());
            stnt.setString(2, p.getNumCompras());
            stnt.setString(3, p.getDebito());
            stnt.execute();

            return true;
         
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
        
    }
    
    /**
     * esse método é responsável por atualizar os dados da tabela.
     * possui variáveis que serão preparadas e posteriormente setadas nas tabelas do banco.
     * @param p é um objeto do tipo Cliente.
     * @return retorna um valor booleano caso seja verdadeiro os dados serão atualizados no banco caso não retornará falso.
     */
    
        public boolean update(Cliente p){
        
        try {
            String sql = "UPDATE cliente SET nome = ?,numCompras = ?, debito= ? WHERE id = ?;";
            PreparedStatement stnt =  con.prepareStatement(sql);
            
            stnt.setString(1, p.getNome());
            stnt.setString(2, p.getNumCompras());
            stnt.setString(3, p.getDebito());
            stnt.setLong(4, p.getId());
            stnt.execute();
            stnt.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
        
    }
        
        /**
         * esse método é responsável por remover os dados da tabela.
         * possui variáveis que serão preparadas e posteriormente setadas nas tabelas do banco.
         * @param p p é um objeto do tipo Cliente.
         * @return retorna um valor booleano caso seja verdadeiro os dados serão deletados no banco caso não retornará falso.
         */
        public boolean delete(Cliente p){
        
        try {
            String sql = "DELETE FROM cliente WHERE id =?;";
            PreparedStatement stnt =  con.prepareStatement(sql);
            stnt.setLong(1, p.getId());
            stnt.execute();
            stnt.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
        
    }
        
        /**
         * esse método é responsável por listar todas as tabelas com seus respectivos dados.
         * nesse método uma lista de clientes é gerada e apartir do preparamento de dados esses clientes serão adicionados nessa lista
         * para o fim de listagem de seus dados através de uma tableView.
         * @return 
         */
        
        
        
    public List<Cliente> getList(){
            List<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM cliente";
        try {
            PreparedStatement stnt = con.prepareStatement(sql);
            ResultSet rs = stnt.executeQuery();
            while(rs.next()){
                Cliente p = new Cliente();
                p.setId(rs.getLong("id")); //o nome da coluna do banco
                p.setNome(rs.getString("nome"));
                p.setNumCompras(rs.getString("numCompras"));
                p.setDebito(rs.getString("debito"));
                clientes.add(p);
            }
            stnt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            return null;
        }

        return clientes;
            
    }    
        
        
}

