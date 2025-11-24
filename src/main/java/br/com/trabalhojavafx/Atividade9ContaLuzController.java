package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Atividade9ContaLuzController {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoKwh;

    @FXML
    private ComboBox<String> comboTipo;

    @FXML
    private Label rotuloResultado;

    @FXML
    private void calcular() {
        String nome = campoNome.getText();
        String tipo = comboTipo.getValue();

        if (nome == null || nome.isEmpty() || campoKwh.getText().isEmpty() || tipo == null) {
            rotuloResultado.setText("Preencha todos os campos.");
            return;
        }

        try {
            double kwh = Double.parseDouble(campoKwh.getText());
            double tarifa;

            switch (tipo) {
                case "Residencial":
                    tarifa = 0.60;
                    break;
                case "Comercial":
                    tarifa = 0.48;
                    break;
                case "Industrial":
                    tarifa = 0.75;
                    break;
                default:
                    tarifa = 0;
            }

            double valor = kwh * tarifa;

            String mensagem = String.format(
                    "Cliente: %s — Tipo: %s — Consumo: %.0f kWh — Valor: R$ %.2f",
                    nome, tipo, kwh, valor
            );

            rotuloResultado.setText(mensagem);

        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Consumo inválido.");
        }
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }
}
