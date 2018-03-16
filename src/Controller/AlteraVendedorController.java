/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendedorDAO;
import Model.Vendedor;
import bancocadastro.AlteraVendedor;
import java.net.URL;
import java.util.ResourceBundle;
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
/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */

public class AlteraVendedorController implements Initializable {
    @FXML
    private Button btatualizar;
    @FXML
    private TextField txnomevd;
    @FXML
    private Label lbID;
    @FXML
    private Button btcancelar;
    @FXML
    private Text text1;
    @FXML
    private Label lbnomevd;
    @FXML
    private Label lbnumvenda;
    @FXML
    private Label lbnomevd1;
    @FXML
    private TextField txnumvenda;
    @FXML
    void AlteraVendedorController(ActionEvent event) {

    }
    
    private static Vendedor vendedor2;
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb parâmetro do construtor padrão.s
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initVendedor();
        
        btcancelar.setOnMouseClicked((MouseEvent e)->{
            fecha();
            });
        
        btcancelar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            fecha();
            }
        });
        btatualizar.setOnMouseClicked((MouseEvent e)->{
             atualizar();
            
            });
        
        btatualizar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                atualizar();
            }
        });
    }
     /**
     * método reponsável por converter os atributos do documento fxml em suas respectivas variáveis correspondentes para que estas sejam
     * tratadas.
     */
    public void initVendedor(){
        lbID.setText(vendedor2.getIdVendedor().toString());
        txnomevd.setText(vendedor2.getNomeVendedor());
        txnumvenda.setText(vendedor2.getNumVendas());
    }
    /**
     * método que atualiza os dados da tabele somente se esse estiverem selecionados.
     */
    public void atualizar(){
        Long idVendedor = Long.parseLong(lbID.getText());
        String nomeVendedor = txnomevd.getText();
        String numVendas = txnumvenda.getText();
        VendedorDAO dao = new VendedorDAO();
        Vendedor vend = new Vendedor(idVendedor,nomeVendedor,numVendas);
        if(dao.update(vend)){
            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setHeaderText("Vendedor  ATUALIZADO!");
            al.show();
            fecha();
            
        }else{
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Vendedor NÃO ATUALIZADO!");
            al.show();
        
        }
    
    
    }
    /**
     * 
     * @return retorna uma variável vendedor.
     */

    public static Vendedor getVendedor2() {
        return vendedor2;
    }
    /**
     * método que seta um valor na variável.
     * @param vendedor2 
     */

    public static void setVendedor2(Vendedor vendedor2) {
        AlteraVendedorController.vendedor2 = vendedor2;
    }
    /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
    public void fecha(){
        AlteraVendedor.getStage().close();
    }
    
    
}
