package com.github.commissionergordon.scheduler.app;

import com.github.commissionergordon.scheduler.container.Server;
import org.apache.catalina.LifecycleException;

public class ServerRunnable implements Runnable {
    
    private Server server;
    
    public ServerRunnable(Server server) {
        this.server = server;
    }
    
    @Override
    public void run() {
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
