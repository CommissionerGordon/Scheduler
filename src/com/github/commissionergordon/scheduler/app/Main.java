package com.github.commissionergordon.scheduler.app;

import com.github.commissionergordon.scheduler.container.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.catalina.LifecycleException;

import java.io.IOException;

public class Main extends Application {
    
    private static Thread serverThread;
    private static ServerRunnable serverRunnable;
    private static Server server;
    private static Stage stage;
    
    public static void main(String[] args) throws IOException, LifecycleException {
        server = new Server();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/window.fxml"));
        primaryStage.setTitle("Scheduler Server");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        Main.stage = primaryStage;
    }

    public static Thread getServerThread() {
        return serverThread;
    }
    
    public static void setServerThread(Thread thread) {
        serverThread = thread;
    }
    
    public static Server getServer() {
        return server;
    }
}
