package com.solvd.homework.exceptions;

public class InvalidYearsOfExperience extends Exception {
    @Override
    public String getMessage() {
        return "Wrong years of experience: Impossible years of experience";
    }
}