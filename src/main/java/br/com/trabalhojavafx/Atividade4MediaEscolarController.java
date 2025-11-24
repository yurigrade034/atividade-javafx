package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Atividade4MediaEscolarController {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoNota1;

    @FXML
    private TextField campoNota2;

    @FXML
    private TextField campoNota3;

    @FXML
    private Label rotuloResultado;

    @FXML
    private void calcularMedia() {
        String nome = campoNome.getText();
        if (nome == null || nome.isEmpty() ||
                campoNota1.getText().isEmpty() ||
                campoNota2.getText().isEmpty() ||
                campoNota3.getText().isEmpty()) {
            rotuloResultado.setText("Preencha todos os campos.");
            return;
        }

        try {
            double n1 = Double.parseDouble(campoNota1.getText());
            double n2 = Double.parseDouble(campoNota2.getText());
            double n3 = Double.parseDouble(campoNota3.getText());

            double media = (n1 + n2 + n3) / 3.0;
            String situacao;

            if (media >= 7) {
                situacao = "Aprovado";
            } else if (media >= 4) {
                situacao = "Recuperação";
            } else {
                situacao = "Reprovado";
            }

            rotuloResultado.setText(String.format(
                    "Aluno %s — média: %.1f — %s.", nome, media, situacao));

        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Notas inválidas.");
        }
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }
}
