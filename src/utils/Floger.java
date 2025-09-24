package utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Floger {
    Logger logger = Logger.getLogger(Floger.class.getName());
    FileHandler fh;
    Floger(FileHandler fh) {
        try {
            // Configure FileHandler to log to "MyLogFile.log"
            // true indicates append mode, so new logs are added to the end of the file
            fh = new FileHandler("MyLogFile.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

}
