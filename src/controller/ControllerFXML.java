package controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerFXML implements Initializable{

    @FXML
    private Text textAngle;

    @FXML
    private Slider sliderAngle;

    @FXML
    private TextField textTransparence;

    @FXML
    private Slider sliderTransparence;

    @FXML
    private Spinner<Integer> spinnerHigth;

    @FXML
    private Spinner<Integer> spinnerWidth;

    @FXML
    private Spinner<Integer> spinnerIteration;

    @FXML
    private ImageView imagetoModified;

    @FXML
    private  CheckBox  checkBoxblurEffect;

    private Image imageBase;

    @FXML
    void setAngleImageView(MouseEvent event) {
        textAngle.setText(Double.toString(sliderAngle.getValue()));
        imagetoModified.setRotate(sliderAngle.getValue());

    }

    @FXML
     void setTransparencyImageview(MouseEvent event) {
        textTransparence.setText(Double.toString(sliderTransparence.getValue()));
        imagetoModified.setOpacity(sliderTransparence.getValue()/100);
    }

    @FXML
    void blurOn (ActionEvent event) {
        if (checkBoxblurEffect.isSelected()){
            spinnerHigth.setDisable(false);
            spinnerIteration.setDisable(false);
            spinnerWidth.setDisable(false);
            BoxBlur bb = new BoxBlur();
            bb.setWidth(spinnerWidth.getValue());
            bb.setHeight(spinnerHigth.getValue());
            bb.setIterations(spinnerIteration.getValue());
            imagetoModified.setEffect(bb);
        }
        else {
            spinnerHigth.setDisable(true);
            spinnerIteration.setDisable(true);
            spinnerWidth.setDisable(true);
            BoxBlur bb = new BoxBlur();
            bb.setWidth(0);
            bb.setHeight(0);
            bb.setIterations(0);
            imagetoModified.setEffect(bb);
        }

    }

    @FXML
     void blurOnImage (MouseEvent event) {
        BoxBlur bb = new BoxBlur();
        bb.setWidth(spinnerWidth.getValue());
        bb.setHeight(spinnerHigth.getValue());
        bb.setIterations(spinnerIteration.getValue());
        imagetoModified.setEffect(bb);

    }


    @FXML
     void resetAllValues (ActionEvent event) {
        checkBoxblurEffect.setSelected(false);
        if (!checkBoxblurEffect.isSelected()){
            spinnerHigth.setDisable(true);
            spinnerIteration.setDisable(true);
            spinnerWidth.setDisable(true);
        }
        sliderAngle.setValue(0);
        sliderTransparence.setValue(0);
        BoxBlur bb = new BoxBlur();
        bb.setWidth(0);
        bb.setHeight(0);
        bb.setIterations(0);
        imagetoModified.setEffect(bb);


    }
    @FXML
     void quitApp (ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Avertissement");
        alert.setHeaderText("Quitter");
        alert.setContentText("Voulez-vous Quitter le programme?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imagetoModified.setImage(new Image("/ressource/Javafx_logo_color.png"));
        imagetoModified.setPreserveRatio(true);
        imagetoModified.setFitHeight(200);

        sliderAngle.valueProperty().addListener(((observable, oldValue, newValue) -> {
            textAngle.setText(String.valueOf((int)sliderAngle.getValue()));
            imagetoModified.setRotate(sliderAngle.getValue());
        }));
        sliderTransparence.valueProperty().addListener(((observable, oldValue, newValue) -> {
            textTransparence.setText(String.valueOf((int)sliderTransparence.getValue()));
            imagetoModified.setOpacity((100-sliderTransparence.getValue())/100);
        }
        ));


    }

}
