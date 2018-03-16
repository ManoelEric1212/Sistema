
package Controller;

import DAO.VendedorDAO;
import Model.Vendedor;
import bancocadastro.CadastrarVendedor;
import bancocadastro.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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


public class CadastrarVendedorController implements Initializable {

    @FXML
    private TextField txnomevd;

    @FXML
    private Button btcancelar;

    @FXML
    private Text text1;

    @FXML
    private Label lbnomevd;

    @FXML
    private Button btcadastrar;

    @FXML
    private Label lbnumvenda;

    @FXML
    private TextField txnumvenda;

    @FXML
    void CadastrarVendedorController(ActionEvent event) {
        
        

    }
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb parâmetro do construtor padrão.
     */
    @Override
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
             cadastraVendedor();
            
            });
        
        btcadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                cadastraVendedor();
            }
        });

        
        
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
            Logger.getLogger(CadastrarVendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
public void fecha(){
    CadastrarVendedor.getStage().close();
    }
    
    /**
     * método responsável por cadastrar um vendedor a partir do instanciamento de uma classe VendedorDAO
     * onde essa contém métodos de cadastro.
     */

    private void cadastraVendedor(){
        String nomeVendedor = txnomevd.getText();
        String numVendas = txnumvenda.getText();
        
                
        Vendedor v = new Vendedor(nomeVendedor,numVendas);
        VendedorDAO dao = new VendedorDAO();
        
        if(dao.adiciona(v)){
            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setHeaderText("Vendedor  CADASTRADO!");
            abrePrincipal();
            al.show();
            fecha();
        }else{
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Vendedor NÃO CADASTRADO!");
            al.show();
        }
        
    
    
    }

}
