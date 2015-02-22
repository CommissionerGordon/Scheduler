package com.github.commissionergordon.scheduler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import java.io.IOException;

public class Main extends Application {

    private static Server server;
    private static final String dbConnection = "jdbc:h2:./db/scheduler";
    private static final String dbUser = "sa";

    private static final String webappDir = "webapp/";

    //TODO: Make sure the constraint tables' constraint_id's are replaced with activity_id's

    public static void main(String[] args) throws IOException, LifecycleException, ServletException {
        server = new Server();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/window.fxml"));
        primaryStage.setTitle("Scheduler Server");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static Server getServer() {
        return server;
    }

    public static String getWebappDir() {
        return webappDir;
    }

    public static String getDBConnectionString() {
        return dbConnection;
    }

    public static String getDbUser() {
        return dbUser;
    }
}
