package logger.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple formatter for formatting log messages to a simple format.
 * The format is as follows: [yyyy-MM-dd HH:mm:ss] LEVEL - LOGGER_NAME: MESSAGE
 * Example: [2021-01-01 12:00:00] INFO - Main: Hello, World!
 */
public class SimpleFormatter implements Formatter {
    @Override
    public String format(String message, String level, Long timestamp, String loggerName) {
        String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        return String.format("[%s] %s - %s: %s", formattedTime, level, loggerName, message);
    }
}