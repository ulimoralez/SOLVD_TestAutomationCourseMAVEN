package com.solvd.homework.enums;

public enum OperativeSystem {
    LINUX("Fedora"),
    WINDOWS("11"),
    MAC("MacOS");

    public String osVersion;

    OperativeSystem(String osVersion){
        this.osVersion = osVersion;
    }
}
