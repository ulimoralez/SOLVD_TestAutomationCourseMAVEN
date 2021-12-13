package com.solvd.homework.runner;

import com.solvd.homework.classes.Student;
import com.solvd.homework.utils.CreatedObjects;

import java.lang.reflect.*;
import java.util.Date;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamRunner {
    public static void main(String[] args) throws ClassNotFoundException {
        Logger LOGGER = Logger.getLogger(StreamRunner.class.getName());
        CreatedObjects.university.addCareer("Machine Learning");
        CreatedObjects.university.addCareer("Web Development");
        CreatedObjects.university.addCareer("Software Development Engineer & Testing");

        CreatedObjects.university.addProfessor(CreatedObjects.PROFESSOR1);
        CreatedObjects.university.addProfessor(CreatedObjects.PROFESSOR2);
        CreatedObjects.university.addProfessor(CreatedObjects.PROFESSOR3);

        CreatedObjects.university.addStudent(CreatedObjects.STUDENT1);
        CreatedObjects.university.addStudent(CreatedObjects.STUDENT2);
        CreatedObjects.university.addStudent(CreatedObjects.STUDENT3);
        CreatedObjects.university.addStudent(CreatedObjects.STUDENT4);
        CreatedObjects.university.addStudent(CreatedObjects.STUDENT5);

        CreatedObjects.university.addClass(new Date(2021, 04, 22), CreatedObjects.PROFESSOR1, "Basic Git");
        CreatedObjects.university.addClass(new Date(), CreatedObjects.PROFESSOR2, "Intermediate Git");
        CreatedObjects.university.addClass(new Date(), CreatedObjects.PROFESSOR3, "Advance Git");
        CreatedObjects.university.addClass(new Date(), CreatedObjects.PROFESSOR1, "Git workflows");

        //Students
        LOGGER.info("Sort Students by Ascendant Age"+CreatedObjects.university.sortStudentByAscendantAge()+"\n");
        LOGGER.info("Filter Students by the age of 25"+CreatedObjects.university.filterStudentByAge(25)+"\n");
        LOGGER.info("Filter students that contains 'gen' in his firstname"+CreatedObjects.university.filterStudentsForFirstname(
                "gen")+"\n");
        LOGGER.info("Get minimun age Student "+CreatedObjects.university.getMinimunAgeStudent()+"\n");
        LOGGER.info("Total of studenss : "+CreatedObjects.university.getTotalOfStudents()+"\n");

        LOGGER.info("Added 10 years on Students age: "+CreatedObjects.university.addYearsOnStudentsAge(10)+"\n");
        LOGGER.info("First Student: "+CreatedObjects.university.getFirstStudent());
    }
}
