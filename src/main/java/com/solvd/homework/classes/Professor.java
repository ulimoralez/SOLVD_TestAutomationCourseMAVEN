package com.solvd.homework.classes;

import com.solvd.homework.customLogger.MyLogger;
import com.solvd.homework.interfaces.*;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Professor extends Person implements IProfessor {

    private String studyArea;
    private String collegeName;
    private int id;
    private ArrayList<Integer> professorIDs = new ArrayList<>();
    Logger log = new MyLogger(Professor.class.getName()).getInitializedLogger();

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
            log.info("Hello! My name is: "+firstName);
        }catch (Exception e){
            log.info("Error in Professor->sayHello: "+e);
        }
    }

    @Override
    public void drink() {
        log.info("I like to drink tea");
    }
    @Override
    public String themeToTeach() {
        return "Java OOP";
    }
}
