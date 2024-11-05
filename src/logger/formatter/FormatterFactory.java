package logger.formatter;

import java.util.HashMap;
import java.util.Map;

public class FormatterFactory {
    private final Map<String, Formatter> formatters = new HashMap<>();

    public Formatter getFormatter(String type) {
        Formatter formatter = formatters.get(type);
        if (formatter == null) {
            if ("simple".equalsIgnoreCase(type)) {
                formatter = new SimpleFormatter();
            }
            // Можете добавить другие форматы здесь
            formatters.put(type, formatter);
        }
        return formatter;
    }
}
