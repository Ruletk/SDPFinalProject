package logger;

import logger.formatter.Formatter;

/**
 * LogMessage class is used to store the log message details.
 * It is used to store the log message details like message, level, timestamp, formatter, and logger name.
 */
public class LogMessage {
    private final String message;
    private final String level;
    private final Long timestamp;
    private final Formatter formatter;
    private final String loggerName;

    public LogMessage(String message, String level, Long timestamp, Formatter formatter, String loggerName) {
        this.message = message;
        this.level = level;
        this.timestamp = timestamp;
        this.formatter = formatter;
        this.loggerName = loggerName;
    }

    public String getFormattedMessage() {
        return formatter.format(message, level, timestamp, loggerName);
    }

    public String getMessage() {
        return message;
    }

    public String getLevel() {
        return level;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public String getLoggerName() {
        return loggerName;
    }
}
