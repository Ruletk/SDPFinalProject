package logger.strategy;

import logger.LogMessage;

/**
 * Strategy interface for logging.
 * Changes the behavior of the Logger class.
 * Using for implementing different logging outputs.
 */
public interface Strategy {
    /**
     * Writes the log message to the output of the implementing class.
     *
     * @param logMessage Log message to be logged.
     */
    void log(LogMessage logMessage);
}
