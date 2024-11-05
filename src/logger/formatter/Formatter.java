package logger.formatter;

public interface Formatter {
    String format(String message, String level, Long timestamp, String loggerName);
}
