package com.github.commissionergordon.scheduler.gui.client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

	@FXML
	DatePicker displayDate;

	@FXML
	TitledPane monthYearPane;

	@FXML
	ListView timeListView;

	@FXML
	TitledPane sundayPane;
	@FXML
	TitledPane mondayPane;
	@FXML
	TitledPane tuesdayPane;
	@FXML
	TitledPane wednesdayPane;
	@FXML
	TitledPane thursdayPane;
	@FXML
	TitledPane fridayPane;
	@FXML
	TitledPane saturdayPane;

	@FXML
	ListView<String> sundayListView;
	@FXML
	ListView<String> mondayListView;
	@FXML
	ListView<String> tuesdayListView;
	@FXML
	ListView<String> wednesdayListView;
	@FXML
	ListView<String> thursdayListView;
	@FXML
	ListView<String> fridayListView;
	@FXML
	ListView<String> saturdayListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancelClickEvents();

		// Sets the date picker's date
		displayDate.setValue(LocalDate.now());
		setDates(displayDate.getValue());

		// Fills in the times to the left of the dates and the blank lines in the days
		timeListView.setItems(getTimeList());
		fillWithBlankLines();

		// Tells the date picker what to do when a date is selected
		displayDate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(displayDate.getValue() != null) {
					setDates(displayDate.getValue());
				}
			}
		});
	}

	// Adds events to the list views to cancel the user's selection
	private void cancelClickEvents() {
		timeListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						timeListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		mondayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						mondayListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		tuesdayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						tuesdayListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		wednesdayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						wednesdayListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		thursdayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						thursdayListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		fridayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						fridayListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		saturdayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						saturdayListView.getSelectionModel().select(-1);
					}
				});
			}
		});

		sundayListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				Platform.runLater(new Runnable() {
					public void run() {
						sundayListView.getSelectionModel().select(-1);
					}
				});
			}
		});
	}

	// Populates all the needed titled panes with their dates
	private void setDates(LocalDate date) {
		LocalDate sunday, monday, tuesday, wednesday, thursday, friday, saturday;

		// Sets the day of the week
		int dayOfWeek = date.getDayOfWeek().getValue();

		sunday = dayOfWeek == 7 ? date : date.minusDays(dayOfWeek);
		monday = sunday.plusDays(1);
		tuesday = monday.plusDays(1);
		wednesday = tuesday.plusDays(1);
		thursday = wednesday.plusDays(1);
		friday = thursday.plusDays(1);
		saturday = friday.plusDays(1);

		// Sets the text of the day headers
		sundayPane.textProperty().set(getDayText(sunday) + " " + sunday.getDayOfMonth());
		mondayPane.textProperty().set(getDayText(monday) + " " + monday.getDayOfMonth());
		tuesdayPane.textProperty().set(getDayText(tuesday) + " " + tuesday.getDayOfMonth());
		wednesdayPane.textProperty().set(getDayText(wednesday) + " " + wednesday.getDayOfMonth());
		thursdayPane.textProperty().set(getDayText(thursday) + " " + thursday.getDayOfMonth());
		fridayPane.textProperty().set(getDayText(friday) + " " + friday.getDayOfMonth());
		saturdayPane.textProperty().set(getDayText(saturday) + " " + saturday.getDayOfMonth());

		// Sets the month and year titled pane
		String month = sunday.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = sunday.getYear();
		monthYearPane.setText(month + " " + year);
	}

	private void fillWithBlankLines() {
		mondayListView.setItems(getEmptyList());
		tuesdayListView.setItems(getEmptyList());
		wednesdayListView.setItems(getEmptyList());
		thursdayListView.setItems(getEmptyList());
		fridayListView.setItems(getEmptyList());
		saturdayListView.setItems(getEmptyList());
		sundayListView.setItems(getEmptyList());
	}

	private String getDayText(LocalDate date) {
		return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}

	private ObservableList<String> getTimeList() {
		return FXCollections.observableArrayList("12:00am", "", "1:00am", "", "2:00am", "", "3:00am", "", "4:00am", "",
				"5:00am", "", "6:00am", "", "7:00am", "", "8:00am", "", "9:00am", "", "10:00am", "", "11:00am", "",
				"12:00pm", "", "1:00pm", "", "2:00pm", "", "3:00pm", "", "4:00pm", "", "5:00pm", "", "6:00pm", "",
				"7:00pm", "", "8:00pm", "", "9:00pm", "", "10:00pm", "", "11:00pm", "");
	}

	private ObservableList<String> getEmptyList() {
		ObservableList<String> emptyList = FXCollections.observableArrayList();
		for(int i = 0; i < 48; i++) {
			emptyList.add("");
		}

		return emptyList;
	}
}
