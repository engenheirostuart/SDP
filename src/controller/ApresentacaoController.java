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
import sdp.Binario;

/**
 * FXML Controller class
 *
 * @author stuar
 */
public class ApresentacaoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btOk;

    @FXML
    private void iniciar(ActionEvent event) {
        System.out.println("Clicou OK!");
        Binario bi = new Binario();
        try {
            bi.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(BemVindoController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        Stage stage = (Stage) btOk.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
