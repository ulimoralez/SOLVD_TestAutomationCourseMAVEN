package com.solvd.homework.classes;

import com.solvd.homework.customlinkedlist.GenericLinkedList;

import java.util.*;
import java.util.logging.Logger;

public class University {
    private static final Logger LOGGER = Logger.getLogger(University.class.getName());

    private String name;
    private int yearOfFoundation;
    private final int currentYear = new Date().getYear();
    //The unique way to create it it's in the constructor
    private HashSet<String> universityMembers = new HashSet();
    //Key = professorId - Value = Proffesor firstname and lastname
    private HashMap<Integer, String> professorsList = new HashMap();
    //Have no order and can have duplicates
    ArrayList<Student> studentsList = new ArrayList<>();
    //Ordered as inserted
    private LinkedHashSet<String> classDates = new LinkedHashSet();
    //Careers that have the Uni
    private GenericLinkedList<String> careers = new GenericLinkedList<>();

    public University(String name, int yearOfFoundation){
        this.name = name;
            if (yearOfFoundation > 1000 || yearOfFoundation < currentYear){
                this.yearOfFoundation = yearOfFoundation;
            }else{
                LOGGER.severe("Invalid date in year of foundation");
            }
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
            this.studentsList.add(student[i]);
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

    public HashSet<String> getUniversityMembers() {
        return universityMembers;
    }

    public GenericLinkedList getCareers(){
        return this.careers;
    }

    //Methods
    public boolean isProfessor(int professorid){
        return professorsList.containsKey(professorid);
    }

    //Showing methods
    public void showProfessorsList(){
        for(Integer key : professorsList.keySet()){
            LOGGER.info("IdProfessor: "+key+" - Name: "+professorsList.get(key));
        }
    }

    /**
     * Returns the total of Students, professors and careers
     */
    public void showUniversityData(){
        LOGGER.info("The university called: "+this.name+" Founded at: "+this.yearOfFoundation+"\nHas a total of: "+(universityMembers.size()+1)+" members." +
                "\n"+professorsList.size()+" are professors"+
                "\n"+studentsList.size()+" are students");
    }

}
