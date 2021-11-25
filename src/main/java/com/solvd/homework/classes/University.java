package com.solvd.homework.classes;

import com.solvd.homework.customLinkedList.GenericLinkedList;
import com.solvd.homework.customLogger.CustomLogger;

import java.util.*;
import java.util.logging.Logger;

public class University {
    Logger log = new CustomLogger(University.class.getName()).getInitializedLogger();

    //The unique way to create it it's in the constructor
    private HashSet<String> universityMembers = new HashSet();
    //Key = professorId - Value = Proffesor firstname and lastname
    private HashMap<Integer, String> professorsList = new HashMap();
    //Ordered as inserted
    private LinkedHashSet<String> classDates = new LinkedHashSet();
    //Careers that have the Uni
    GenericLinkedList<String> careers = new GenericLinkedList<>();

    public University(){

    }

    //Adders
    public void addProfessor(Professor... professor){
        for (int i = 0; i < professor.length; i++){
            this.universityMembers.add(professor[i].getFirstName()+" "+professor[i].getLastName());
            professorsList.put(professor[i].getId(), professor[i].getFirstName()+" "+professor[i].getLastName());
        }
    }

    public void addStudent(Student... student){
        for (int i = 0; i < student.length; i++){
            this.universityMembers.add(student[i].getFirstName()+" "+student[i].getLastName());
        }
    }

    public void addClass(Date date, Professor professor, String theme){
        classDates.add(date+" "+
                "\nProfessor "+professor.getFirstName()+" "+professor.getLastName()+" it's explainig: "+theme);
    }

    public void addCareer(String careerName){
        this.careers.insert(careerName);
    }

    //Remove
    public void removeStudent(Student student){
        this.universityMembers.remove(student);
    }

    public void removeProfessor(Professor professor){
        professorsList.remove(professor);
    }

    //Getters
    public HashMap getProfessorsList(){
        return this.professorsList;
    }

    public LinkedHashSet getSchoolCalendar(){
        return this.classDates;
    }

    public HashSet getClassroom(){
        return this.universityMembers;
    }

    public GenericLinkedList getCareers(){
        return this.careers;
    }
}
