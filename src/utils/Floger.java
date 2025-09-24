package utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Floger {
    private static final Logger logger = Logger.getLogger(Floger.class.getName());
    private static FileHandler fh;
    public static Logger makelogger () {
        try {
            // Configure FileHandler to log to "MyLogFile.log"
            // true indicates append mode, so new logs are added to the end of the file
            fh = new FileHandler("MyLogFile.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            return logger;
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
