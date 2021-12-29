package com.solvd.homework.exceptions;

public class InvalidProfessorID extends Exception{
	@Override
	public String getMessage( ){
		return "Wrong Professor ID - Input a valid ID";
	}
}
