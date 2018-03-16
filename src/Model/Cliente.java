
package Model;

/**
 *
 * essa classe é responsável por fazer a modelagem de uma das tabelas do banco na qual reunirá seus atributos do banco.
 */
public class Cliente {



    private Long id;
    private String nome;
    private String numCompras;
    private String debito;
    
    /**
     * esse construtor designará um cliente do banco.
     * @param id é a variável do tipo Long id que servirá de parâmetro.
     * @param nome é a variável do tipo String nome que servirá de parâmetro.
     * @param numCompras é a variável do tipo String numCompras que servirá de parâmetro.
     * @param debito  é a variável do tipo String debito que servirá de parâmetro.
     */

    public Cliente(Long id, String nome, String numCompras, String debito) {
        this.id = id;
        this.nome = nome;
        this.numCompras = numCompras;
        this.debito = debito;
    }

    /**
     * Construtor vazio.
     */
    
    public Cliente() {
    }
    /**
     * construtor que retorna todos os atributos menos o id.
     * @param nome é a variável do tipo String nome que servirá de parâmetro.
     * @param numCompras é a variável do tipo String numCompras que servirá de parâmetro.
     * @param debito é a variável do tipo String debito que servirá de parâmetro.
     */

    public Cliente(String nome, String numCompras, String debito) {
        this.nome = nome;
        this.numCompras = numCompras;
        this.debito = debito;
    }

    
    /**
     * 
     * @return retorna o id.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 
     * @param idcliente seta um valor em id.
     */

    public void setId(Long idcliente) {
        this.id = idcliente;
    }
    /**
     * 
     * @return retorna o nome.
     */

    public String getNome() {
        return nome;
    }
    /**
     * 
     * @param nome seta um valor do tipo String em nome.
     */

    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * 
     * @return  retorna o numéro de compras.
     */

    public String getNumCompras() {
        return numCompras;
    }
    /**
     * 
     * @param numCompras  seta um valor em numCompras.
     */

    public void setNumCompras(String numCompras) {
        this.numCompras = numCompras;
    }
    
    /**
     * 
     * @return  retorna o valor do débito.
     */

    public String getDebito() {
        return debito;
    }
    /**
     * 
     * @param debito seta o valor em debito.
     */

    public void setDebito(String debito) {
        this.debito = debito;
    }

    
    

    
    
    

    
    
    
}
