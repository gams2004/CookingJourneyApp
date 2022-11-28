package appcocina.implementacionfundamentosingsw;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorRegistroUsuario {
    @FXML
    TextField contrasena_txf;

    @FXML
    TextField correo_txf;

    @FXML
    TextField telefono_txf;

    @FXML
    TextField usuario_txf;
    @FXML
    JFXTextArea error_txt;
    @FXML
    private JFXButton btn_registrarse;

    public ControladorRegistroUsuario() {
    }

    @FXML protected void registrarse(ActionEvent event) throws IOException {
        if(event.getSource() == btn_registrarse){
            boolean cent = true;
            ContUsuario contUsuario = new ContUsuario();
            Usuario usuario = new Usuario();
            try {
                usuario.setNombre(usuario_txf.getText());
                usuario.setContrasena(contrasena_txf.getText());
                usuario.setCorreo(correo_txf.getText());
                usuario.setTelefono(Long.parseLong(telefono_txf.getText()));
                Dao dao= new UserDao();
                dao.registrar(usuario);
            } catch(Exception e){
                error_txt.setText("Ingreso de datos incorrecto D:");
                cent = false;
            }
            try {
                if(cent) {
                    contUsuario.agregarUsuario(usuario);
                    ManejadorArchivos.EscribirAArchivoTexto(contUsuario, usuario_txf.getText());
                }
            } catch (Exception e) {
                error_txt.setText("Problema registrando al usuario");
                cent = false;
            }
            try {
                if(cent) {
                    Stage stage = (Stage) usuario_txf.getScene().getWindow();
                    stage.close();
                    Stage profesorStage = new Stage();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazLogin.fxml")));
                    profesorStage.setTitle("Menu.");
                    profesorStage.setScene(new Scene(root));
                    profesorStage.show();
                }
            } catch (Exception ignored){}
        }
    }
}


