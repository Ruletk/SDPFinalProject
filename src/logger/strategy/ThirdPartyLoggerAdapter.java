package logger.strategy;

import logger.LogMessage;

/**
 * Adapter for the third-party logger.
 * Adapts the third-party logger to the Logger interface.
 * This is an example of the Adapter pattern.
 */
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