package com.solvd.homework.enums;

public enum StudyTopic {
    PROGRAMMING("Perfect function name", Book.PROGRAMMING),
    MATHS("Secret of the PI number", Book.MATH),
    LITERATURE("Orthography", Book.NOVEL),
    PRACTICE("Write code with SOLID", Book.PROGRAMMING),
    PHYSICS("General Physics", Book.PHYSICS);

    private String concept;
    private Book book;

    StudyTopic(String concept, Book book){
        this.concept = concept;
        this.book = book;
    }
}
