package logger.strategy;

import logger.LogMessage;

class ThirdPartyLogger {
    public void logMessage(String message) {
        // Логика для логирования в стороннем логгере
        System.out.println("ThirdPartyLogger: " + message);
    }
}

public class ThirdPartyLoggerAdapter implements Strategy {
    private final ThirdPartyLogger thirdPartyLogger;

    public ThirdPartyLoggerAdapter(ThirdPartyLogger thirdPartyLogger) {
        this.thirdPartyLogger = thirdPartyLogger;
    }

    @Override
    public void log(LogMessage logMessage) {
        String formattedMessage = logMessage.getFormattedMessage();
        thirdPartyLogger.logMessage(formattedMessage);
    }
}