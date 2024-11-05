package logger;

import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class LoggerConfiguration {
    private final Formatter formatter;
    private final Strategy[] strategies;

    public LoggerConfiguration(Formatter formatter, Strategy... strategies) {
        this.formatter = formatter;
        this.strategies = strategies;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public Strategy[] getStrategies() {
        return strategies;
    }
}
