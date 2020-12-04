/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import materiais.Materiais;
import materiais.Unidades;
import materiais.FatorServico;
import sdp.Binario;
import util.TextFieldFormatter;

/**
 * FXML Controller class
 *
 * @author stuar
 */
public class PrincipalController_Cisalhamento implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtForca;
    @FXML
    private TextField txtTensao;
    @FXML
    private Button btCalcular;
    @FXML
    public Button btVoltar;
    @FXML
    private ComboBox<Unidades> cbUnidade;
    @FXML
    private ComboBox<FatorServico> cbFatorServico;
    @FXML
    private ComboBox<Materiais> cbMateriais;
    @FXML
    private CheckBox cbMaterial;
    @FXML
    private Label lblResultado;
    @FXML
    private Label lblInfo;

    private List<Materiais> materiais = new ArrayList<>();
    private List<Unidades> unidades = new ArrayList<>();
    private List<FatorServico> fatores = new ArrayList<>();

    private ObservableList<Materiais> obsMateriais;
    private ObservableList<Unidades> obsUnidades;
    private ObservableList<FatorServico> obsFatores;

    private Boolean manual;
    private double forca;
    private double tensaoManual;
    private double tensaoAutomatica;
    private double mt;
    private double resMat;
    private double areaParafuso;
    private double areaPolegadas;
    private double diametroParafuso;
    private double umedida;
    private double fservico;
    private double diametroPolegadas;
    private int parafusoPolegadas;
    private int parafusoMilimetrico;

    //private TextField c;
    @FXML // Ação do botão calcular
    private void calcular(ActionEvent event) {

        calcular();

    }

    @FXML // Ação do botão calcular
    private void unidadeMedida(ActionEvent event) {

    }

    @FXML // Ação do botão calcular
    private void fatorServico(ActionEvent event) {

    }

    @FXML // Ação do botão voltar
    private void voltar(ActionEvent event) {
        System.out.println("Clicou Tração!");
        Binario bi = new Binario();
        try {
            bi.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(BemVindoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = (Stage) btVoltar.getScene().getWindow();
        stage.close();

    }

    @FXML // Ação manual do combo box material
    void materialManual(ActionEvent event) {
        manual = cbMaterial.selectedProperty().getValue();
        if (manual.equals(true)) {
            System.out.println("Material manual ," + cbMaterial.selectedProperty().getValue());
            lblInfo.setText("Material escolhido manualmente");
            cbMateriais.isDisabled();
        } else {
            System.out.println("Material automatico ," + cbMaterial.selectedProperty().getValue());
            lblInfo.setText("Material escolhido automaticamento");
            txtTensao.setText("");
        }
    }

    @FXML

    @Override // Inicializa o metodo materiais
    public void initialize(URL url, ResourceBundle rb) {
        unidadeMeidida();
        fatorServico();
        materiais();

    }

    @FXML // Ação do combo box material
    void material(ActionEvent event) {

        manual = cbMaterial.selectedProperty().getValue();

        if (manual.equals(false)) {

            Materiais materiais = cbMateriais.getSelectionModel().getSelectedItem();

            System.out.println("Material escolhido é: " + materiais.getNomeMaterial()
                    + " Tensão de escoamento de: " + materiais.getResMaterial() + " N/mm²");
            lblInfo.setText("Material escolhido é: " + materiais.getNomeMaterial()
                    + " Tensão de escoamento de: " + materiais.getResMaterial() + " N/mm²");

        } else {

            System.out.println("Desabilite o campo Digitar material manual");
            lblInfo.setText("Desabilite o campo Digitar material manual");

        }
    }

    // Cria o combobox unidade de medida
    public void unidadeMeidida() {

        Unidades unidade1 = new Unidades("Newton", "N", 1);
        Unidades unidade2 = new Unidades("Kilograma força", "Kgf", 9.81);

        unidades.add(unidade1);
        unidades.add(unidade2);

        obsUnidades = FXCollections.observableList(unidades);

        cbUnidade.setItems(obsUnidades);
    }

    public void fatorServico() {

        FatorServico fator1 = new FatorServico(1);
        FatorServico fator11 = new FatorServico(1.35);
        FatorServico fator12 = new FatorServico(1.5);
        FatorServico fator2 = new FatorServico(2);
        FatorServico fator21 = new FatorServico(2.5);
        FatorServico fator3 = new FatorServico(3);
        FatorServico fator4 = new FatorServico(4);
        FatorServico fator5 = new FatorServico(5);
        FatorServico fator6 = new FatorServico(6);
        FatorServico fator7 = new FatorServico(7);
        FatorServico fator8 = new FatorServico(8);
        FatorServico fator9 = new FatorServico(9);
        FatorServico fator10 = new FatorServico(10);

        fatores.add(fator1);
        fatores.add(fator11);
        fatores.add(fator12);
        fatores.add(fator2);
        fatores.add(fator21);
        fatores.add(fator3);
        fatores.add(fator4);
        fatores.add(fator5);
        fatores.add(fator6);
        fatores.add(fator7);
        fatores.add(fator8);
        fatores.add(fator9);
        fatores.add(fator10);

        obsFatores = FXCollections.observableList(fatores);

        cbFatorServico.setItems(obsFatores);

    }

    // Cria a classe materiais
    public void materiais() {

        Materiais material1 = new Materiais("Aço 1020", 350, 1);
        Materiais material2 = new Materiais("Aço 1030", 390, 2);
        Materiais material3 = new Materiais("Aço 1045", 540, 3);
        Materiais material4 = new Materiais("A307", 240, 4);
        Materiais material5 = new Materiais("A325", 640, 5);
        Materiais material6 = new Materiais("A354 BC", 750, 6);
        Materiais material7 = new Materiais("A354 BD", 900, 7);
        Materiais material8 = new Materiais("A449", 640, 8);
        Materiais material9 = new Materiais("A490", 900, 9);
        Materiais material10 = new Materiais("A574", 1000, 10);

        materiais.add(material1);
        materiais.add(material2);
        materiais.add(material3);
        materiais.add(material4);
        materiais.add(material5);
        materiais.add(material6);
        materiais.add(material7);
        materiais.add(material8);
        materiais.add(material9);
        materiais.add(material10);

        obsMateriais = FXCollections.observableArrayList(materiais);

        cbMateriais.setItems(obsMateriais);
    }

    @FXML // Ação do campo força
    void acaoForca(KeyEvent event) {

        formatarForca();

        System.out.println("A Força é: " + txtForca.getText());
        lblInfo.setText("A Força é: " + txtForca.getText());
        lblResultado.setText("");
    }

    @FXML // Ação do Campo tensão
    void acaoTensao(KeyEvent event) {

        manual = cbMaterial.selectedProperty().getValue();

        if (manual.equals(true)) {

            formatarTensao();
            System.out.println("A Tensão é: " + txtTensao.getText());
            lblInfo.setText("A Tensão é: " + txtTensao.getText());

        } else {

            txtTensao.setText("");
            System.out.println("Para usar materia manualmente habilite o campo Digitar material");
            lblInfo.setText("Para usar materia manualmente habilite o campo Digitar material");

        }
    }

    // Metodo formata força
    public void formatarForca() {

        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("#######");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtForca);
        tff.formatter();
    }

    // Metodo formata tensão
    public void formatarTensao() {

        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtTensao);
        tff.formatter();
    }

    // Metodo calcular
    private void calcular() {

        ajustar();

        Unidades unidades = cbUnidade.getSelectionModel().getSelectedItem();
        FatorServico fatores = cbFatorServico.getSelectionModel().getSelectedItem();
        Materiais materiais = cbMateriais.getSelectionModel().getSelectedItem();

        forca = Double.valueOf(txtForca.getText());
        umedida = unidades.numerador;
        fservico = fatores.fator;
        manual = cbMaterial.selectedProperty().getValue();

        System.out.println("Resolvendo...");
        System.out.println("A força é: " + forca);

        if (manual.equals(true)) {

            if (txtTensao.getText().equals("")) {

                System.out.println("Digite o valor da tensão de escoamento do material");
                lblInfo.setText("Digite o valor da tensão de escoamento do material");

            } else {

                System.out.println("calculo manual");
                tensaoManual = Double.valueOf(txtTensao.getText());
                System.out.println("A resistencia do material é: " + tensaoManual);
                resMat = tensaoManual;

                equacaoNormal();

            }

        } else {

            System.out.println("Calculo automatico");
            tensaoAutomatica = materiais.getResMaterial();
            System.out.println("A tensão é: " + tensaoAutomatica);
            resMat = tensaoAutomatica;

            equacaoNormal();

        }
    }

    // Executa a equação normal
    private void equacaoNormal() {

        DecimalFormat formato = new DecimalFormat("#.##");
        DecimalFormat formato2 = new DecimalFormat("#.####");

        areaParafuso = (umedida * forca) / ((resMat / fservico) / Math.sqrt(3));
        areaPolegadas = areaParafuso / 654.16;
        diametroParafuso = Math.sqrt((areaParafuso * 4) / Math.PI);
        diametroPolegadas = diametroParafuso / 25.4;

        ajusteResultadosPol();
        ajusteMilimetrico();

        String areaFormat = formato.format(areaParafuso);
        String areaPFormat = formato2.format(areaPolegadas);

        System.out.printf("A area necessaria é: %.2f mm^2 \n", areaParafuso);
        System.out.printf("A area necessaria é: %.2f pol^2 \n", areaPolegadas);
        System.out.printf("O diametro necessaria é: %.2f mm \n", diametroParafuso);
        System.out.printf("Diametro em polegadas é: %.2f pol \n", diametroPolegadas);

        lblResultado.setText("O parafuso mínimo recomendado é: " + this.ajusteMilimetrico() + " ou " + this.ajustePolegadas() + " Pol");
        lblInfo.setText("A área efetiva necessaria é: " + areaFormat + " mm² ou " + areaPFormat + " pol²");

    }

    private void ajustar() {

        Unidades unidades = cbUnidade.getSelectionModel().getSelectedItem();
        FatorServico fatores = cbFatorServico.getSelectionModel().getSelectedItem();
        Materiais materiais = cbMateriais.getSelectionModel().getSelectedItem();

        if (cbUnidade.getSelectionModel().isEmpty()) {
            cbUnidade.getSelectionModel().selectFirst();
        } else {
            System.out.println("Unidade escolhida: " + unidades.nomeUnidade);
        }
        if (cbFatorServico.getSelectionModel().isEmpty()) {
            cbFatorServico.getSelectionModel().selectFirst();
        } else {
            System.out.println("Fator de serviço escolhida: " + fatores.getFator());
        }
        if (cbMateriais.getSelectionModel().isEmpty()) {
            cbMateriais.getSelectionModel().selectFirst();
        } else {
            System.out.println("Material escolhida: " + materiais.getNomeMaterial());
        }
    }

    private void ajusteResultadosPol() {

        if (areaPolegadas <= 0.0318) {
            parafusoPolegadas = 1;
        }
        if (areaPolegadas >= 0.0318 && areaPolegadas < 0.0524) {
            parafusoPolegadas = 2;
        }
        if (areaPolegadas >= 0.0524 && areaPolegadas < 0.0775) {
            parafusoPolegadas = 3;
        }
        if (areaPolegadas >= 0.0775 && areaPolegadas < 0.1063) {
            parafusoPolegadas = 4;
        }
        if (areaPolegadas >= 0.1063 && areaPolegadas < 0.1419) {
            parafusoPolegadas = 5;
        }
        if (areaPolegadas >= 0.1419 && areaPolegadas < 0.182) {
            parafusoPolegadas = 6;
        }
        if (areaPolegadas >= 0.182 && areaPolegadas < 0.226) {
            parafusoPolegadas = 7;
        }
        if (areaPolegadas >= 0.226 && areaPolegadas < 0.334) {
            parafusoPolegadas = 8;
        }
        if (areaPolegadas >= 0.334 && areaPolegadas < 0.462) {
            parafusoPolegadas = 9;
        }
        if (areaPolegadas >= 0.462 && areaPolegadas < 0.606) {
            parafusoPolegadas = 10;
        }
        if (areaPolegadas >= 0.606 && areaPolegadas < 0.763) {
            parafusoPolegadas = 11;
        }
        if (areaPolegadas >= 0.763 && areaPolegadas < 0.969) {
            parafusoPolegadas = 12;
        }
        if (areaPolegadas >= 0.969 && areaPolegadas < 1.155) {
            parafusoPolegadas = 13;
        }
        if (areaPolegadas >= 1.155 && areaPolegadas < 1.405) {
            parafusoPolegadas = 14;
        }
        if (areaPolegadas >= 1.405 && areaPolegadas < 1.9) {
            parafusoPolegadas = 15;
        }
        if (areaPolegadas >= 1.9 && areaPolegadas <= 2.5) {
            parafusoPolegadas = 16;
        }
        if (areaPolegadas >= 2.5) {
            parafusoPolegadas = 17;
        }

        if (areaParafuso >= 0.460) {
            parafusoMilimetrico = 1;
        }
        if (areaParafuso >= 0.460 && areaParafuso < 1.27) {
            parafusoMilimetrico = 2;
        }
        if (areaParafuso >= 1.27 && areaParafuso < 2.07) {
            parafusoMilimetrico = 3;
        }
        if (areaParafuso >= 2.07 && areaParafuso < 3.39) {
            parafusoMilimetrico = 4;
        }
        if (areaParafuso >= 3.39 && areaParafuso < 5.03) {
            parafusoMilimetrico = 5;
        }
        if (areaParafuso >= 5.03 && areaParafuso < 8.78) {
            parafusoMilimetrico = 6;
        }
        if (areaParafuso >= 8.78 && areaParafuso < 14.2) {
            parafusoMilimetrico = 7;
        }
        if (areaParafuso >= 14.2 && areaParafuso < 20.1) {
            parafusoMilimetrico = 8;
        }
        if (areaParafuso >= 20.1 && areaParafuso < 36.6) {
            parafusoMilimetrico = 9;
        }
        if (areaParafuso >= 36.6 && areaParafuso < 58) {
            parafusoMilimetrico = 10;
        }
        if (areaParafuso >= 58 && areaParafuso < 84.3) {
            parafusoMilimetrico = 11;
        }
        if (areaParafuso >= 84.3 && areaParafuso < 157) {
            parafusoMilimetrico = 12;
        }
        if (areaParafuso >= 157 && areaParafuso < 245) {
            parafusoMilimetrico = 13;
        }
        if (areaParafuso >= 245 && areaParafuso < 353) {
            parafusoMilimetrico = 14;
        }
        if (areaParafuso >= 353 && areaParafuso < 561) {
            parafusoMilimetrico = 15;
        }
        if (areaParafuso >= 561 && areaParafuso < 817) {
            parafusoMilimetrico = 16;
        }
        if (areaParafuso >= 817 && areaParafuso < 1121) {
            parafusoMilimetrico = 17;
        }
        if (areaParafuso >= 1121 && areaParafuso <= 1473) {
            parafusoMilimetrico = 18;
        }
        if (areaParafuso > 1473) {
            parafusoMilimetrico = 19;
        }

    }

    private String ajustePolegadas() {

        switch (parafusoPolegadas) {

            case 1:
                return "1/4";
            case 2:
                return "5/8";
            case 3:
                return "3/8";
            case 4:
                return "7/16";
            case 5:
                return "1/2";
            case 6:
                return "9/16";
            case 7:
                return "5/8";
            case 8:
                return "3/4";
            case 9:
                return "7/8";
            case 10:
                return "1";
            case 11:
                return "1 1/8";
            case 12:
                return "1 1/4";
            case 13:
                return "1 3/8";
            case 14:
                return "1 1/2";
            case 15:
                return "1 3/4";
            case 16:
                return "2";
            case 17:
                return "maior que 2";
            default:
                return "Valor não encontrado";
        }
    }

    private String ajusteMilimetrico() {

        switch (parafusoMilimetrico) {

            case 1:
                return "M1";
            case 2:
                return "M1,6";
            case 3:
                return "M2";
            case 4:
                return "M2,5";
            case 5:
                return "M3";
            case 6:
                return "M4";
            case 7:
                return "M5";
            case 8:
                return "M6";
            case 9:
                return "M8";
            case 10:
                return "M10";
            case 11:
                return "M12";
            case 12:
                return "M16";
            case 13:
                return "M20";
            case 14:
                return "M24";
            case 15:
                return "M30";
            case 16:
                return "M36";
            case 17:
                return "M42";
            case 18:
                return "M48";
            case 19:
                return "maior que M48";
            default:
                return "Valor não encontrado";
        }
    }
}
