package homework6.customLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.*;

public class CustomLogger extends Logger{

    public CustomLogger(String name){
        super(name, null);
        LogManager.getLogManager().reset();
        this.setLevel(Level.ALL);
    }
    public void setupLogger(File file){
        try {
            file.createNewFile();
            //We pass a file and make it to log here in the level Severe
            FileHandler fh = new FileHandler(file.getName());
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.SEVERE);
            this.addHandler(fh);

            //And now we want to log the level Fine in the console
            ConsoleHandler ch = new ConsoleHandler();
            ch.setFormatter(new SimpleFormatter());
            ch.setLevel(Level.FINE);
        }catch (Exception e){
            this.log(Level.SEVERE, "Error initializing Logger: File error, not find or not working");
        }
    }
    public void turnOffLogger(File file){
        try {
            removeHandler(new FileHandler(file.getName()));
        }catch (SecurityException Se){
            this.log(Level.SEVERE, "Error turning off Logger: Security Exception");
        }catch (IOException IOE){
            this.log(Level.SEVERE, "Error turning off Logger: Input or Output Exception");
        }
    }
    public void readLog(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            String line = "";

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }

            this.fine(content.toString());
        } catch (IOException e) {
            this.log(Level.SEVERE, "ERROR OCURRED WHILE READING THE LOG FILE", e);
            System.exit(0);
        }
    }
    public void print(Level level, String message) {
        System.out.println(message);
        this.log(level, message);
    }
}
