package utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Floger {
    private static final Logger logger = Logger.getLogger(Floger.class.getName());
    private static FileHandler fh;
    static {
        try {
            if (fh == null) {
                fh = new FileHandler("MyLogFile.log", true); // append mode
                fh.setFormatter(new SimpleFormatter());
                logger.addHandler(fh);
                logger.setUseParentHandlers(false); // stop logging to console
            }
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static Logger makelogger() {
        return logger;
    }

}
