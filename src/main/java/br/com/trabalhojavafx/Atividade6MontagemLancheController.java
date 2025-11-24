package br.com.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class Atividade6MontagemLancheController {

    @FXML
    private TextField campoNomeCliente;

    @FXML
    private ComboBox<String> comboPao;

    @FXML
    private ToggleGroup grupoCarne;

    @FXML
    private RadioButton rbBovina;

    @FXML
    private RadioButton rbFrango;

    @FXML
    private RadioButton rbSoja;

    @FXML
    private CheckBox chkQueijo;

    @FXML
    private CheckBox chkBacon;

    @FXML
    private CheckBox chkSalada;

    @FXML
    private CheckBox chkMolho;

    @FXML
    private Label rotuloResumo;

    @FXML
    private void gerarPedido() {
        String nome = campoNomeCliente.getText();
        String pao = comboPao.getValue();

        if (nome == null || nome.isEmpty() || pao == null) {
            rotuloResumo.setText("Preencha nome e tipo de pão.");
            return;
        }

        RadioButton selecionada = (RadioButton) grupoCarne.getSelectedToggle();
        String carne = selecionada.getText().toLowerCase();

        List<String> adicionais = new ArrayList<>();
        if (chkQueijo.isSelected()) adicionais.add("queijo");
        if (chkBacon.isSelected()) adicionais.add("bacon");
        if (chkSalada.isSelected()) adicionais.add("salada");
        if (chkMolho.isSelected()) adicionais.add("molho");

        String textoAdicionais;
        if (adicionais.isEmpty()) {
            textoAdicionais = ", sem adicionais";
        } else {
            textoAdicionais = ", com " + String.join(", ", adicionais);
        }

        String mensagem = String.format(
                "Pedido de %s: pão %s com carne %s%s.",
                nome, pao, carne, textoAdicionais
        );
        rotuloResumo.setText(mensagem);
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }
}
