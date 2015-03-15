package com.github.commissionergordon.scheduler.gui.client;

import com.github.commissionergordon.scheduler.gui.client.calendar.DayPane;
import com.github.commissionergordon.scheduler.gui.client.calendar.WeekPane;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.chrono.GregorianChronology;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.chrono.Chronology;
import java.util.Locale;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

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
	TitledPane sundayPane;

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
	@FXML
	ListView<String> sundayListView;


	@FXML
	ListView timeListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initListViews();

		timeListView.setItems(getTimeList());
		setWeekHeaders(LocalDate.now());
		fillWithBlankLines();
	}

	private void setWeekHeaders(LocalDate date) {
		LocalDate monday, tuesday, wednesday, thursday, friday, saturday, sunday;

		monday = date.withDayOfWeek(DateTimeConstants.MONDAY);
		tuesday = date.withDayOfWeek(DateTimeConstants.TUESDAY);
		wednesday = date.withDayOfWeek(DateTimeConstants.WEDNESDAY);
		thursday = date.withDayOfWeek(DateTimeConstants.THURSDAY);
		friday = date.withDayOfWeek(DateTimeConstants.FRIDAY);
		saturday = date.withDayOfWeek(DateTimeConstants.SATURDAY);
		sunday = date.withDayOfWeek(DateTimeConstants.SUNDAY);

		mondayPane.textProperty().set(monday.toString());
		tuesdayPane.textProperty().set(tuesday.toString());
		wednesdayPane.textProperty().set(wednesday.toString());
		thursdayPane.textProperty().set(thursday.toString());
		fridayPane.textProperty().set(friday.toString());
		saturdayPane.textProperty().set(saturday.toString());
		sundayPane.textProperty().set(sunday.toString());
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

	private void initListViews() {
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
