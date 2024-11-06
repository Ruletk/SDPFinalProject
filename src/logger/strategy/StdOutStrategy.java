package logger.strategy;

import logger.LogMessage;

/**
 * Strategy for logging to the standard output stream.
 * Outputs the log message to the console or any other standard output stream.
 * Uses ANSI escape codes for coloring the output.
 * ANSI escape codes are can not be supported in some terminals.
 * In that case, the output will be without coloring.
 */
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

    /**
     * Pre-processes the log message before outputting it.
     * Colors the log message according to the log level.
     *
     * @param logMessage Log message to be pre-processed.
     * @return Colored log message.
     */
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