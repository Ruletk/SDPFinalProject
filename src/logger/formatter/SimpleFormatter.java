package logger.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormatter implements Formatter {
    @Override
    public String format(String message, String level, Long timestamp, String loggerName) {
        String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        return String.format("[%s] %s - %s: %s", formattedTime, level, loggerName, message);
    }
}