package logger.factory;

import logger.Logger;
import logger.LoggerConfiguration;

/**
 * Factory class for creating instances of Logger.
 * Creates a new instance of Logger with the given name and configuration.
 */
public class LoggerFactory {
    /**
     * Creates a new instance of Logger with the given name and configuration.
     *
     * @param loggerName    Name of the logger. Default is the class name.
     * @param configuration Configuration for the logger. Includes formatter and strategies.
     * @return A new instance of Logger
     */
    public Logger createLogger(String loggerName, LoggerConfiguration configuration) {
        return new Logger(loggerName, configuration);
    }
}
