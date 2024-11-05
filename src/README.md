# Logger Library

This Logger Library provides a flexible and customizable logging solution that allows logging messages with various formats, levels, and strategies. The library is designed using the **Factory**, **Strategy**, and **Adapter** design patterns to ensure scalability and ease of maintenance.

## Features

- **Multiple log levels**: Supports multiple log levels such as DEBUG, INFO, WARN, ERROR, and CRITICAL.
- **Multiple strategies**: Logs can be directed to different destinations, like standard output, files, or external third-party loggers.
- **Customizable formats**: Choose between different log message formats (e.g., JSON, simple text).
- **Singleton Logger Generator**: Ensures a single logger instance for an application.
- **Flexible configuration**: Easily configure the logger with different strategies and formats.

## Installation

1. Download or clone the repository.
2. Add the source files to your Java project.
3. Ensure that the `LoggerGenerator` class is initialized before logging any messages.

## Usage

### Initialization

First, initialize the `LoggerGenerator` with the desired log format and strategies. You can choose between a **SimpleFormatter** or a **JsonFormatter**, and specify logging strategies (e.g., **StdOutStrategy**, **FileStrategy**).

```java
SimpleFormatter simpleFormatter = new SimpleFormatter();
StdOutStrategy stdOutStrategy = new StdOutStrategy();
FileStrategy fileStrategy = new FileStrategy("log.txt");

// For third-party loggers, use the adapter pattern
ThirdPartyLogger thirdPartyLogger = new ThirdPartyLogger();
ThirdPartyLoggerAdapter adapter = new ThirdPartyLoggerAdapter(thirdPartyLogger);

LoggerGenerator.initialize(simpleFormatter, stdOutStrategy, fileStrategy, adapter);
