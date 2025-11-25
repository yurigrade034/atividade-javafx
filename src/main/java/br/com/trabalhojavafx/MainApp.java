package br.com.trabalhojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage palcoPrincipal;
    private static Scene cenaMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        palcoPrincipal = primaryStage;
        carregarMenuPrincipal();
        palcoPrincipal.setTitle("Trabalho JavaFX - Yuri Grade");
        palcoPrincipal.show();
    }

    private void carregarMenuPrincipal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent raiz = loader.load();
        cenaMenu = new Scene(raiz, 400, 420);
                palcoPrincipal.setScene(cenaMenu);
    }

    public static Stage getPalcoPrincipal() {
        return palcoPrincipal;
    }

    public static Scene getCenaMenu() {
        return cenaMenu;
    }

    public static void trocarCena(String nomeFxml, double largura, double altura) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(nomeFxml));
            Parent raiz = loader.load();
            Scene novaCena = new Scene(raiz, largura, altura);
            palcoPrincipal.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void voltarMenu() {
        if (palcoPrincipal != null && cenaMenu != null) {
            palcoPrincipal.setScene(cenaMenu);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
