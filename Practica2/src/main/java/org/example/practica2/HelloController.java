package org.example.practica2;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

import static org.example.practica2.HelloApplication.conexion;

public class HelloController {
    public static Estudiante editarEstudiante;
    @FXML
    private Button guardar;

    @FXML
    private Button botonEditar;

    @FXML
    private Button botonEliminar;
    @FXML
    private Button botonGuardar;

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

    private Connection connection() {
        return conexion;
    }

    public void consultaBases() {
        String query = "SELECT * FROM estudiantes";
        Statement stmt;
        ResultSet respuesta;

        try {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()) {
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");
                System.out.println("NIA: " + nia + " - Nombre: " + nombre + " - Fecha de nacimiento: " + fecha_nacimiento);
                listaEstudiantes.add(new Estudiante(nia, nombre, fecha_nacimiento.toLocalDate()));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {
        botonGuardar.setDisable(true);
        tablaEstudiantes.getItems().clear();
        consultaBases();
        columnaNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        columnaNia.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNia()).asObject());
        columnaFechaNacimiento.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(data.getValue().getFecha_nacimiento())
        );
        tablaEstudiantes.setItems(listaEstudiantes);
    }

    @FXML
    public void insertarEstudiante() {
        String nombre = introducirNombre.getText();
        int nia = 0;
        LocalDate fechaNacimiento = fecha.getValue();

        try {
            nia = Integer.parseInt(introducirNia.getText());
        } catch (NumberFormatException e) {
            System.out.println("NIA inválido.");
        }

        String query = "INSERT INTO estudiantes (nia, nombre, fecha_nacimiento) VALUES (" + nia + ",'" + nombre + "','" + java.sql.Date.valueOf(fechaNacimiento) + "');";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
            listaEstudiantes.add(new Estudiante(nia, nombre, fechaNacimiento));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        introducirNombre.clear();
        introducirNia.clear();
        fecha.setValue(null);
        initialize();

    }

    public void borrarEstudiante(Estudiante estudiante) {
        int nia = Integer.parseInt(String.valueOf(estudiante.getNia()));
        String nombre = String.valueOf(estudiante.getNombre());
        LocalDate fechaNacimiento = Date.valueOf(estudiante.getFecha_nacimiento()).toLocalDate();

        String query = "DELETE FROM estudiantes WHERE nia = " + nia + " and nombre = '" + nombre + "' and fecha_nacimiento = '" + fechaNacimiento + "'";
        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        initialize();
    }

    @FXML
    public void botonEliminar() {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            borrarEstudiante(seleccionado);
        } else {
            System.out.println("No hay ninguna fila seleccionada.");
        }
    }

    @FXML
    public void botonEditar() {
        guardar.setDisable(true);
        botonGuardar.setDisable(false);

        editarEstudiante = tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (editarEstudiante != null) {
            introducirNia.setText(String.valueOf(editarEstudiante.getNia()));
            introducirNombre.setText(editarEstudiante.getNombre());
            fecha.setValue(editarEstudiante.getFecha_nacimiento());

        } else {
            System.out.println("No hay ninguna fila seleccionada.");
        }
    }

    public void guardarEstudiante() {
        int nia = Integer.parseInt(introducirNia.getText());
        String nombre = introducirNombre.getText();
        LocalDate fechaNacimiento = fecha.getValue();

        String query = "UPDATE estudiantes SET nombre = '" + nombre + "', nia=" + nia + ",fecha_nacimiento='" + fechaNacimiento + "' " +
                "WHERE nombre = '" + editarEstudiante.getNombre() + "' and nia=" + editarEstudiante.getNia() + " and fecha_nacimiento = '" + editarEstudiante.getFecha_nacimiento() + "'";

        Statement stmt;
        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        guardar.setDisable(false);
        botonGuardar.setDisable(true);

        initialize();
    }
}
