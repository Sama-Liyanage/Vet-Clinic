package Controller;

import Model.Employee;
import Model.Role;
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
import java.util.Locale;

public class DeleteEmployeeFormController {
    public ImageView searchLabel;
    public TextField employeeIdText;
    public TextArea addressText;
    public TextField emailText;
    public TextField phoneText;
    public TextField lastNameText;
    public Label deleteEmployeeLabel;
    public TextField firstNameText;
    public Label forepawLabel;
    public ImageView forepawLogo;
    public Label addEmployeeLabel;
    public Label updateEmployeeLabel;
    public Label viewEmployeesLabel;
    public Label warningLabel;
    public TextField roleText;

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
    protected void addEmployeeMouseClicked() {
        try {
            Stage stage = (Stage) addEmployeeLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddEmployeeForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateEmployeeMouseClicked() {
        try {
            Stage stage = (Stage) updateEmployeeLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/UpdateEmployeeForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void deleteEmployeeMouseClicked() {
        if (!firstNameText.getText().trim().equals("") && !employeeIdText.getText().trim().equals("")) {
            //checking firstname and employeeId is enough since we get all the values non editable
            try {
                boolean status = EmployeeController.deleteEmployee(employeeIdText.getText().trim());
                warningLabel.setTextFill(Color.GREEN);
                warningLabel.setText("Employee deleted");
                //set parameters null
                employeeIdText.setText("");
                firstNameText.setText("");
                lastNameText.setText("");
                phoneText.setText("");
                emailText.setText("");
                addressText.setText("");
                roleText.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setTextFill(Color.RED);
            warningLabel.setText("No employee.");
        }
    }

    @FXML
    protected void viewEmployeesMouseClicked() {
        try {
            Stage stage = (Stage) viewEmployeesLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/viewEmployeesForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void searchMouseClicked() {
        String employeeId = employeeIdText.getText().trim().toLowerCase();
        warningLabel.setTextFill(Color.RED);
        if (employeeId.equals("")) {
            warningLabel.setText("Employee Id is null.");
        } else {
            try {
                Employee employee = null;
                employee = EmployeeController.searchEmployee(employeeId);
                if (employee != null) {
                    String roleId = employee.getRoleId();
                    Role role = RoleController.searchRole(roleId);
                    firstNameText.setText(employee.getFirstName());
                    lastNameText.setText(employee.getLastName());
                    phoneText.setText(employee.getPhone());
                    emailText.setText(employee.getEmail());
                    addressText.setText(employee.getAddress());
                    roleText.setText(role.getRoleId()+" - "+role.getRoleName());
                } else {
                    warningLabel.setText("No such employee.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
