/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import bancocadastro.CadastrarCliente;
import bancocadastro.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */


public class CadastrarClienteController implements Initializable {

    
    @FXML
    private TextField txdebito;

    @FXML
    private TextField txnumcompra;

    @FXML
    private Button btcancelar;

    @FXML
    private Button btcadastrar;

    @FXML
    private Label lbdebito;

    @FXML
    private Label lbnome;

    @FXML
    private Text text;

    @FXML
    private TextField txnome;

    @FXML
    private Label lbnumcompra;
    @Override
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb parâmetro do construtor padrão.
     */
    public void initialize(URL url, ResourceBundle rb) {
        btcancelar.setOnMouseClicked((MouseEvent e)->{
            abrePrincipal();
            });
        
        btcancelar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            abrePrincipal();
            }
        });
        
         btcadastrar.setOnMouseClicked((MouseEvent e)->{
             cadastraCliente();
            
            });
        
        btcadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                cadastraCliente();
            }
        });
        
    }
    /**
     * método responsável por cadastrar um cliente a partir do instanciamento de uma classe ClienteDAO
     * onde essa contém métodos de cadastro.
     */
    private void cadastraCliente(){
        String nome = txnome.getText();
        String numCompras = txnumcompra.getText();
        String debito = txdebito.getText();
        Cliente p = new Cliente(nome,numCompras,debito);
        ClienteDAO dao = new ClienteDAO();
        //dao.adiciona(p);
        if(dao.adiciona(p)){
            Alert al = new Alert(AlertType.CONFIRMATION);
            al.setHeaderText("USUÁRIO  CADASTRADO!");
            abrePrincipal();
            al.show();
            fecha();
        }else{
            Alert al = new Alert(AlertType.ERROR);
            al.setHeaderText("USUÁRIO NÃO CADASTRADO!");
            al.show();
        }
        
    
    
    }
    /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
    public void fecha(){
    CadastrarCliente.getStage().close();
    }
    /**
     * método responsável por fazer a troca de telas chamando a tela da classe de nome Principal no pacote.
     */
    public void abrePrincipal(){
        Principal a = new Principal();
        fecha();
        try {
            a.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(CadastrarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
