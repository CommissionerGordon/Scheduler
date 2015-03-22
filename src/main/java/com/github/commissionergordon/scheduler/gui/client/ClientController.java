package com.github.commissionergordon.scheduler.gui.client;

import com.github.commissionergordon.scheduler.classes.Activity;
import com.github.commissionergordon.scheduler.classes.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

	// Left Pane
	@FXML
	TextField textStartTime;

	@FXML
	TextField textDuration;

	@FXML
	ColorPicker cpColorPicker;

	@FXML
	Button btnClear;

	// Main Content Pane
	@FXML
	DatePicker displayDate;

	@FXML
	Button btnAddActivity;

	@FXML
	Button btnRemoveActivity;

	@FXML
	TitledPane monthYearPane;

	@FXML
	ListView timeListView;

	@FXML
	TitledPane sundayHeader;
	@FXML
	TitledPane mondayHeader;
	@FXML
	TitledPane tuesdayHeader;
	@FXML
	TitledPane wednesdayHeader;
	@FXML
	TitledPane thursdayHeader;
	@FXML
	TitledPane fridayHeader;
	@FXML
	TitledPane saturdayHeader;

	@FXML
	Pane sundayPane;
	@FXML
	Pane mondayPane;
	@FXML
	Pane tuesdayPane;
	@FXML
	Pane wednesdayPane;
	@FXML
	Pane thursdayPane;
	@FXML
	Pane fridayPane;
	@FXML
	Pane saturdayPane;

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
		cpColorPicker.setValue(Color.RED);

		cancelClickEvents();

		// Sets the date picker's date
		displayDate.setValue(LocalDate.now());
		setDayDates(displayDate.getValue());

		// Fills in the times to the left of the dates and the blank lines in the days
		timeListView.setItems(getTimeList());
		fillWithBlankLines();

		// Tells the date picker what to do when a date is selected
		displayDate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(displayDate.getValue() != null) {
					setDayDates(displayDate.getValue());
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
	private void setDayDates(LocalDate date) {
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
		sundayHeader.textProperty().set(getDayText(sunday) + " " + sunday.getDayOfMonth());
		mondayHeader.textProperty().set(getDayText(monday) + " " + monday.getDayOfMonth());
		tuesdayHeader.textProperty().set(getDayText(tuesday) + " " + tuesday.getDayOfMonth());
		wednesdayHeader.textProperty().set(getDayText(wednesday) + " " + wednesday.getDayOfMonth());
		thursdayHeader.textProperty().set(getDayText(thursday) + " " + thursday.getDayOfMonth());
		fridayHeader.textProperty().set(getDayText(friday) + " " + friday.getDayOfMonth());
		saturdayHeader.textProperty().set(getDayText(saturday) + " " + saturday.getDayOfMonth());

		setMonthYearDate(sunday);
	}

	// Sets the month and year titled pane
	private void setMonthYearDate(LocalDate date) {
		String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = date.getYear();
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

	@FXML
	public void addActivity() {
		User user = new User(1, "Kyle");
		Activity activity = new Activity(1, user, "Test Activity", LocalTime.of(getHours(textDuration), getMinutes(textDuration)));
		activity.startTime = LocalTime.of(getHours(textStartTime), getMinutes(textStartTime));
		sundayPane.getChildren().add(createRegion(activity, cpColorPicker.getValue()));

		System.out.println("Start Time >> " + getHours(textStartTime) + ":" + getMinutes(textStartTime));
		System.out.println("Duration >> " + getHours(textDuration) + ":" + getMinutes(textDuration));
	}

	private Region createRegion(Activity activity, Color color) {
		Region region = createBaseRegion(color);
		region.setPrefSize(121, (double) activity.duration.getHour() * 48 + (double) activity.duration.getMinute() * 48.0 / 60.0);
		region.setLayoutX(10);
		region.setLayoutY((double) activity.startTime.getHour() * 48 + (double) activity.startTime.getMinute() * 48.0 / 60.0);
		return region;
	}

	private Region createBaseRegion(Color color) {
		Region region = new Region();
		region.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
		region.setBorder(new Border(new BorderStroke(Paint.valueOf(color.toString()), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
		region.setOpacity(.5);
		return region;
	}

	private int getHours(TextField field) {
		String text = field.getText();
		if(!text.contains(":")) {
			return 0;
		}
		int colonIndex = text.indexOf(":");
		int hours = Integer.valueOf(text.substring(0, colonIndex));
		return hours;
	}

	private int getMinutes(TextField field) {
		String text = field.getText();
		if(!text.contains(":")) {
			return 0;
		}
		int colonIndex = text.indexOf(":");
		int minutes = Integer.valueOf(text.substring(colonIndex + 1));
		return minutes;
	}

	@FXML
	public void clear() {
		textStartTime.setText("");
		textDuration.setText("");
		cpColorPicker.setValue(Color.RED);
	}

}
