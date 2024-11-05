package logger;

import logger.factory.LoggerFactory;
import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class LoggerGenerator {
    private static LoggerGenerator instance;
    private final LoggerConfiguration configuration;

    private final LoggerFactory loggerFactory = new LoggerFactory(); // Logger factory instance

    public LoggerGenerator(Formatter formatter, Strategy... strategies) {
        if (instance != null) throw new IllegalStateException("LoggerGenerator has already been initialized");

        configuration = new LoggerConfiguration(formatter, strategies);

        LoggerGenerator.instance = this;
    }

    public static void initialize(Formatter formatter, Strategy... strategies) {
        if (instance != null) throw new IllegalStateException("LoggerGenerator has already been initialized");
        new LoggerGenerator(formatter, strategies);
    }

    public static LoggerGenerator getInstance() {
        if (instance == null) throw new IllegalStateException("LoggerGenerator has not been initialized yet.");
        return instance;
    }

    public Logger getLogger(Class<?> clazz) {
        return loggerFactory.createLogger(clazz.getName(), configuration);
    }
}
