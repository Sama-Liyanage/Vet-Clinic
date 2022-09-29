package Controller;

import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class viewAppointmentFormController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addAppointmentLabel;
    public Label updateAppointmentLabel;
    public Label deleteAppointmentLabel;
    public TableView customerTable;
    public TableColumn col_AppointmentId;
    public TableColumn col_Customername;
    public TableColumn col_DoctorName;
    public TableColumn col_Date;
    public TableColumn col_Time;
    public TableView appointmentTable;


//    @FXML
//    public void initialize() {
//        try {
//            ArrayList<Customer> customers = CustomerController.getAllCustomers();
//            for(Customer customer:customers){
//                Object obj[] = {customer.getCustomerId(), customer.getFirstName()+" "+customer.getLastName(),customer.getEmail(),
//                        customer.getPhone(), customer.getAddress()};
//                customerTable.getItems().add(obj);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void forepawLogoClicked(MouseEvent mouseEvent) {
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

    public void forepawLabelClicked(MouseEvent mouseEvent) {
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

    public void addAppointmentMouseClicked(MouseEvent mouseEvent) {
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

    public void updateAppointmentMouseClicked(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) updateAppointmentLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/UpdateAppintmentForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointmentMouseClicked(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) deleteAppointmentLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RemoveAppoinmentForm.fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
