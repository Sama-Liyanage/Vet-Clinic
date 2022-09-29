package Controller;

import Model.Payment;
import Model.Role;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AddPaymentFormController implements Initializable {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label updateCustomerLabel;
    public Label viewCustomersLabel;
    public Label deleteCustomerLabel;
    public Label addCustomerLabel;
    public TextField firstNameText;
    public TextField lastNameText;
    public TextField phoneText;
    public TextField emailText;
    public TextArea addressText;
    public TextField customerIdText;
    public Label warningLabel;
    public TextField dateText;
    public TextField paymentIdText;
    public TextField customerNameText;
    public Label priceText;
    public Label addPayementLabel;
    public TextField date;
    public TextField price;
    public TextField appointmentNumber;

    public void forepawLogoClicked(MouseEvent mouseEvent) {
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

    public void forepawLabelClicked(MouseEvent mouseEvent) {
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

    public void addPaymentMouseClicked(MouseEvent mouseEvent) {
        String paymentId = paymentIdText.getText().trim().toLowerCase();
        if (!paymentId.equals("")) {
            String  customerId=customerIdText.getText().trim();
            String customerName=customerNameText.getText().trim();
            String AppointmentNo=appointmentNumber.getText().trim();
            String date =dateText.getText().trim();
            if (!customerId.equals("") && !customerName.equals("") && !AppointmentNo.equals("")) {
                Payment payment = new Payment(paymentId, customerId, customerName,AppointmentNo,date,Double.parseDouble(price.getText()));
                try {
                    boolean status = PaymentController.addPayment(payment);
                    if (status == true) {
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Payment added.");
                        String val = VetClinicMethods.getNewId("r", "payment");
                        if (val != null) {
                            customerIdText.setText(val);
                        } else {
                            customerIdText.setText("");
                        }
                        customerNameText.setText(null);
                        appointmentNumber.setText(null);
                        dateText.setText(null);
                    } else {
                        warningLabel.setTextFill(Color.RED);
                        warningLabel.setText("Payment could not be added");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                warningLabel.setText("There are null claims");
            }
        } else {
            warningLabel.setText("Appointment Id is null");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        dateText.setText(f.format(date));
    }
}
