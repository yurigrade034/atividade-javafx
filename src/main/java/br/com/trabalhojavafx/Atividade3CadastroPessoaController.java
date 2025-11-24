package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Atividade3CadastroPessoaController {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoIdade;

    @FXML
    private ComboBox<String> comboSexo;

    @FXML
    private CheckBox chkEsportes;

    @FXML
    private Label rotuloResumo;

    @FXML
    private Label rotuloObservacao;

    @FXML
    private void analisar() {
        String nome = campoNome.getText();
        String sexo = comboSexo.getValue();
        boolean gostaEsportes = chkEsportes.isSelected();

        if (nome == null || nome.isEmpty() || sexo == null || campoIdade.getText().isEmpty()) {
            rotuloResumo.setText("Preencha todos os campos.");
            rotuloObservacao.setText("");
            return;
        }

        try {
            int idade = Integer.parseInt(campoIdade.getText());
            String textoEsportes = gostaEsportes ? "gosta de esportes." : "não gosta de esportes.";

            rotuloResumo.setText(nome + ", " + idade + " anos, do sexo " +
                    sexo.toLowerCase() + ", " + textoEsportes);

            if (idade < 18) {
                rotuloObservacao.setText("Menor de idade.");
            } else {
                rotuloObservacao.setText("Maior de idade.");
            }

        } catch (NumberFormatException ex) {
            rotuloResumo.setText("Idade inválida.");
            rotuloObservacao.setText("");
        }
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }
}
