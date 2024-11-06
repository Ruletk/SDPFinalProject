package logger.formatter;

/**
 * Interface for implementations of log message formatters.
 * Formatters are used to format log messages before they are logged to the output.
 */
public interface Formatter {
    /**
     * Formats the log message with the given level, timestamp, and logger name.
     *
     * @param message    String message to be formatted.
     * @param level      Log level of the message.
     * @param timestamp  Timestamp of the message.
     * @param loggerName Name of the logger. Default is the class name.
     * @return Formatted log message.
     */
    String format(String message, String level, Long timestamp, String loggerName);
}
