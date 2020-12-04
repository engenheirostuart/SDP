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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sdp.Apresentacao;

/**
 *
 * @author stuar
 */
public class BemVindoController implements Initializable {
    
    @FXML
    private Button btBV;
    @FXML
    private Button btFechar;
    
    @FXML
    private void btBemVindo(ActionEvent event) {
        System.out.println("You clicked me!");
        Apresentacao bv = new Apresentacao();
                try {
                    bv.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(BemVindoController.class.getName()).log(Level.SEVERE, null, ex);
                }
        fechar();
    }
    @FXML
    private void fechar(ActionEvent event2) {
        System.out.println("Clicou Fechar!");
        Stage stage = (Stage) btFechar.getScene().getWindow();
            stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btBV.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.ENTER){
                System.out.println("Etrou!");
                Apresentacao bv = new Apresentacao();
                try {
                    bv.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(BemVindoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(e.getCode() == KeyCode.F10){
                System.out.println("Fechou!");

            }
            fechar();
        });
        btFechar.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.ENTER){
                System.out.println("Enter para Fechar!");
            fechar();
            }
        });
        
    }    
    
    public void fechar(){
        Stage stage = (Stage) btFechar.getScene().getWindow();
        stage.close();
    }
}

