package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Atividade2ConversorTemperaturaController {

    @FXML
    private TextField campoTemperatura;

    @FXML
    private Label rotuloResultado;

    @FXML
    private void converterParaF() {
        try {
            double c = Double.parseDouble(campoTemperatura.getText());
            double f = c * 9 / 5 + 32;
            rotuloResultado.setText(String.format("Resultado: %.2f °F", f));
        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Resultado: valor inválido.");
        }
    }

    @FXML
    private void converterParaC() {
        try {
            double f = Double.parseDouble(campoTemperatura.getText());
            double c = (f - 32) * 5 / 9;
            rotuloResultado.setText(String.format("Resultado: %.2f °C", c));
        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Resultado: valor inválido.");
        }
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }
}
