package com.solvd.homework.enums;

public enum Book {
    NOVEL("The Great Gatsby", 1925),
    ACTION("Sinsajo", 2010),
    SUSPENSE("The Last Thing He Told Me", 2021),
    PROGRAMMING("Clean Code", 2008),
    MATH("Infinite Powers: How Calculus Reveals the Secrets of the Universe", 2019),
    FAIRYTALE("Grimms' Fairy Tales", 1812),
    PHYSICS("The Feynman Lectures on Physics", 1963);

    private String name;
    private int ageOfPublication;

    Book(String name, int ageOfPublication){
        this.name = name;
        this.ageOfPublication = ageOfPublication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeOfPublication() {
        return ageOfPublication;
    }

    public void setAgeOfPublication(int ageOfPublication) {
        this.ageOfPublication = ageOfPublication;
    }
}
