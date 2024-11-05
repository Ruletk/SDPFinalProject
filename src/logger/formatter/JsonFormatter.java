package logger.formatter;

public class JsonFormatter implements Formatter {
    @Override
    public String format(String message, String level, Long timestamp, String loggerName) {
        return String.format("{\"time\": \"%d\", \"level\": \"%s\", \"logger\": \"%s\", \"message\": \"%s\"}",
                timestamp, level, loggerName, message);
    }
}