package com.solvd.homework.enums;

public enum Pets{
	BIRD( "Parrot", 1 ),
	FISH( "Goldfish", 1 ),
	CAT( "Ragdoll", 3 ),
	DOG( "Pug", 2 );
	
	private String breed;
	private int age;
	
	Pets( String breed, int age ){
		this.breed = breed;
		this.age = age;
	}
	
	public String getBreed( ){
		return breed;
	}
	
	public void setBreed( String breed ){
		this.breed = breed;
	}
	
	public int getAge( ){
		return age;
	}
	
	public void setAge( int age ){
		this.age = age;
	}
}
