package com.github.commissionergordon.scheduler.gui;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.ServerRunnable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.catalina.LifecycleException;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowController implements Initializable {
    
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
        
        if(Main.getServer().isRunning() == false) {
            stopButton.setDisable(true);
        }
    }
    
    @FXML
    public void startServer() {
        if(Main.getServer().isRunning())
            return;

        if(portField.getText().isEmpty())
            return;

        setServerPort(Integer.parseInt(portField.getText()));
        ServerRunnable serverRunnable = new ServerRunnable(Main.getServer());
        Thread serverThread = new Thread(serverRunnable);
        serverThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        updateButtons();
    }

    @FXML
    public void stopServer() {
        if(Main.getServer().isRunning() == false)
            return;
        
        try {
            Main.getServer().stop();
            updateButtons();
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
        
        if(running) {
            startButton.setDisable(true);
            stopButton.setDisable(false);
        } else {
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }
}
