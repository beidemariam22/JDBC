package org.example.Configurations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class LogConfigurator {

    public static void configureLogger() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.INFO);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        consoleHandler.setFormatter(new Formatter() {
            private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            @Override
            public String format(LogRecord record) {
                String formattedDate = dateFormat.format(new Date(record.getMillis()));
                String formattedMessage = String.format("[%s] [%s] %s%n", formattedDate, record.getLevel(), record.getMessage());
                return formattedMessage;
            }
        });

        logger.addHandler(consoleHandler);
    }
}
