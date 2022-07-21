package juniorTechTask.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerUtil {
    private static Logger log;
    private static Handler fileHendler;

    static {
        try {
            fileHendler = new FileHandler(createFileForHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileHendler.setFormatter(new MyFormater());

    }

    public static Logger getLog(String stringClassGetName) {
        log = Logger.getLogger(stringClassGetName);
        log.addHandler(fileHendler);
        return log;
    }

    private static String createFileForHandler() {
        return "Log.txt";
    }

    private static class MyFormater extends Formatter {

        LocalDateTime localDateTime = LocalDateTime.now();

        @Override
        public String format(LogRecord record) {
            return localDateTime.withNano(0).toString() + " class: " + record.getSourceClassName()
                    + " method: " + record.getSourceMethodName() + "()"
                    + " " + record.getLevel()  + ": " + record.getMessage() + "\n";
        }
    }
}
