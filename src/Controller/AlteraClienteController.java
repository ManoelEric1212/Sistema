/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import bancocadastro.AlteraCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */


public class AlteraClienteController implements Initializable {
    @FXML private Label lbid1;
    @FXML private TextField txdebito;
    @FXML private Button btatualizar;
    @FXML private Label lbid;
    @FXML private TextField txnumcompra;
    @FXML private Button btcancelar;
    @FXML private Label lbdebito;
    @FXML private Label lbnome;
    @FXML private Text text;
    @FXML private TextField txnome;
    @FXML private Label lbnumcompra;
    private static Cliente cliente2;
    @FXML
    void AlteraClienteController(ActionEvent event) {

    }
    
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb  parâmetro do construtor padrão.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPerson();
        
        btcancelar.setOnMouseClicked((MouseEvent e)->{
            fecha();
            });
        btatualizar.setOnMouseClicked((MouseEvent e)->{
            atualiza();
            });
    }
    /**
     * método reponsável por converter os atributos do documento fxml em suas respectivas variáveis correspondentes para que estas sejam
     * tratadas.
     */
    
    public void initPerson(){
        lbid.setText(cliente2.getId().toString());
        txnome.setText(cliente2.getNome());
        txnumcompra.setText(cliente2.getNumCompras());
        txdebito.setText(cliente2.getDebito());
    }
    /**
     * 
     * @return retorna uma variável cliente.
     */

    public static Cliente getCliente2() {
        return cliente2;
    }
    /**
     * método que seta um valor na variável.
     * @param cliente2 
     */

    public static void setCliente2(Cliente cliente2) {
        AlteraClienteController.cliente2 = cliente2;
    }
    /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
    
    public void fecha(){
        AlteraCliente.getStage().close();
        
    }
    /**
     * método que atualiza os dados da tabele somente se esse estiverem selecionados.
     */
    
    
    public void atualiza(){
        Long id = Long.parseLong(lbid.getText());
        String nome = txnome.getText();
        String numCompras = txnumcompra.getText();
        String debito = txdebito.getText();
        ClienteDAO dao = new ClienteDAO();
        Cliente c = new Cliente(id,nome,numCompras,debito);
        if(dao.update(c)){
            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setHeaderText("DADOS ATUALIZADOS");
            fecha();
            al.show();
        
        }else{
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("OS DADOS NÃO FORAM ATUALIZADOS");
            al.show();
        
        }
        
    
    }
    
    
    
    
}
