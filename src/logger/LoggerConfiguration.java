package logger;

import logger.formatter.Formatter;
import logger.strategy.Strategy;

/**
 * LoggerConfiguration class is used to contain the formatter and strategies to log the messages.
 * It's example of flyweight pattern.
 * It is used by the Logger class to get the formatter and strategies to log the messages.
 * It is created only once and passed to the Logger class.
 * It is immutable.
 */
public class LoggerConfiguration {
    private final Formatter formatter;
    private final Strategy[] strategies;

    public LoggerConfiguration(Formatter formatter, Strategy... strategies) {
        this.formatter = formatter;
        this.strategies = strategies;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public Strategy[] getStrategies() {
        return strategies;
    }
}
