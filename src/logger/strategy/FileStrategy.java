package logger.strategy;

import logger.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Strategy implementation for logging to a file.
 * Writes the log message to a file that is specified in the constructor.
 * New log messages are appended to the end of the file.
 * No newlines between log messages.
 */
public class FileStrategy implements Strategy {
    private final String filePath;

    /**
     * @param filePath Path to the file where the log messages will be written.
     */
    public FileStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(LogMessage logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(logMessage.getFormattedMessage());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}