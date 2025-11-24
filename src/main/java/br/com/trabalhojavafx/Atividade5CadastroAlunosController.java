package br.com.trabalhojavafx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Atividade5CadastroAlunosController {

    public static class Aluno {
        private final StringProperty nome = new SimpleStringProperty();
        private final IntegerProperty idade = new SimpleIntegerProperty();
        private final StringProperty curso = new SimpleStringProperty();

        public Aluno(String nome, int idade, String curso) {
            this.nome.set(nome);
            this.idade.set(idade);
            this.curso.set(curso);
        }

        public String getNome() { return nome.get(); }
        public int getIdade() { return idade.get(); }
        public String getCurso() { return curso.get(); }

        public StringProperty nomeProperty() { return nome; }
        public IntegerProperty idadeProperty() { return idade; }
        public StringProperty cursoProperty() { return curso; }
    }

    private final ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoIdade;

    @FXML
    private ComboBox<String> comboCurso;

    @FXML
    private TableView<Aluno> tabelaAlunos;

    @FXML
    private TableColumn<Aluno, String> colunaNome;

    @FXML
    private TableColumn<Aluno, Integer> colunaIdade;

    @FXML
    private TableColumn<Aluno, String> colunaCurso;

    @FXML
    private void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colunaCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));

        tabelaAlunos.setItems(listaAlunos);
    }

    @FXML
    private void adicionarAluno() {
        try {
            String nome = campoNome.getText();
            int idade = Integer.parseInt(campoIdade.getText());
            String curso = comboCurso.getValue();

            if (nome == null || nome.isEmpty() || curso == null) {
                return;
            }

            listaAlunos.add(new Aluno(nome, idade, curso));
            campoNome.clear();
            campoIdade.clear();
            comboCurso.setValue(null);
        } catch (NumberFormatException ex) {
            // poderia mostrar alerta
        }
    }

    @FXML
    private void excluirAluno() {
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            listaAlunos.remove(selecionado);
        }
    }

    @FXML
    private void voltar() {
        MainApp.voltarMenu();
    }
}
