package logger.factory;

import logger.Logger;
import logger.LoggerConfiguration;

public class LoggerFactory {
    public Logger createLogger(String loggerName, LoggerConfiguration configuration) {
        return new Logger(loggerName, configuration);
    }
}
