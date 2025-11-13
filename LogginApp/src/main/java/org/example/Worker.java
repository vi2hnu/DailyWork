package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Worker extends Thread {
    Logger logger = (Logger) LogManager.getLogger(Worker.class);
    public void run() {
        logger.info("Hello");
    }
}
