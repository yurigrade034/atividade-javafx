package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Atividade8JogoAdivinhacaoController {

    @FXML
    private TextField campoNumero;

    @FXML
    private Label rotuloResultado;

    private int numeroSorteado = sortearNumero();

    @FXML
    private void verificar() {
        try {
            int chute = Integer.parseInt(campoNumero.getText());
            if (chute < 1 || chute > 10) {
                rotuloResultado.setText("Digite um número válido (1 a 10).");
                return;
            }

            if (chute == numeroSorteado) {
                rotuloResultado.setText("Acertou! O número era " + numeroSorteado + ".");
            } else {
                rotuloResultado.setText("Errou! O número era " + numeroSorteado + ".");
            }

        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Digite um número válido.");
        }
    }

    @FXML
    private void tentarNovamente() {
        numeroSorteado = sortearNumero();
        campoNumero.clear();
        rotuloResultado.setText("Novo número sorteado! Tente novamente.");
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }

    private int sortearNumero() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}
