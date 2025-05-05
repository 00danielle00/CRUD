package org.example.practica2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class HelloController {
    @FXML
    private TextField introducirNia;
    @FXML
    private TextField introducirNombre;
    @FXML
    private DatePicker fecha;
    
    @FXML
    private TableColumn<Estudiante, String> columnaNombre;
    @FXML
    private TableColumn<Estudiante, Integer> columnaNia;
    @FXML
    private TableColumn<Estudiante, LocalDate> columnaFechaNacimiento;
    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    private ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        columnaNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        columnaNia.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNia()).asObject());
        columnaFechaNacimiento.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFecha_nacimiento()));
        tablaEstudiantes.setItems(listaEstudiantes);

    }


    public void insertarEstudiante() {
        String nombre = introducirNombre.getText();
        int nia = 0;
        LocalDate fechaNacimiento = fecha.getValue();
        
        
        try {
             nia = Integer.parseInt(introducirNia.getText());
        } catch (NumberFormatException e) {
            System.out.println("NIA inválido.");
        }
        Estudiante estudiante = new Estudiante(nia, nombre, fechaNacimiento);

        listaEstudiantes.add(estudiante);

        introducirNia.clear();
        introducirNombre.clear();
        fecha.setValue(null);

    }
}
