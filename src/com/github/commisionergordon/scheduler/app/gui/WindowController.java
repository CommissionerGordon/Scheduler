package com.github.commisionergordon.scheduler.app.gui;

import com.github.commisionergordon.scheduler.app.Main;
import com.github.commisionergordon.scheduler.app.ServerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.catalina.LifecycleException;

import java.net.URL;
import java.util.ResourceBundle;

/*
For some reason, the server.isRunning() boolean is never changed. Could be
a thread thing, but I have no idea. All the things that depend on server.isRunning
have been commented out.
*/

public class WindowController implements Initializable{
    
    @FXML
    TextField portField;

    @FXML
    Button startButton;
    
    @FXML
    Button stopButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        portField.setText(Integer.toString(Main.getServer().getPort()));
        portField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    Integer.parseInt(newValue);
                    if (newValue.endsWith("f") || newValue.endsWith("d")) {
                        portField.setText(newValue.substring(0, newValue.length() - 1));
                    }
                } catch (NumberFormatException e) {
                    if(newValue.isEmpty()) {
                        portField.setText(newValue);
                    } else {
                        portField.setText(oldValue);
                    }
                }
                
                boolean disabled = portField.getText().isEmpty() ? true : false;
                startButton.setDisable(disabled);
            }
        });
        
        /*
        if(Main.getServer().isRunning() == false) {
            stopButton.setDisable(true);
        }
        */
    }
    
    @FXML
    public void startServer() {
        //if(Main.getServer().isRunning())
            //return;
        
        if(portField.getText().isEmpty())
            return;

        setServerPort(Integer.parseInt(portField.getText()));
        Main.setServerThread(new Thread(new ServerTask()));
        Main.getServerThread().start();
        //updateButtons();
    }

    @FXML
    public void stopServer() {
        //if(Main.getServer().isRunning() == false)
            //return;
        
        try {
            Main.getServer().stop();
            Main.setServerThread(null);
            //updateButtons();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
    
    private void setServerPort(int port) {
        if(Main.getServer().isRunning())
            return;
        
        Main.getServer().setPort(port);
    }
    
    private void updateButtons() {
        boolean running = Main.getServer().isRunning();
        System.out.println("Updating Buttons: " + running);
        
        if(running) {
            startButton.setDisable(true);
            stopButton.setDisable(false);
        } else {
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }
}
