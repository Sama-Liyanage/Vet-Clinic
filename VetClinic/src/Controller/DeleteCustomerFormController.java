package Controller;

import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteCustomerFormController {
    public ImageView searchLabel;
    public TextField customerIdText;
    public TextArea addressText;
    public TextField emailText;
    public TextField phoneText;
    public TextField lastNameText;
    public TextField firstNameText;
    public Label deleteCustomerLabel;
    public Label viewCustomersLabel;
    public Label updateCustomerLabel;
    public Label addCustomerLabel;
    public Label forepawLabel;
    public ImageView forepawLogo;
    public Label warningLabel;
    public String custId;

    @FXML
    protected void forepawLabelClicked() {
        try {
            Stage stage = (Stage) forepawLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HomePageForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void forepawLogoClicked() {
        try {
            Stage stage = (Stage) forepawLogo.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HomePageForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void addCustomerMouseClicked() {
        try {
            Stage stage = (Stage) addCustomerLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddCustomerForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateCustomerMouseClicked() {
        try {
            Stage stage = (Stage) updateCustomerLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/UpdateCustomerForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void deleteCustomerMouseClicked() {
        String customerId = customerIdText.getText().trim().toLowerCase();
        try {
            if(custId.equals(customerId)){
                boolean status = CustomerController.deleteCustomer(customerId);
                if(status==true){
                    warningLabel.setTextFill(Color.GREEN);
                    warningLabel.setText("customer added");
                    customerIdText.setText("");
                    firstNameText.setText("");
                    lastNameText.setText("");
                    addressText.setText("");
                    emailText.setText("");
                    phoneText.setText("");
                }else{
                    warningLabel.setTextFill(Color.RED);
                    warningLabel.setText("customer not added");
                }
            }else{
                warningLabel.setText("invalid details");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void viewCustomersMouseClicked() {
        try {
            Stage stage = (Stage) viewCustomersLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/viewCustomerForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void searchMouseClicked() {
        String customerId = customerIdText.getText().trim().toLowerCase();
        custId = customerId;
        if (customerId.equals("")) {
            warningLabel.setText("null customer id");
        } else {
            try {
                Customer customer = CustomerController.searchCustomer(customerId);
                if (customer == null) {
                    warningLabel.setText("Incorrect customer");
                } else {
                    firstNameText.setText(customer.getFirstName());
                    lastNameText.setText(customer.getLastName());
                    phoneText.setText(customer.getPhone());
                    emailText.setText(customer.getEmail());
                    addressText.setText(customer.getAddress());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
