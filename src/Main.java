import logger.Logger;
import logger.LoggerGenerator;
import logger.formatter.SimpleFormatter;
import logger.strategy.StdOutStrategy;
import logger.strategy.FileStrategy;
import logger.strategy.ThirdPartyLogger;
import logger.strategy.ThirdPartyLoggerAdapter;

public class Main {
    public static void main(String[] args) {
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        StdOutStrategy stdOutStrategy = new StdOutStrategy();
        FileStrategy fileStrategy = new FileStrategy("log.txt");

        ThirdPartyLogger thirdPartyLogger = new ThirdPartyLogger();
        ThirdPartyLoggerAdapter adapter = new ThirdPartyLoggerAdapter(thirdPartyLogger);

        Logger logger = LoggerGenerator.getInstance(simpleFormatter, stdOutStrategy, fileStrategy, adapter).getLogger(Main.class);

        logger.info("This is an info message.");
        logger.debug("This is a debug message.");
        logger.error("This is an error message.");
        logger.warn("This is a warning message.");
        logger.critical("This is a critical message.");
    }
}
