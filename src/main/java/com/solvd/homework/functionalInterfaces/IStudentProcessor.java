package com.solvd.homework.functionalInterfaces;

import com.solvd.homework.classes.Student;

@FunctionalInterface
public interface IStudentProcessor {
    void checkCollege(Student student, String collegeName);
}
