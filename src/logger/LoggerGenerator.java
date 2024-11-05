package logger;

import logger.factory.LoggerFactory;
import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class LoggerGenerator {
    private static LoggerGenerator instance; // Singleton instance
    private final Formatter formatter; // Formatter for log messages
    private final Strategy[] strategies; // Array of logging strategies

    private final LoggerFactory loggerFactory = new LoggerFactory(); // Logger factory instance

    // Private constructor to prevent instantiation
    private LoggerGenerator(Formatter formatter, Strategy... strategies) {
        this.formatter = formatter;
        this.strategies = strategies;
    }

    // Method to get the singleton instance of LoggerGenerator
    public static LoggerGenerator getInstance(Formatter formatter, Strategy... strategies) {
        if (instance == null) {
            instance = new LoggerGenerator(formatter, strategies);
        }
        return instance;
    }

    // Method to create a logger for the specified class
    public Logger getLogger(Class<?> clazz) {
        return loggerFactory.createLogger(clazz.getName(), formatter, strategies);
    }
}
