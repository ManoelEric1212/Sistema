/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConexaoBanco;
import Model.Cliente;
import Model.Vendedor;
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
 * essa classe é responsável por criar um objeto de acesso a dados no caso o cliente que acessa dados da tabela vendedor no banco.
 */

public class VendedorDAO {
    private final Connection con;
    
    /**
     * esse construtor instância uma nova conexão.
     */
    public VendedorDAO(){
        this.con = new ConexaoBanco().getConnection();
    
    }
    
    /**
     * esse método é responsável por adicionar valores no banco.
     * possui variáveis que serão preparadas e posteriormente setadas nas tabelas do banco.
     * @param f é um objeto de Cliente.
     * @return  retorna um valor booleano caso esse seja verdadeiro os dados serão adicionados caso não, retornará falso.
     */
    
    public boolean adiciona(Vendedor f){
        
        try {
            String sql = "INSERT INTO vendedor(nomeVendedor,numVendas) VALUES (?,?);";
            PreparedStatement stnt =  con.prepareStatement(sql);
            
            stnt.setString(2, f.getNomeVendedor());
            stnt.setString(1, f.getNumVendas());
            
            stnt.execute();

            return true;
         
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
        
    }
    
    /**
     * esse método é responsável por atualizar os dados da tabela.
     * possui variáveis que serão preparadas e posteriormente setadas nas tabelas do banco.
     * @param f é um objeto do tipo Cliente.
     * @return retorna um valor booleano caso seja verdadeiro os dados serão atualizados no banco caso não retornará falso.
     */
    
    public boolean update(Vendedor f){
        
        try {
            String sql = "UPDATE vendedor SET numVendas = ?, nomeVendedor = ? WHERE idVendedor = ?;";
            PreparedStatement stnt =  con.prepareStatement(sql);
            
            stnt.setString(2, f.getNumVendas());
            stnt.setString(1, f.getNomeVendedor());
            stnt.setLong(3, f.getIdVendedor());
            stnt.execute();
            stnt.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
        
    }
         /**
         * esse método é responsável por remover os dados da tabela.
         * possui variáveis que serão preparadas e posteriormente setadas nas tabelas do banco.
         * @param f p é um objeto do tipo Cliente.
         * @return retorna um valor booleano caso seja verdadeiro os dados serão deletados no banco caso não retornará falso.
         */
        public boolean delete(Vendedor f){
        
        try {
            String sql = "DELETE FROM vendedor WHERE idVendedor = ?;";
            PreparedStatement stnt =  con.prepareStatement(sql);
            stnt.setLong(1, f.getIdVendedor());
            stnt.execute();
            stnt.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
        
    }
        
        /**
         * esse método é responsável por listar todas as tabelas com seus respectivos dados.
         * nesse método uma lista de vendedores é gerada e apartir do preparamento de dados esses vendedores serão adicionados nessa lista
         * para o fim de listagem de seus dados através de uma tableView.
         * @return 
         */
        
    public List<Vendedor>  getList(){
            List<Vendedor> vendedores = new ArrayList<>();
            String sql = "SELECT * FROM vendedor";
        try {
            PreparedStatement stnt = con.prepareStatement(sql);
            ResultSet rs = stnt.executeQuery();
            while(rs.next()){
                Vendedor f = new Vendedor();
                f.setIdVendedor(rs.getLong("idVendedor")); //o nome da coluna do banco
                f.setNomeVendedor(rs.getString("nomeVendedor"));
                f.setNumVendas(rs.getString("numVendas"));
                
                
                vendedores.add(f);
            }
            stnt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            return null;
        }

        return vendedores;
            
    }
    
    
}
