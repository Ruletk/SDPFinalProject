package logger.strategy;

/**
 * An example of a third-party logger that is not part of the application.
 * This class is used to demonstrate the Adapter pattern.
 */
public class ThirdPartyLogger {
    public void logMessage(String message) {
        System.out.println("ThirdPartyLogger: " + message);
    }
}