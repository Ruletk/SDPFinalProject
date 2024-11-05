package logger;

import logger.formatter.Formatter;

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
}
