package logger;

import logger.strategy.Strategy;

public class Logger {
    private final String loggerName;
    private final LoggerConfiguration configuration;

    public Logger(String loggerName, LoggerConfiguration configuration) {
        this.loggerName = loggerName;
        this.configuration = configuration;
    }

    public void debug(String message) {
        log(message, "DEBUG");
    }

    public void info(String message) {
        log(message, "INFO");
    }

    public void warn(String message) {
        log(message, "WARN");
    }

    public void error(String message) {
        log(message, "ERROR");
    }

    public void critical(String message) {
        log(message, "CRITICAL");
    }

    private void log(String message, String level) {
        LogMessage logMessage = new LogMessage(message, level, System.currentTimeMillis(), configuration.getFormatter(), loggerName);
        for (Strategy strategy : configuration.getStrategies()) {
            strategy.log(logMessage);
        }
    }
}
