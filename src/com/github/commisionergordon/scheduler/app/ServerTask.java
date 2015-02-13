package com.github.commisionergordon.scheduler.app;

import javafx.concurrent.Task;

/**
 * Created by Kyle on 2/13/2015.
 */
public class ServerTask extends Task {
    
    @Override
    protected Object call() throws Exception {
        Main.getServer().start();
        return null;
    }
}
