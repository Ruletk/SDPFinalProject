package logger;

import logger.factory.LoggerFactory;
import logger.formatter.Formatter;
import logger.strategy.Strategy;

/**
 * LoggerGenerator class is used to generate the Logger object.
 * It is used to generate the Logger object with the given formatter and strategies.
 * It is a singleton class and can be initialized only once.
 * Second initialization will throw an IllegalStateException.
 * It is used to generate the Logger object with the given formatter and strategies.
 * If it is not initialized, and getInstance() is called, it will throw an IllegalStateException.
 */
public class LoggerGenerator {
    private static LoggerGenerator instance;
    private final LoggerConfiguration configuration;

    private final LoggerFactory loggerFactory = new LoggerFactory(); // Logger factory instance

    /**
     * Constructor to initialize the LoggerGenerator object.
     * It is used to initialize the LoggerGenerator object with the given formatter and strategies.
     * Saving the instance of the static LoggerGenerator object.
     *
     * @param formatter  Formatter object.
     * @param strategies Strategies to log the messages. It can be multiple strategies or zero strategies.
     */
    public LoggerGenerator(Formatter formatter, Strategy... strategies) {
        if (instance != null) throw new IllegalStateException("LoggerGenerator has already been initialized");

        configuration = new LoggerConfiguration(formatter, strategies);

        LoggerGenerator.instance = this;
    }

    /**
     * Facade-like method to initialize the LoggerGenerator object.
     * It is used for fast initialization of the LoggerGenerator object.
     * It is used to initialize the LoggerGenerator object with the given formatter and strategies.
     *
     * @param formatter  Formatter object.
     * @param strategies Strategies to log the messages. It can be multiple strategies or zero strategies.
     */
    public static void initialize(Formatter formatter, Strategy... strategies) {
        if (instance != null) throw new IllegalStateException("LoggerGenerator has already been initialized");
        new LoggerGenerator(formatter, strategies);
    }

    /**
     * Method to get the instance of the LoggerGenerator singleton object.
     *
     * @return LoggerGenerator instance
     */
    public static LoggerGenerator getInstance() {
        if (instance == null) throw new IllegalStateException("LoggerGenerator has not been initialized yet.");
        return instance;
    }

    /**
     * Creates a Logger object with the given class.
     * It is used to get the logger object for the given class.
     * It uses the LoggerFactory object to create the logger object.
     *
     * @param clazz Class object to get the logger for the class.
     * @return Logger object for the given class.
     */
    public Logger getLogger(Class<?> clazz) {
        return loggerFactory.createLogger(clazz.getName(), configuration);
    }
}
