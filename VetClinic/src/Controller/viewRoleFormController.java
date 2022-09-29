package Controller;

import Model.Customer;
import Model.Role;
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

public class viewRoleFormController {
    public ImageView forepawLogo;
    public Label forepawLabel;
    public Label addRoleLabel;
    public Label updateRoleLabel;
    public Label deleteRoleLabel;
    public TableView roleTable;
    public TableColumn col_rolid;
    public TableColumn col_rolename;
    public TableColumn col_priority;
    public TableColumn col_description;


    @FXML
    public void initialize() {
        try {
            ArrayList<Role> roles = RoleController.getAllRoles();
            for(Role role:roles){
                Object obj[] = {role.getRoleId(), role.getRoleName()+" "+role.getRolePriority(),role.getRoleDescription(),};
                roleTable.getItems().add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

    public void addRoleMouseClicked(MouseEvent mouseEvent) {
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

    public void updateRoleMouseClicked(MouseEvent mouseEvent) {
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

    public void deleteRoleMouseClicked(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) deleteRoleLabel.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/DeleteRoleForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}
