package Modul1.controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Random;

public class Mod1 {

    @FXML
    private ImageView userpic;
    @FXML
    private ImageView cpupic;
    @FXML
    private TextField txtOutWin;
    @FXML
    private TextField txtOutLose;
    @FXML
    private TextField txtOutDraw;

    private Button exit;

    int draw = 0, win = 0, lose = 0, p=0, r = 0, s = 0;
    Image Paper = new Image("pic/paper.png");
    Image Rock = new Image("pic/rock.png");
    Image Scissor = new Image("pic/scissor.png");

    private String CPURand() {
        Random pc = new Random();

        int option = pc.nextInt(3);
        String opn = "";
        switch (option) {
            case 0:
                opn = "Paper";
                break;
            case 1:
                opn = "Rock";
                break;
            case 2:
                opn = "Scissors";
                break;
        }
        return opn;
    }
    @FXML
    private void SndPaper(ActionEvent ex) {
        userpic.setImage(Paper);
        switch (CPURand()) {
            case "Paper":
                cpupic.setImage(Paper);
                if (p < 1) {
                    draw++;
                    txtOutDraw.setText(Integer.toString(draw));
                }
                break;
            case "Rock":
                cpupic.setImage(Rock);
                if(p<1){
                    win++;
                    txtOutWin.setText(Integer.toString(win));
                }
                break;
            case "Scissors":
                cpupic.setImage(Scissor);
                if(p<1) {
                    lose++;
                    txtOutLose.setText(Integer.toString(lose));
                }
        }
        p++;
        r=0;
        s=0;
    }

    @FXML
    private void SndRock(ActionEvent ex) {
        userpic.setImage(Rock);
        switch (CPURand()) {
            case "Paper":
                cpupic.setImage(Scissor);
                if (r < 1) {
                    lose++;
                    txtOutLose.setText(Integer.toString(lose));
                }
                break;
            case "Rock":
                cpupic.setImage(Rock);
                if (r < 1) {
                    draw++;
                    txtOutDraw.setText(Integer.toString(draw));
                }
            case "Scissors":
                cpupic.setImage(Scissor);
                if (r < 1) {
                    win++;
                    txtOutWin.setText(Integer.toString(win));
                }
                r++;
                p=0;
                s=0;
        }
    }

    @FXML
    private void SndSci(ActionEvent ex) {
        userpic.setImage(Scissor);
        switch (CPURand()) {
            case "Paper":
                cpupic.setImage(Scissor);
                if (s < 1) {
                    win++;
                    txtOutWin.setText(Integer.toString(win));
                }
                break;
            case "Rock":
                cpupic.setImage(Rock);
                if (s < 1) {
                    lose++;
                    txtOutLose.setText(Integer.toString(lose));
                }
            case "Scissors":
                cpupic.setImage(Scissor);
                if (s < 1) {
                    draw++;
                    txtOutDraw.setText(Integer.toString(draw));
                }
        }
        s++;
        p=0;
        r=0;
    }

    @FXML
    private void exit(ActionEvent ex) {
        Stage term = (Stage) exit.getScene().getWindow();
        term.close();
    }
}
