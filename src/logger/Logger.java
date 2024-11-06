package logger;

import logger.strategy.Strategy;

/**
 * Logger class is the main class of the logger package. It is used to log messages with different levels.
 * It has methods to log messages with different levels like debug, info, warn, error, and critical.
 * It uses the LoggerConfiguration object to get the strategies and formatter to log the messages.
 * It creates a LogMessage object and passes it to the strategies to log the message.
 */
public class Logger {
    /**
     * loggerName is the name of the logger. It is used to identify the logger.
     * It will write this name in the log message.
     */
    private final String loggerName;

    /**
     * configuration is the LoggerConfiguration object. It is used to get the strategies
     * and formatter to log the messages.
     */
    private final LoggerConfiguration configuration;

    /**
     * @param loggerName    Name of the logger
     * @param configuration LoggerConfiguration object
     */
    public Logger(String loggerName, LoggerConfiguration configuration) {
        this.loggerName = loggerName;
        this.configuration = configuration;
    }

    /**
     * Logs the message with DEBUG level
     *
     * @param message Message to log
     */
    public void debug(String message) {
        log(message, "DEBUG");
    }

    /**
     * Logs the message with INFO level
     *
     * @param message Message to log
     */
    public void info(String message) {
        log(message, "INFO");
    }

    /**
     * Logs the message with WARN level
     *
     * @param message Message to log
     */
    public void warn(String message) {
        log(message, "WARN");
    }

    /**
     * Logs the message with ERROR level
     *
     * @param message Message to log
     */
    public void error(String message) {
        log(message, "ERROR");
    }

    /**
     * Logs the message with CRITICAL level
     *
     * @param message Message to log
     */
    public void critical(String message) {
        log(message, "CRITICAL");
    }

    /**
     * Creates a LogMessage object and passes it to the strategies to log the message.
     * It logs the message with the given level.
     * Then it passes the LogMessage object to the strategies to log the message.
     *
     * @param message Message to log
     * @param level   Level of the message
     */
    private void log(String message, String level) {
        LogMessage logMessage = new LogMessage(message, level, System.currentTimeMillis(), configuration.getFormatter(), loggerName);
        for (Strategy strategy : configuration.getStrategies()) {
            strategy.log(logMessage);
        }
    }
}
