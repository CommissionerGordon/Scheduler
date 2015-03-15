package com.github.commissionergordon.scheduler.gui.client.calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class WeekPane extends VBox {

	@FXML
	private TitledPane dayOnePane;

	@FXML
	private ListView<String> timeListView;

	public WeekPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/client/calendar/WeekPane.fxml"));
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
			timeListView.setItems(getTimeList());
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	private ObservableList<String> getTimeList() {
		return FXCollections.observableArrayList(
				"12:00am", "",
				"1:00am", "",
				"2:00am", "",
				"3:00am", "",
				"4:00am", "",
				"5:00am", "",
				"6:00am", "",
				"7:00am", "",
				"8:00am", "",
				"9:00am", "",
				"10:00am", "",
				"11:00am", "",
				"12:00pm", "",
				"1:00pm", "",
				"2:00pm", "",
				"3:00pm", "",
				"4:00pm", "",
				"5:00pm", "",
				"6:00pm", "",
				"7:00pm", "",
				"8:00pm", "",
				"9:00pm", "",
				"10:00pm", "",
				"11:00pm", ""
		);
	}
}
