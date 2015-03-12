package com.github.commissionergordon.scheduler.gui.client;

import com.github.commissionergordon.scheduler.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import java.io.IOException;

public class ClientMain extends Application {
	public static void main(String[] args) throws IOException, LifecycleException, ServletException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/client/client.fxml"));
		primaryStage.setTitle("Client");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
