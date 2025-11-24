package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Atividade1CalculadoraController {

    @FXML
    private TextField campoNumero1;

    @FXML
    private TextField campoNumero2;

    @FXML
    private Label rotuloResultado;

    @FXML
    private void somar() {
        calcular("+");
    }

    @FXML
    private void subtrair() {
        calcular("-");
    }

    @FXML
    private void multiplicar() {
        calcular("*");
    }

    @FXML
    private void dividir() {
        calcular("/");
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }

    private void calcular(String op) {
        try {
            double a = Double.parseDouble(campoNumero1.getText());
            double b = Double.parseDouble(campoNumero2.getText());
            double r;

            switch (op) {
                case "+":
                    r = a + b;
                    break;
                case "-":
                    r = a - b;
                    break;
                case "*":
                    r = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        rotuloResultado.setText("Resultado: divisão por zero!");
                        return;
                    }
                    r = a / b;
                    break;
                default:
                    r = 0;
            }

            rotuloResultado.setText("Resultado: " + r);
        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Resultado: valores inválidos.");
        }
    }
}
