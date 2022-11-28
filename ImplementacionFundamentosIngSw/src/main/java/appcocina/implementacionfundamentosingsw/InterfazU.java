package appcocina.implementacionfundamentosingsw;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class InterfazU {
    @FXML
    private AnchorPane ap_panes;
    @FXML
    private JFXButton abrir,atras, atras1,atras11,atras1111, atras11111,btn_calServ,btn_consConfiguracion, btn_consRut,btn_crearCom,btn_prgRuta,btn_progRut,btn_upValCom, btn_buscarRecetas, btn_upValCom1,btn_Recetas,cerrar;

    @FXML
    private Pane pnl_calServ,pnl_consRut,pnl_crearCom,pnl_menu,pnl_opacidad,pnl_progRut,pnl_recetas;

    @FXML
    private JFXRadioButton rbtn_comNeg,rbtn_valNeg,rbtn_comPos,rbtn_valPos;

    @FXML
    private JFXTextArea txa_comVal, txa_coment,txa_consRut,txa_progRut, txa_valCom;

    @FXML
    private TextField txf_calID,txf_comID,txf_comID11,txf_crearComBus,txf_crearComID,txf_crearComRut,txf_progHL,txf_progLL,txf_progNum;
    @FXML protected void onMenuButtonClick(ActionEvent event) {
        if(event.getSource() == abrir){
            pnl_opacidad.toFront();
            pnl_menu.toFront();
        }
        if(event.getSource() == cerrar){
            pnl_opacidad.toBack();
            pnl_menu.toBack();
        }
        if(event.getSource()== btn_Recetas ){
            ap_panes.toFront();
            pnl_recetas.toFront();
        }
        if(event.getSource() == btn_calServ){
            ap_panes.toFront();
            pnl_calServ.toFront();
        }
        if(event.getSource() == btn_buscarRecetas){
            ap_panes.toFront();
            pnl_consRut.toFront();
        }
        if(event.getSource() == btn_consConfiguracion){
            ap_panes.toFront();
            pnl_consRut.toFront();
        }
        if(event.getSource()==btn_crearCom){
            ap_panes.toFront();
            pnl_crearCom.toFront();
        }
        if(event.getSource() == btn_progRut){
            ap_panes.toFront();
            pnl_progRut.toFront();
        }

        if(event.getSource()== atras){
            ap_panes.toBack();
        }
        if(event.getSource()== atras1){
            ap_panes.toBack();
        }
        if(event.getSource()== atras11){
            ap_panes.toBack();
        }
        if(event.getSource()== atras1111){
            ap_panes.toBack();
        }
        if(event.getSource()== atras11111){
            ap_panes.toBack();
        }
        /////////////////////////////////////////
        if(event.getSource() == btn_upValCom){
            try{
                if(txf_comID == null){
                    throw new Exception();
                }
                else{

                }
            }catch(Exception e){
                txa_valCom.setText("ID incorrecto");
            }
        }
    }
}
