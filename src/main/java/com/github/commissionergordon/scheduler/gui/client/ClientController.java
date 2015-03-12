package com.github.commissionergordon.scheduler.gui.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

	@FXML
	HBox dayView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void addDefaultDay() {
		TitledPane pane = new TitledPane();
		pane.textProperty().set(LocalDate.now().toString());

		DayPane dayPane = new DayPane();
		dayPane.setDate(LocalDate.now());
		dayView.getChildren().addAll(dayPane);
		System.out.println(dayView.getChildren().size());
	}
}
