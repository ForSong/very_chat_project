package client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * 熊义杰
 * 注册界面
 */
public class Register extends Window {
    public Register() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Fxml/Register.fxml"));
        Scene scene = new Scene(root,600,639);
        initStyle(StageStyle.TRANSPARENT);
        setScene(scene);
        setTitle("Chat");
        move();
        setIcon();
    }

    public void setErrorTip(String id,String Text){
        ((Label) $(id)).setText(Text);
    }

    public void resetErrorTip(){
        ((Label) $("accountError")).setText("");
        ((Label) $("nameError")).setText("");
        ((Label) $("passwordError")).setText("");
        ((Label) $("rePasswordError")).setText("");
    }
    public void clear(){
        ((TextField) $("account")).clear();
        ((TextField) $("name")).clear();
        ((PasswordField) $("password")).clear();
        ((PasswordField) $("rePassword")).clear();
    }
    public void setHeadPortrait(Button button,String head){
        button.setStyle(String.format("-fx-background-image:url('View/Fxml/CSS/Image/%s.jpg')",head));
    }
}
