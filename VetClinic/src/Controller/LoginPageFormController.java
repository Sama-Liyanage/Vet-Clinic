package Controller;


import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageFormController {
    public Label loginButton;
    public PasswordField passwordText;
    public TextField usernameText;
    public Label warningLabel;

    @FXML
    protected void onLoginButtonClicked() {
        if (usernameText.getText().trim().equals("") || passwordText.getText().trim().equals("")) {
            warningLabel.setText("Fill the empty fields.");
        } else {
            User user = new User(usernameText.getText(), passwordText.getText());
            try {
                boolean checkUser = UserController.checkUser(user);
                if (checkUser == true) {

                    if(usernameText.getText().equalsIgnoreCase("Receptionist")){
                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/HomePageForm.fxml"));
                        Parent parent = loader.load();
                        HomePageFormController controller = loader.<HomePageFormController>getController();
                        controller.addEmployee.setDisable(true);
                        controller.updateEmployee.setDisable(true);
                        controller.viewEmployees.setDisable(true);
                        controller.deleteEmployee.setDisable(true);
                        controller.addRole.setDisable(true);
                        controller.updateRole.setDisable(true);
                        controller.viewRoles.setDisable(true);
                        controller.deleteRole.setDisable(true);
                        controller.addUser.setDisable(true);


                        Stage stage=new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
                    }else if (usernameText.getText().equalsIgnoreCase("Admin")){
                        Stage stage = (Stage) loginButton.getScene().getWindow();
                        stage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HomePageForm.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        stage.setScene(scene);
                        stage.show();
                    }

                } else {
                    warningLabel.setText("Invalid credentials.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
