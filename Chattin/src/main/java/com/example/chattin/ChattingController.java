package com.example.chattin;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ChattingController implements Initializable {
    @FXML
    private JFXButton sendButton;

    @FXML
    private TextField textField;

    @FXML
    private AnchorPane cir1;

    @FXML
    private AnchorPane cir2;

    @FXML
    private AnchorPane cir3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendButton.setVisible(false);
        textField.setOnKeyReleased(keyEvent -> {
            if (textField.getText().isEmpty()) {
                sendButton.setVisible(false);
            } else {
                sendButton.setVisible(true);
            }
        });
        chattingAnimation();
    }

    public void chattingAnimation() {
        SlideToAnimationCycle(cir1, 0, -5, 0.3);
        PauseTransition pause = new PauseTransition(Duration.seconds(0.2));
        pause.play();
        pause.setOnFinished(actionEvent1 -> {
            SlideToAnimationCycle(cir2, 0, -5, 0.3);
            PauseTransition pause1 = new PauseTransition(Duration.seconds(0.2));
            pause1.play();
            pause1.setOnFinished(actionEvent2 -> {
                SlideToAnimationCycle(cir3, 0, -5, 0.3);
            });
        });
    }

    public static void SlideToAnimationCycle(javafx.scene.Node node, double slidePosX, double slidePosY, double seconds) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(seconds));
        slide.setNode(node);
        slide.setToX(slidePosX);
        slide.setToY(slidePosY);
        slide.play();
        slide.setOnFinished(actionEvent -> {
            TranslateTransition slide1 = new TranslateTransition(Duration.seconds(seconds));
            slide1.setNode(node);
            slide1.setToX(0);
            slide1.setToY(0);
            slide1.play();
            slide1.setOnFinished(actionEvent1 -> {
                PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
                pause.play();
                pause.setOnFinished(actionEvent2 -> {
                    slide.play();
                });
            });
        });
    }
}