/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sdp.Principal;
import sdp.Principal_Cisalhamento;

/**
 * FXML Controller class
 *
 * @author stuar
 */
public class BinarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btTracao;
    @FXML
    private Button btCisalhamento;
    @FXML
    private void tracao(ActionEvent event) {
        System.out.println("Clicou Tração!");
        Principal p = new Principal();
                try {
                    p.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(BemVindoController.class.getName()).log(Level.SEVERE, null, ex);
                }
        Stage stage = (Stage) btTracao.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    private void cisalhamento(ActionEvent event) {
        System.out.println("Clicou Cisalhamento!");
        Principal_Cisalhamento p = new Principal_Cisalhamento();
                try {
                    p.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(BemVindoController.class.getName()).log(Level.SEVERE, null, ex);
                }
        Stage stage = (Stage) btCisalhamento.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
