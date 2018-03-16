/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import bancocadastro.Login;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */
public class LoginController implements Initializable {
    @FXML
    private Button btsair;

    @FXML
    private TextField txnome;

    @FXML
    private PasswordField txsenha;

    @FXML
    private Button btentrar;

     /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb parâmetro do construtor padrão.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btentrar.setOnMouseClicked((MouseEvent e)->{
        logar();
        });
        
        btentrar.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode() == KeyCode.ENTER){
            logar();
            }
        
           
        
        });
        btsair.setOnMouseClicked((MouseEvent e)->{
        
            fecha();
        });
        btsair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            fecha();
            }
    
    });
        txsenha.setOnKeyPressed((KeyEvent e)->{
        if(e.getCode() == KeyCode.ENTER){
            logar();
            }
        });
     /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
    } 
    public void fecha(){
        Login.getStage().close();
    }
    
    /**
     * método responsável por fazer o login para o sistem na qual os dados são padronizados e somente se estiverem setados 
     * o login e a transição entre as telas ocorrerá.
     */
    
    public void logar(){
        
    if(txnome.getText().equals("root") && txsenha.getText().equals("3306root")){
            Principal p = new Principal();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("LOGIN INVÁLIDO");
            alert.setTitle("ERRO");
            alert.setContentText("USUÁRIO FORNECEU DADOS INVÁLIDOS");
            alert.show();
        }

    }
    
}
