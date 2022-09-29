package Controller;


import Model.Appointment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RemoveAppointmentFormController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addAppointmentLabel;
    public Label removeAppointmentLabel;
    public TextField appointmentIdText;
    public Label warningLabel;

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
    protected void addAppointmentMouseClicked() {
        try {
            Stage stage = (Stage) addAppointmentLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddAppointmentForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void removeAppointmentMouseClicked() {
        String appointmentId = appointmentIdText.getText().trim().toLowerCase();
        if (!appointmentId.equals("")) {
            try {
                Appointment appointment = AppointmentController.searchAppointment(appointmentId);
                if(appointment!=null){
                    boolean status = AppointmentController.deleteAppointment(appointmentId);
                    if(status==true){
                        warningLabel.setTextFill(Color.GREEN);
                        warningLabel.setText("Appointment deleted");
                    }else{
                        warningLabel.setTextFill(Color.RED);
                        warningLabel.setText("Could not delete the appointment");
                    }
                }else{
                    warningLabel.setText("No appointments with that id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setText("appointment id is null");
        }
    }

    public void searchMouseClicked(MouseEvent mouseEvent) {
    }
}
