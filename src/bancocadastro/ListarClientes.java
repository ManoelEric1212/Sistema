/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancocadastro;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * essa classe é uma aplicação que gerenciará todos os métodos relacionados a elas e aqueles que nela serão instanciados.
 */
public class ListarClientes {
    static Stage stage;

    /**
     * é um método responsável por iniciar a classe tornando uma classe principal java.
     * @param args 
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    /**
     * esse método é responsável por iniciar a aplicação onde nele teremos um fmxl que determinará as características da cena.
     * @param stage
     * @throws IOException 
     */
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ListarClientes.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Listando Clientes");
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
        ListarClientes.stage = stage;
    }
    
}
