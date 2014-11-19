/**
 * @name : MyLogger
 *
 * @author: lenovo
 * @date : 12.11.2014
 *
 * @brief :
 *
 */
package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger
{
    private static Logger instance = null;
    private static final Level level = Level.ALL;

    private FileLogger()
    {
    }

    public static Logger getLogger()
    {
        if (instance == null)
        {
            instance = Logger.getAnonymousLogger();
            initLogger();
        }

        return instance;
    }

    private static void initLogger()
    {
        String path = System.getProperty("user.dir") + "/main.log";
        System.out.println(path);
        File logFile = new File(path);
        File javaLog = new File(path + ".lck");

        try
        {
            if(logFile.isFile() || javaLog.isFile())
            {
                logFile.delete();
                javaLog.delete();
            }
            FileHandler file = new FileHandler(path, true);
            file.setFormatter(new FileLoggerFormatter());
            instance.addHandler(file);
            instance.setLevel(level);
        }
        catch (IOException | SecurityException exp)
        {
            System.err.print(exp);
        }
    }
}

class FileLoggerFormatter
        extends SimpleFormatter
{
    @Override
    public String format(LogRecord record)
    {
        StringBuilder msg = new StringBuilder();

        msg.append(new Date(record.getMillis()));
        msg.append(" | ");
        msg.append(record.getSourceClassName());
        msg.append(" | ");
        msg.append(record.getSourceMethodName());
        msg.append(" | ");
        msg.append(record.getLevel());
        msg.append(" | ");
        msg.append(record.getMessage());
        msg.append("\n");

        return msg.toString();
    }
}
