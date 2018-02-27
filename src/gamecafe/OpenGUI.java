/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafe;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kayaya
 */
public class OpenGUI {
    public OpenGUI(){
    }
    
    public void open(ActionEvent event, String resource) throws IOException{  

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(resource));        
            Scene scene = new Scene(root);        
            stage.setScene(scene);
            stage.show(); 
            ((Node) (event.getSource())).getScene().getWindow().hide();                
    }
    
}
