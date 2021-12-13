package com.solvd.homework.runner;

import com.solvd.homework.classes.Company;
import com.solvd.homework.classes.Programmer;
import com.solvd.homework.classes.Student;
import com.solvd.homework.classes.University;
import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;
import com.solvd.homework.utils.CreatedObjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;
import java.util.logging.Logger;

public class LambdaRunner {
    public static void main(String[] args) {
        Logger LOGGER = Logger.getLogger(Runner.class.getName());
        ArrayList<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
        programmingLanguages.add(ProgrammingLanguage.JAVA);
        programmingLanguages.add(ProgrammingLanguage.JAVASCRIPT);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(CreatedObjects.PROGRAMMER1);
        programmers.add(CreatedObjects.PROGRAMMER2);
        programmers.add(CreatedObjects.PROGRAMMER3);
        programmers.add(CreatedObjects.PROGRAMMER4);
        programmers.add(CreatedObjects.PROGRAMMER5);

        Company company = new Company("SOLVD", new Date("22/04/2001"), programmingLanguages, programmers);

        University university = new University("UTN", 2020);
        university.addCareer("Software Engineering");
        university.addCareer("Machine Learning");
        university.addCareer("Web Development");
        university.addCareer("Software Development Engineer & Testing");

        university.addProfessor(CreatedObjects.PROFESSOR1);
        university.addProfessor(CreatedObjects.PROFESSOR2);
        university.addProfessor(CreatedObjects.PROFESSOR3);

        university.addStudent(CreatedObjects.STUDENT1);
        university.addStudent(CreatedObjects.STUDENT2);
        university.addStudent(CreatedObjects.STUDENT3);
        university.addStudent(CreatedObjects.STUDENT4);
        university.addStudent(CreatedObjects.STUDENT5);

        university.addClass(new Date(2021, 04, 22), CreatedObjects.PROFESSOR1, "Basic Git");
        university.addClass(new Date(), CreatedObjects.PROFESSOR2, "Intermediate Git");
        university.addClass(new Date(), CreatedObjects.PROFESSOR3, "Advance Git");
        university.addClass(new Date(), CreatedObjects.PROFESSOR1, "Git workflows");

        //Java.util.function uses
        LOGGER.info(lowercaseProcessor("IM IN LOWERCASE", msg -> msg.toLowerCase(Locale.ROOT)));
        university.changeUniversityName("SOLVD");
        university.changeCareerName("Data Science");
        LOGGER.info("The average age of the students are: "+university.getAverageYearOfStudents());
        LOGGER.info("Students with the same age: "+university.getStudentsWithTheSameAge(25));
        //Functional Interfaces use

        //Using the lambda function in Student
        Student.CheckCollege(CreatedObjects.STUDENT1, "UTN");
        company.getJavaProgrammers();
        company.getProgrammersWithOs(OperativeSystem.WINDOWS);
        //Now with all the students of an University
        University.checkStudents(university);
    }
    public static String lowercaseProcessor(String msg, Function<String, String> processor){
        return processor.apply(msg);
    }
}
