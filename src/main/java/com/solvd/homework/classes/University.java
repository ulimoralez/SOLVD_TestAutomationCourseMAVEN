package com.solvd.homework.classes;

import com.solvd.homework.customlinkedlist.GenericLinkedList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private int averageAgeOfStudents = 0;

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

    public String getName() {
        return name;
    }

    //Methods
    public boolean isProfessor(int professorid){
        return professorsList.containsKey(professorid);
    }

    public static void checkStudents(University university){
        university.studentsList.forEach(student -> {
            Student.CheckCollege(student, university.name);
        });
    }

    public void changeUniversityName(String newName){
        this.name = newName;
        this.studentsList.forEach(student -> {
            student.setCollegeName(newName);
        });
    }

    //Foreach implements a Consumer function, I think it applies to the task
    public void changeCareerName(String newCareerName) {
        this.studentsList.forEach(x -> x.changeInfo(x.getCollegeName(), newCareerName));
    }
    public int getAverageYearOfStudents(){
        this.averageAgeOfStudents = 0;
        Consumer<Student> consumer = student -> {
            LOGGER.info(""+student.getAge());
            this.averageAgeOfStudents += student.getAge();
        };
        this.studentsList.forEach(student -> {
            consumer.accept(student);
        });
        return this.averageAgeOfStudents / this.studentsList.size();
    }
    public ArrayList<Student> getStudentsWithTheSameAge(int age){
        ArrayList<Student> result;
        Function<ArrayList<Student>, ArrayList<Student>> function = (studentList) -> {
            ArrayList<Student> studentsWithTheSameAge = new ArrayList<>();
            studentList.forEach(student -> {
                if (student.getAge() == age){
                    LOGGER.info("Student: "+student.getFirstName()+" "+student.getLastName()+". Age: "+student.getAge());
                    studentsWithTheSameAge.add(student);
                }
            });
            return studentsWithTheSameAge;
        };
        result = function.apply(this.studentsList);
        return result;
    }

    //Non-Terminal operations Stream
    public ArrayList<Student> filterStudentsForFirstname(String pattern){
        ArrayList<Student> result = new ArrayList<>(this.studentsList.stream()
                .filter(student -> student.getFirstName().contains(pattern))
                .collect(Collectors.toList()));
        return result;
    }
    public ArrayList<Student> filterStudentByAge(int age){
        ArrayList<Student> students = new ArrayList<>(this.studentsList.stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList()));
        return students;
    }
    public ArrayList<Student> sortStudentByAscendantAge(){
        ArrayList<Student> students = new ArrayList<>(this.studentsList.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList()));
        return students;
    }

    //Terminal streams
    public Optional<Student> getMinimunAgeStudent(){
        Stream<Student> students = this.studentsList.stream();

        return students
                .min(Comparator.comparingInt(Student::getAge));
    }
    public Long getTotalOfStudents(){
        Stream<Student> students = this.studentsList.stream();

        return students
                .count();
    }
    public Stream<Student> addYearsOnStudentsAge(int age){
        Stream<Student> students = this.studentsList.stream();
        students.forEach(student -> {
            student.setAge(student.getAge() + age);
            LOGGER.info("Age of: "+student);
        });
        return students;
    }
    public Optional<Student> getFirstStudent(){
        Stream<Student> studentStream = this.studentsList.stream();
        return studentStream.findFirst();
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
