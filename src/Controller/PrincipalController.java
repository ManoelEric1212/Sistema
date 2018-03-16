/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import bancocadastro.CadastrarCliente;
import bancocadastro.CadastrarVendedor;
import bancocadastro.ListarClientes;
import bancocadastro.ListarVendedor;
import bancocadastro.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */

    
    
    
public class PrincipalController implements Initializable {
    
       @FXML
    private Button btcadastrar;

    @FXML
    private Button btselecionar;
    
    @FXML
    private Button btcadastrarvd;
    @FXML
    private Button btselecionarvd;
    
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param location parâmetro do construtor padrão.
     * @param resources parâmetro do construtor padrão.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       
        btcadastrar.setOnMouseClicked((MouseEvent e)->{
            abreCadastroCliente();
        
        });
        btcadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            abreCadastroCliente();
            }
        });
        btselecionar.setOnMouseClicked((MouseEvent e)->{
            visualizaCliente();
        
        });
        btselecionar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            visualizaCliente();
            }
        });
        
        btcadastrarvd.setOnMouseClicked((MouseEvent e)->{
            abreCadastroVendedor();
        
        });
        btcadastrarvd.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            abreCadastroVendedor();
            }
        });
        btselecionarvd.setOnMouseClicked((MouseEvent e)->{
            visualizaVendedor();
        
        });
        btselecionarvd.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            visualizaVendedor();
            }
        });
        
        
        
    }
    /**
     * método responsável por fazer a transição de tela para o cadastro de clientes.
     */
    
  public void abreCadastroCliente(){
        CadastrarCliente cli = new CadastrarCliente();
        fecha();
            try {
                cli.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    /**
     * método que feccha a tela criada apartir de um outro método close().
     */
  public void fecha(){
      Principal.getStage().close();
  
  }
  /**
     * método responsável por fazer a transição de tela para a visualização de clientes.
     */
  public void visualizaCliente(){
      ListarClientes lis = new ListarClientes();
        fecha();
           try {
               lis.start(new Stage());
           } catch (IOException ex) {
               Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
           }
            
          
      }
    /**
     * método responsável por fazer a transição de tela para o cadastro de vendedores.
     */
  public void abreCadastroVendedor(){
        CadastrarVendedor vend = new CadastrarVendedor();
        fecha();
            try {
                vend.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
     /**
     * método responsável por fazer a transição de tela para a vizualização de vendedores.
     */
  public void visualizaVendedor(){
      ListarVendedor lis = new ListarVendedor();
        fecha();
           try {
               lis.start(new Stage());
           } catch (IOException ex) {
               Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
           }
      
      }
  
  }

  
  



    
    

