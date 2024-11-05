package logger;

import logger.factory.LoggerFactory;
import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class LoggerGenerator {
    private static LoggerGenerator instance;
    private final Formatter formatter;
    private final Strategy[] strategies;

    private final LoggerFactory loggerFactory = new LoggerFactory(); // Logger factory instance

    private LoggerGenerator(Formatter formatter, Strategy... strategies) {
        this.formatter = formatter;
        this.strategies = strategies;
    }

    public static LoggerGenerator getInstance(Formatter formatter, Strategy... strategies) {
        if (instance == null) {
            instance = new LoggerGenerator(formatter, strategies);
        }
        return instance;
    }

    public Logger getLogger(Class<?> clazz) {
        return loggerFactory.createLogger(clazz.getName(), formatter, strategies);
    }
}
