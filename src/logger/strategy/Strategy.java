package logger.strategy;

import logger.LogMessage;

public interface Strategy {
    void log(LogMessage logMessage);
}
