package com.github.commissionergordon.scheduler.gui.client.calendar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;

public class DayPane extends VBox {

	@FXML
	TitledPane titledPane;

	public DayPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/client/calendar/DayPane.fxml"));
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void setDate(LocalDate date) {
		titledPane.textProperty().set(date.toString());
	}
}
