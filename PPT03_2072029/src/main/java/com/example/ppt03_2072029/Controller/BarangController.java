package com.example.ppt03_2072029.Controller;

import com.example.ppt03_2072029.Entity.Barang;
import com.example.ppt03_2072029.Entity.Supplier;
import com.example.ppt03_2072029.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BarangController {
    private Stage stage;
    @FXML
    private TableView<Barang> tableBarang;
    @FXML
    private TableColumn<String, Barang> colIdBarang;
    @FXML
    private TableColumn<String, Barang> colNamaBarang;
    @FXML
    private TableColumn<String, Barang> colSupplierBarang;
    @FXML
    private ComboBox<String> comboSupplier;
    @FXML
    private TextField txtIdBarang;
    @FXML
    private TextField txtNamaBarang;
    public Button btnSaveBarang;
    public Button btnResetBarang;
    public Button btnUpdateBarang;
    public ObservableList<Barang> bList;
    private ObservableList<Supplier> sList;
    private ObservableList<String> SupplierList;



    public void initialize() {
        stage = new Stage();

        bList = FXCollections.observableArrayList();
        tableBarang.setItems(bList);
        colIdBarang.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaBarang.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colSupplierBarang.setCellValueFactory(new PropertyValueFactory<>("supplier"));
    }
    public void ShowSupplier(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("supplier-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Data Barang");
        stage.setScene(scene);
        stage.showAndWait();

        SupplierList = FXCollections.observableArrayList();
        SupplierController addController = fxmlLoader.getController();
        sList = addController.getsList();
        for(Supplier supplier : sList){
            SupplierList.add(supplier.getNama());
        }
        comboSupplier.setItems(SupplierList);
        comboSupplier.getSelectionModel().select(0);
    }

    public void SaveBarang(ActionEvent actionEvent) {
        String bId = txtIdBarang.getText();
        String bNama = txtNamaBarang.getText();
        String bSupplier = comboSupplier.getValue();
        bList.add(new Barang(bId, bNama, bSupplier));
    }

    public void ResetBarang(ActionEvent actionEvent) {
        txtIdBarang.clear();
        txtNamaBarang.clear();
        txtIdBarang.setDisable(false);
        comboSupplier.getSelectionModel().select(0);
    }

    public void UpdateBarang(ActionEvent actionEvent) {
        String bId = txtIdBarang.getText();
        String bNama = txtNamaBarang.getText();
        String bSupplier = comboSupplier.getValue();
        bList.set(tableBarang.getSelectionModel().getSelectedIndex(), new Barang(bId, bNama, bSupplier));
    }

    public void ClickBarang(MouseEvent mouseEvent) {
        txtIdBarang.setText(tableBarang.getSelectionModel().getSelectedItem().getId());
        txtIdBarang.setDisable(true);
        txtNamaBarang.setText(tableBarang.getSelectionModel().getSelectedItem().getNama());
        comboSupplier.setValue(tableBarang.getSelectionModel().getSelectedItem().getSupplier());
    }

    public void CloseBarang(ActionEvent actionEvent) {
        txtIdBarang.getScene().getWindow().hide();
    }
}