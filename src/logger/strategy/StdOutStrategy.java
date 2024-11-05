package logger.strategy;

import logger.LogMessage;

public class StdOutStrategy implements Strategy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Override
    public void log(LogMessage logMessage) {
        String formattedMessage = preProcessMessage(logMessage);
        System.out.println(formattedMessage);
    }

    private String preProcessMessage(LogMessage logMessage) {
        return switch (logMessage.getLevel()) {
            case "INFO" -> ANSI_BLUE + logMessage.getFormattedMessage() + ANSI_RESET;
            case "WARN" -> ANSI_YELLOW + logMessage.getFormattedMessage() + ANSI_RESET;
            case "ERROR" -> ANSI_RED + logMessage.getFormattedMessage() + ANSI_RESET;
            case "CRITICAL" -> ANSI_PURPLE + logMessage.getFormattedMessage() + ANSI_RESET;
            default -> logMessage.getFormattedMessage();
        };
    }
}