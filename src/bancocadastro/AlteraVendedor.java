/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancocadastro;

import Controller.AlteraVendedorController;
import Model.Vendedor;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * essa classe é uma aplicação que gerenciará todos os métodos relacionados a elas e aqueles que nela serão instanciados.
 */
public class AlteraVendedor extends Application {
    
    static Stage stage;
    /**
     * é um construto que é responsável por trazer o controlador da classe.
     * @param f 
     */



    public AlteraVendedor(Vendedor f) {
        AlteraVendedorController.setVendedor2(f);
    }
    
    
    /**
     * é um método responsável por iniciar a classe tornando uma classe principal java.
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * esse método é responsável por iniciar a aplicação onde nele teremos um fmxl que determinará as características da cena.
     * @param stage
     * @throws IOException 
     */
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AlteraVendedor.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Alterar Clientes");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    
     }
    /**
     * 
     * @return retorna o valor da variável stage.
     */

    public static Stage getStage() {
        return stage;
    }
    /**
     * seta um valor para a variável.
     * @param stage 
     */

    public static void setStage(Stage stage) {
        AlteraVendedor.stage = stage;
    }
    
    
    
    
}
