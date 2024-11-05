package logger.strategy;

import logger.LogMessage;

public class StdOutStrategy implements Strategy {
    @Override
    public void log(LogMessage logMessage) {
        System.out.println(logMessage.getFormattedMessage());
    }
}