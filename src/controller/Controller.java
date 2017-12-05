package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label countLabel;

	@FXML
	private JFXButton btnSkip;

	@FXML
	private Label lblSkippedTuto;

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
	}

	int showSlide = 0;

	@FXML
	void nextAction(ActionEvent event) {
		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");
		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
		}

	}

	@FXML
	void skipIntroAndCloseApp(ActionEvent event) {
		translateAnimation(0.5, pane2, -600);
		translateAnimation(1, pane3, -600);
		lblSkippedTuto.setText("You skipped the intro D:");
		System.exit(0);
	}

	@FXML
	void closeApp(ActionEvent event) {
		System.exit(0);
	}
}
