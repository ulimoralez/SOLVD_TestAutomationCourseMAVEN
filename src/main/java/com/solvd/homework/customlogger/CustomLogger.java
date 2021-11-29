package com.solvd.homework.customlogger;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class CustomLogger {
    private Logger logger;
    private final String LOGPATH = "src/main/java/com/solvd/homework/Log.txt";
    private File logFile = new File(LOGPATH);
    public CustomLogger(String classname){
        try {
            SimpleFormatter sp = new SimpleFormatter();
            //We setup the logger with the classname
            logger = Logger.getLogger(classname);
            if(!logFile.exists()) logFile.createNewFile();
            //We create the handlers
            FileHandler fh = new FileHandler(LOGPATH, true);
            ConsoleHandler ch = new ConsoleHandler();

            //Set the formatter
            fh.setFormatter(sp);
            ch.setFormatter(sp);
            //Set the level that was necessary to log
            fh.setLevel(Level.SEVERE);
            ch.setLevel(Level.FINE);

            this.logger.addHandler(fh);
            this.logger.addHandler(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Logger getInitializedLogger(){
        return this.logger;
    }
}
