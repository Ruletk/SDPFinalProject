package logger;

import logger.factory.LoggerFactory;
import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class LoggerGenerator {
    private static LoggerGenerator instance;
    private final Formatter formatter;
    private final Strategy[] strategies;

    private final LoggerFactory loggerFactory = new LoggerFactory();

    public LoggerGenerator(Formatter formatter, Strategy... strategies) {
        if (instance != null) throw new IllegalStateException("LoggerGenerator has already been initialized");

        this.strategies = strategies;
        this.formatter = formatter;
        instance = this;
    }

    public static LoggerGenerator getInstance() {
        if (instance == null) throw new IllegalStateException("LoggerGenerator has not been initialized yet");
        return instance;
    }

    public Logger getLogger(Class<?> clazz) {
        return loggerFactory.createLogger(clazz.getName(), formatter, strategies);
    }
}
