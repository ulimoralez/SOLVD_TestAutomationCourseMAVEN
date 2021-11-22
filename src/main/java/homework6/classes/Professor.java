package homework6.classes;

import homework6.customLogger.CustomLogger;
import homework6.interfaces.*;
import homework6.exceptions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Professor extends Person implements IProfessor {

    private String studyArea;
    private String collegeName;
    private int id;
    private ArrayList<Integer> professorIDs = new ArrayList<>();
    File file = new File("src/homework6/Log.txt");
    public CustomLogger customLogger = new CustomLogger(Logger.GLOBAL_LOGGER_NAME);

    public Professor(String firstName, String lastName, String studyArea, String collegeName, int professorID) {
        this(firstName, lastName, studyArea);
        this.collegeName = collegeName;
        this.id = professorID;
    }
    public Professor(String firstName, String lastName, String gender, int age, String studyArea, String collegeName,
                     int professorID                ) {
        this(firstName, lastName, studyArea);
        super.setAge(age);
        super.setGender(gender);
        this.collegeName = collegeName;
        this.id = professorID;
    }
    public Professor(String firstName, String lastName, String studyArea) {
        super(firstName, lastName);
        this.studyArea = studyArea;
        customLogger.setupLogger(file);
    }

    public int getId(){
        return this.id;
    }

    //Overriding interface and super class methods
    public void changeId(int professorId){
        for (int i = 0; i < professorIDs.size(); i++) {
            if (professorIDs.get(i) == professorId) {
                this.id = professorId;
            }
        }
    }
    @Override
    public void sayHello(String firstName) {
        try {
            customLogger.print(Level.FINE, "Hello! My name is: "+firstName);
        }catch (Exception e){
            customLogger.print(Level.SEVERE,"Error in Professor->sayHello: "+e);
        }
    }

    @Override
    public void drink() {
        customLogger.print(Level.FINE, "I like to drink tea");
    }
    @Override
    public String themeToTeach() {
        return "Java OOP";
    }
}
