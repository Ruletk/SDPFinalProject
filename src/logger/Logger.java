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
    }

    public void info(String message) {
    }

    public void warn(String message) {
    }

    public void error(String message) {
    }

    public void critical(String message) {
    }

    private void log(String message, String level) {
        LogMessage logMessage = new LogMessage(message, level, System.currentTimeMillis(), formatter, loggerName);
        for (Strategy strategy : strategies) {
            strategy.log(logMessage);
        }
    }
}
