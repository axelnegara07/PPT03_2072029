package com.example.ppt03_2072029.Controller;

import com.example.ppt03_2072029.Entity.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SupplierController {

    public ObservableList<Supplier> sList;
    @FXML
    private TableView<Supplier> tableSupplier;
    @FXML
    private TableColumn<String, Supplier> colIdSupplier;
    @FXML
    private TableColumn<String, Supplier> colNamaSupplier;
    @FXML
    private TableColumn<String, Supplier> colAlamatSupplier;
    @FXML
    private TextField txtIdSupplier;
    @FXML
    private TextField txtNamaSupplier;
    @FXML
    private TextField txtAlamatSupplier;
    public Button btnSaveSupplier;
    public Button btnResetSupplier;
    public Button btnUpdateSuppplier;

    public SupplierController() {
    }


    public void initialize() {
        sList = FXCollections.observableArrayList();
        tableSupplier.setItems(sList);
        colIdSupplier.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaSupplier.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatSupplier.setCellValueFactory(new PropertyValueFactory<>("alamat"));
    }

    public void SaveSupplier(ActionEvent actionEvent) {
        String sId = txtIdSupplier.getText();
        String sNama = txtNamaSupplier.getText();
        String sAlamat = txtAlamatSupplier.getText();
        sList.add(new Supplier(sId, sNama, sAlamat));
    }

    public void ResetSupplier(ActionEvent actionEvent) {
        txtIdSupplier.clear();
        txtNamaSupplier.clear();
        txtAlamatSupplier.clear();
        txtIdSupplier.setDisable(false);
    }

    public void UpdateSupplier(ActionEvent actionEvent) {
        String bId = txtIdSupplier.getText();
        String bNama = txtNamaSupplier.getText();
        String sAlamat = txtAlamatSupplier.getText();
        sList.set(tableSupplier.getSelectionModel().getSelectedIndex(), new Supplier(bId, bNama, sAlamat));
    }

    public void ClickSupplier(MouseEvent mouseEvent) {
        txtIdSupplier.setText(tableSupplier.getSelectionModel().getSelectedItem().getId());
        txtIdSupplier.setDisable(true);
        txtNamaSupplier.setText(tableSupplier.getSelectionModel().getSelectedItem().getNama());
        txtAlamatSupplier.setText(tableSupplier.getSelectionModel().getSelectedItem().getAlamat());
    }

    public ObservableList<Supplier> getsList() {
        return sList;
    }

    public void setsList(ObservableList<Supplier> sList) {
        this.sList = sList;
    }

    public void CloseSupplier(ActionEvent actionEvent) {
        txtIdSupplier.getScene().getWindow().hide();
    }
}