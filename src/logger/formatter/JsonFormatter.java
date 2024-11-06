package logger.formatter;

/**
 * Formats the log message in JSON format.
 * The JSON format is as follows time, level, logger, message.
 */
public class JsonFormatter implements Formatter {
    @Override
    public String format(String message, String level, Long timestamp, String loggerName) {
        return String.format("{\"time\": \"%d\", \"level\": \"%s\", \"logger\": \"%s\", \"message\": \"%s\"}",
                timestamp, level, loggerName, message);
    }
}