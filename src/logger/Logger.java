package logger;

import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class Logger {
    private final String loggerName;
    private final Formatter formatter;
    private final Strategy[] strategies;

    public Logger(String loggerName, Formatter formatter, Strategy... strategies) {
        this.loggerName = loggerName;
        this.formatter = formatter;
        this.strategies = strategies;
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
        LogMessage logMessage = new LogMessage(message, level, System.currentTimeMillis(), formatter, loggerName);
        for (Strategy strategy : strategies) {
            strategy.log(logMessage);
        }
    }
}
