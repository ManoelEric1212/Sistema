/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import bancocadastro.AlteraCliente;
import bancocadastro.ListarClientes;
import bancocadastro.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */
public class ListarClientesController implements Initializable {
    @FXML private Button btatualizar;
    @FXML private Button btremover;
    @FXML private Button btcancelar;
    @FXML private Button btalterar;
    @FXML private Label lbid;
    @FXML private Label lbidvd;
    @FXML private Label lbdebito;
    @FXML private TableView<Cliente> tabela;
    @FXML private TableColumn<Cliente, Long> clid;
    @FXML private TableColumn<Cliente, String> clnome;
    @FXML private TableColumn<Cliente, String> clnumCompras;
    @FXML private TableColumn<Cliente, String> cldebito;
    private Cliente selecionado;
    
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb parâmetro do construtor padrão.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
       btcancelar.setOnMouseClicked((MouseEvent e)->{
            abreTelaPrincipal();
            fecha();
        
        });
       btremover.setOnMouseClicked((MouseEvent e)->{
           
           deletaCliente();
           
        });
       btatualizar.setOnMouseClicked((MouseEvent e)->{
          tabela.setItems(atualizaTablea());
           
        });
        btalterar.setOnMouseClicked((MouseEvent e)->{
          if(selecionado != null){
                AlteraCliente alt = new AlteraCliente(selecionado);
                  try {
                      alt.start(new Stage());
                  } catch (IOException ex) {
                      Logger.getLogger(ListarClientesController.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Usuário não selecionado");
                    a.show();
                }
        });
       
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Cliente) newValue;
            }
        });
        
        
    }
    /**
     * método reponsável por converter os atributos do documento fxml em suas respectivas variáveis correspondentes para que estas sejam
     * tratadas.
     */
    
    public void initTable(){
        clid.setCellValueFactory(new PropertyValueFactory("id"));
        clnome.setCellValueFactory(new PropertyValueFactory("nome"));
        clnumCompras.setCellValueFactory(new PropertyValueFactory("numCompras"));
        cldebito.setCellValueFactory(new PropertyValueFactory("debito"));
        tabela.setItems(atualizaTablea());
        
    }
    
    /**
     * método responsável por atualizar uma lista a partir de uma observação onde esssa coleção de dados serão atualizados caso o retorno
     * da variável boolean sja true.
     * @return  um valor booleano.
     */
    public  ObservableList<Cliente> atualizaTablea(){
        ClienteDAO dao = new ClienteDAO();
        return FXCollections.observableArrayList(dao.getList()) ;
        
    
    }
    /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
    public void fecha(){
    ListarClientes.getStage().close();
    
    }
    /**
     * método responsável por fazer a troca de telas chamando a tela da classe de nome Principal no pacote.
     */
    public void abreTelaPrincipal(){
        Principal p = new Principal();
        fecha();
        try {
            p.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(ListarClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * método responsável por deletar um cliente da lista a partir de uma simples verificação.
     */
    public void deletaCliente(){
        if(selecionado != null){
            ClienteDAO dao = new ClienteDAO();
            dao.delete(selecionado);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Usuário deletado");
            a.show();
            tabela.setItems(atualizaTablea());
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Usuário não selecionado");
            a.show();
        }
    }
    
}
