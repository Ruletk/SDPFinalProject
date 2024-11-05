package logger.strategy;

import logger.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileStrategy implements Strategy {
    private final String filePath;

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