package appcocina.implementacionfundamentosingsw;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloController {

    @FXML
    TextField usuario;
    @FXML
    PasswordField contrasena;
    @FXML
    JFXButton Iniciar;
    @FXML
    JFXButton crear;
    @FXML
    JFXTextArea txa_iniciar;
    @FXML
    protected void iniciarsesion(ActionEvent event) throws IOException {
        if(event.getSource() == Iniciar){
            ManejadorArchivos man = new ManejadorArchivos();
            ContUsuario contUsuario = man.leerUsuarios();
            try {
                if (Correcto(usuario.getText(), contrasena.getText(), contUsuario)) {
                    try {
                        Stage stage = (Stage) usuario.getScene().getWindow();
                        stage.close();
                        Stage profesorStage = new Stage();
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazU.fxml")));
                        profesorStage.setTitle("Menu.");
                        profesorStage.setScene(new Scene(root));
                        profesorStage.show();
                    } catch (Exception ignored){}
                } else {
                    txa_iniciar.setText("Usuario o Contraseña incorrectos");
                }
            } catch (Exception e) {
                txa_iniciar.setText("Usuario o Contraseña incorrectos");
            }
        }
    }
    @FXML
    protected void crearCuenta(ActionEvent event) throws IOException {
        if(event.getSource() == crear){
            try {
                Stage stage = (Stage) usuario.getScene().getWindow();
                stage.close();
                Stage profesorStage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazRegistroUsuario.fxml")));
                profesorStage.setTitle("Registro.");
                profesorStage.setScene(new Scene(root));
                profesorStage.show();
            }catch(Exception ignored){}
        }
    }
    protected boolean Correcto(String Usuario, String Contrasena, ContUsuario a){

        if(Usuario.equals(a.buscarUsuario(Usuario).getNombre()))
            return Contrasena.equals(a.buscarContrasena(Contrasena).getContrasena());
        return false;
    }

}