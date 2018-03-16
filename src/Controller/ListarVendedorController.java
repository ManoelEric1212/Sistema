/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendedorDAO;
import Model.Vendedor;
import bancocadastro.AlteraVendedor;
import bancocadastro.ListarVendedor;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * essa classe é responsável por controlar o documento fxml gerado no pacote View onde este receberá todos métodos e objetos que serão
 * utilizados na construção do sistema.
 */
public class ListarVendedorController implements Initializable {

    @FXML private Button btatualizar;
    @FXML private Button btremover;
    @FXML private TableView<Vendedor> tabela;
    @FXML private TableColumn<Vendedor, Long> clid;
    @FXML private TableColumn<Vendedor, String> clnome;
    @FXML private TableColumn<Vendedor, String> clnumVendas;
    @FXML private Button btcancelar;
    @FXML private Button btalterar;
    private Vendedor selecionado;
    /**
     * esse método é reponsável por inicializar toda a tela e reune todos os eventos necessários para o funcionamento do sistema
     * além das variáveis objetos são instanciados para apartir desses, métodos serão chamados.
     * @param url parâmetro do construtor padrão.
     * @param rb  parâmetro do construtor padrão.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     initTable();
       btcancelar.setOnMouseClicked((MouseEvent e)->{
            abreTelaPrincipal();
            fecha();
        
        });
       btremover.setOnMouseClicked((MouseEvent e)->{
           
           deletaVendedor();
           
        });
       btatualizar.setOnMouseClicked((MouseEvent e)->{
          tabela.setItems(atualizaTablea());
           
        });
       btalterar.setOnMouseClicked((MouseEvent e)->{
           if(selecionado != null){
                AlteraVendedor vend = new AlteraVendedor(selecionado);
               try {
                   vend.start(new Stage());
                   tabela.setItems(atualizaTablea());
               } catch (IOException ex) {
                   Logger.getLogger(ListarVendedorController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }else{
               Alert a = new Alert(Alert.AlertType.WARNING);
               a.setHeaderText("Selecione um Vendedor");
               a.show();
               
           }
           });
       
       
        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Vendedor) newValue;
            }
        });
        
        
    }
     /**
     * método reponsável por converter os atributos do documento fxml em suas respectivas variáveis correspondentes para que estas sejam
     * tratadas.
     */
    
    public void initTable(){
        clid.setCellValueFactory(new PropertyValueFactory("idVendedor"));
        clnome.setCellValueFactory(new PropertyValueFactory("nomeVendedor"));
        clnumVendas.setCellValueFactory(new PropertyValueFactory("numVendas"));
        tabela.setItems(atualizaTablea());
        
    }
    /**
     * método responsável por atualizar uma lista a partir de uma observação onde esssa coleção de dados serão atualizados caso o retorno
     * da variável boolean sja true.
     * @return  um valor booleano.
     */
    public  ObservableList<Vendedor> atualizaTablea(){
        VendedorDAO dao = new VendedorDAO();
        return FXCollections.observableArrayList(dao.getList()) ;
        
    
    }
    /**
     * método que feccha a tela criada apartir de um outro métod close().
     */
    public void fecha(){
    ListarVendedor.getStage().close();
    
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
     * método responsável por deletar um vendedor da lista a partir de uma simples verificação.
     */
    public void deletaVendedor(){
        if(selecionado != null){
            VendedorDAO dao = new VendedorDAO();
            dao.delete(selecionado);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Vendedor deletado");
            a.show();
            tabela.setItems(atualizaTablea());
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Vendedor não selecionado");
            a.show();
        }
    }
    
}
       
    

