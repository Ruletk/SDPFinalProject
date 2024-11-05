package logger.factory;

import logger.Logger;
import logger.formatter.Formatter;
import logger.strategy.Strategy;

public class LoggerFactory {
    public Logger createLogger(String loggerName, Formatter formatter, Strategy... strategies) {
        return new Logger(loggerName, formatter, strategies);
    }
}
