package com.solvd.homework.exceptions;

public class InvalidDNI extends Exception {
    @Override
    public String getMessage() {
        return "Wrong DNI: Invalid length of DNI, can't be more or lees than 8 digits";
    }
}
