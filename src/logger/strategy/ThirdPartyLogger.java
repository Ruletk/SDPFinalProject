package logger.strategy;

public class ThirdPartyLogger {
    public void logMessage(String message) {
        // Логика для логирования в стороннем логгере
        System.out.println("ThirdPartyLogger: " + message);
    }
}
