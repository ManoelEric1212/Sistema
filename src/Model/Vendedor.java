/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

 /**
 *
 * essa classe é responsável por fazer a modelagem de uma das tabelas do banco na qual reunirá seus atributos do banco.
 */

public class Vendedor {
    Long idVendedor;
    String numVendas;
    String nomeVendedor;
    /**
     * é um construtor avzio.
     */

    public Vendedor() {
    }
    
    /**
     * é um construtor que receberá todos os atributos do banco.
     * @param idVendedor é uma variável do tipo Long.
     * @param numVendas é uma variável do tipo String.
     * @param nomeVendedor  é uma variável do tipo String.
     */

    public Vendedor(Long idVendedor, String numVendas, String nomeVendedor) {
        this.idVendedor = idVendedor;
        this.numVendas = numVendas;
        this.nomeVendedor = nomeVendedor;
    }
    
    /**
     * é um construtor que recebe apenas dois atributo.
     * @param numVendas é uma variável do tipo String.
     * @param nomeVendedor   é uma variável do tipo String.
     */
    

    public Vendedor(String numVendas, String nomeVendedor) {
        this.numVendas = numVendas;
        this.nomeVendedor = nomeVendedor;
    }
    
    /**
     * 
     * @return  retorna o valor de idVendedor.
     */

    public Long getIdVendedor() {
        return idVendedor;
    }
    /**
     * 
     * @param idvendedor seta um valor na variável.
     */

    public void setIdVendedor(Long idvendedor) {
        this.idVendedor = idvendedor;
    }
    /**
     * 
     * @return retorna o valor de numVendas.
     */

    public String getNumVendas() {
        return numVendas;
    }
    /**
     * 
     * @param numVendas seta um valor na vairável.
     */

    public void setNumVendas(String numVendas) {
        this.numVendas = numVendas;
    }
    
    /**
     * 
     * @return retorna a variável do tipo STring NomeVendedor.
     */

    public String getNomeVendedor() {
        return nomeVendedor;
    }
    /**
     * 
     * @param nomeVendedor seta um valor na vairável.
     */

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
    
    
    
}
