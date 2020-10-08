package Util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

    private static final Logger logger = LogManager.getLogger(LogUtils.class);
    private static LogUtils instance;

    public static LogUtils getInstance() {
        if (instance == null) {
            instance = new LogUtils();
        }
        return instance;
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logError(String message) {
        logger.error(message);
    }
}
