package br.com.trabalhojavafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Atividade7SemaforoController {

    @FXML
    private Circle luzVermelha;

    @FXML
    private Circle luzAmarela;

    @FXML
    private Circle luzVerde;

    private int estado = 0; //
    private Timeline timeline;

    @FXML
    private void initialize() {
        atualizarCores();
        timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            estado = (estado + 1) % 3;
            atualizarCores();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    @FXML
    private void iniciar() {
        timeline.play();
    }

    @FXML
    private void parar() {
        timeline.stop();
    }

    @FXML
    private void voltar() {
        timeline.stop();
        MainApp.voltarMenu();
    }

    private void atualizarCores() {
        luzVermelha.setFill(Color.GRAY);
        luzAmarela.setFill(Color.GRAY);
        luzVerde.setFill(Color.GRAY);

        switch (estado) {
            case 0:
                luzVermelha.setFill(Color.RED);
                break;
            case 1:
                luzAmarela.setFill(Color.YELLOW);
                break;
            case 2:
                luzVerde.setFill(Color.LIMEGREEN);
                break;
        }
    }
}
