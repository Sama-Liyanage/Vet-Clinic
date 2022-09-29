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
import java.util.ArrayList;

public class DeleteRoleFormController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label deleteRoleLabel;
    public TextField nameText;
    public TextArea descriptionText;
    public TextField roleIdText;
    public ImageView searchLabel;
    public Label viewRolesLabel;
    public Label updateRoleLabel;
    public Label addRoleLabel;
    public Label warningLabel;
    public TextField priorityText;
    private String rId;

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
    protected void addRoleMouseClicked() {
        try {
            Stage stage = (Stage) addRoleLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddRoleForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void updateRoleMouseClicked() {
        try {
            Stage stage = (Stage) updateRoleLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/UpdateRoleForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void deleteRoleMouseClicked() {
        if (!nameText.getText().equals("") && !priorityText.getText().equals("") && !descriptionText.getText().equals("")
                && rId.equals(roleIdText.getText().trim().toLowerCase()) && !rId.equals("r000") && !rId.equals("r001")) {
            String defaultRoleId = "r000";
            try {
                //first get employees with the particular role
                ArrayList<Employee> employeeList = EmployeeController.getAllEmployees(rId);
                if (employeeList.size() != 0) {
                    for (Employee employee : employeeList) {
                        boolean res = EmployeeController.updateEmployeeRole(employee, defaultRoleId);
                    }
                }
                boolean status = RoleController.deleteRole(rId);
                if (status == true) {
                    warningLabel.setTextFill(Color.GREEN);
                    warningLabel.setText("role deleted");
                    roleIdText.setText("");
                    nameText.setText("");
                    priorityText.setText("");
                    descriptionText.setText("");
                } else {
                    warningLabel.setTextFill(Color.RED);
                    warningLabel.setText("role can not be deleted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setText("Errors in claims");
        }
    }

    @FXML
    protected void viewRolesMouseClicked() {
        /*try {
            Stage stage = (Stage) viewRolesLabel.getScene().getWindow();
            stage.close();
            new ViewRolesPage().start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    protected void searchMouseClicked() {
        String roleId = roleIdText.getText().trim().toLowerCase();
        rId = roleId;
        if (!roleId.equals("")) {
            try {
                Role role = RoleController.searchRole(roleId);
                if (role != null) {
                    nameText.setText(role.getRoleName());
                    priorityText.setText(role.getRolePriority());
                    descriptionText.setText(role.getRoleDescription());
                } else {
                    warningLabel.setText("Invalid role id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setText("Role Id is null");
        }
    }
}
