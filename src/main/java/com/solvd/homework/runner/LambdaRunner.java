package com.solvd.homework.runner;

import com.solvd.homework.classes.Company;
import com.solvd.homework.classes.Programmer;
import com.solvd.homework.classes.Student;
import com.solvd.homework.classes.University;
import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;
import com.solvd.homework.functionalInterfaces.IOperativeSystemProcessor;
import com.solvd.homework.functionalInterfaces.IProgrammingLanguagesProcessor;
import com.solvd.homework.functionalInterfaces.IStudentProcessor;
import com.solvd.homework.utils.CreatedObjects;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;

public class LambdaRunner{
	public static void main( String[] args ){
		Logger LOGGER = Logger.getLogger( Runner.class.getName( ) );
		Calendar cal = Calendar.getInstance( );
		cal.set( 2001, Calendar.APRIL, 22 );
		Date date = cal.getTime( );
		
		ArrayList< ProgrammingLanguage > programmingLanguages = new ArrayList<>( );
		programmingLanguages.add( ProgrammingLanguage.JAVA );
		programmingLanguages.add( ProgrammingLanguage.JAVASCRIPT );
		
		ArrayList< Programmer > programmers = new ArrayList<>( );
		programmers.add( CreatedObjects.PROGRAMMER1 );
		programmers.add( CreatedObjects.PROGRAMMER2 );
		programmers.add( CreatedObjects.PROGRAMMER3 );
		programmers.add( CreatedObjects.PROGRAMMER4 );
		programmers.add( CreatedObjects.PROGRAMMER5 );
		
		Company company = new Company( "SOLVD", date, programmingLanguages, programmers );
		
		University university = new University( "UTN", 2020 );
		university.addCareer( "Software Engineering" );
		university.addCareer( "Machine Learning" );
		university.addCareer( "Web Development" );
		university.addCareer( "Software Development Engineer & Testing" );
		
		university.addProfessor( CreatedObjects.PROFESSOR1 );
		university.addProfessor( CreatedObjects.PROFESSOR2 );
		university.addProfessor( CreatedObjects.PROFESSOR3 );
		
		university.addStudent( CreatedObjects.STUDENT1 );
		university.addStudent( CreatedObjects.STUDENT2 );
		university.addStudent( CreatedObjects.STUDENT3 );
		university.addStudent( CreatedObjects.STUDENT4 );
		university.addStudent( CreatedObjects.STUDENT5 );
		
		university.addClass( date, CreatedObjects.PROFESSOR1, "Basic Git" );
		university.addClass( date, CreatedObjects.PROFESSOR2, "Intermediate Git" );
		university.addClass( date, CreatedObjects.PROFESSOR3, "Advance Git" );
		university.addClass( date, CreatedObjects.PROFESSOR1, "Git workflows" );
		
		//Java.util.function uses
		LOGGER.info( lowercaseProcessor( "IM IN LOWERCASE", msg -> msg.toLowerCase( Locale.ROOT ) ) );
		university.changeUniversityName( "SOLVD" );
		university.changeCareerName( "Data Science" );
		LOGGER.info( "The average age of the students are: " + university.getAverageYearOfStudents( ) );
		LOGGER.info( "Students with the same age: " + university.getStudentsWithTheSameAge( 25 ) );
		//Functional Interfaces use
		
		//Using the lambda function in Student
		IStudentProcessor studentProcessor = ( student, collegeName ) -> {
			if( Objects.equals( student.getCollegeName( ), collegeName ) ){
				LOGGER.fine( "The student: " + student.getFirstName( ) + " " + student.getLastName( ) + " has the same " +
						"college name than the University." );
			}else{
				LOGGER.severe( "The student: " + student.getFirstName( ) + " " + student.getLastName( ) + " has not the same " +
						"college name than the University :( ." );
			}
		};
		Student.CheckCollege( CreatedObjects.STUDENT1, "UTN", studentProcessor );
		
		IProgrammingLanguagesProcessor iProgrammingLanguagesProcessor = programmerList -> {
			ArrayList< Programmer > programmersInJava = new ArrayList<>( );
			programmerList.forEach( programmer -> {
				if( Objects.equals( programmer.getFavoriteLanguage( ), ProgrammingLanguage.JAVA.name( ) ) ){
					LOGGER.info( "Programmer: " + programmer.getFirstName( ) + " " + programmer.getLastName( ) );
					programmersInJava.add( programmer );
				}
			} );
			return programmersInJava;
		};
		company.getJavaProgrammers( iProgrammingLanguagesProcessor );
		
		IOperativeSystemProcessor iOperativeSystemProcessor = ( programmersList, os ) -> {
			ArrayList< Programmer > programmersWithOs = new ArrayList<>( );
			programmersList.forEach( programmer -> {
				if( Objects.equals( programmer.getFavoriteOS( ), os.name( ) ) ){
					LOGGER.info( "Programmer with " + os.name( ) + ". Name: " + programmer.getFirstName( ) + " LastName: " + programmer.getLastName( ) );
					programmersWithOs.add( programmer );
				}
			} );
			return programmersWithOs;
		};
		company.getProgrammersWithOs( iOperativeSystemProcessor, OperativeSystem.WINDOWS );
		
		//Now with all the students of an University
		IStudentProcessor studentsProcessor = ( student, collegeName ) -> {
			if( Objects.equals( student.getCollegeName( ), collegeName ) ){
				LOGGER.fine( "The student: " + student.getFirstName( ) + " " + student.getLastName( ) + " has the same " +
						"college name than the University." );
			}else{
				LOGGER.severe( "The student: " + student.getFirstName( ) + " " + student.getLastName( ) + " has not the same " +
						"college name than the University :( ." );
			}
		};
		University.checkStudents( studentsProcessor, university );
	}
	
	public static String lowercaseProcessor( String msg, Function< String, String > processor ){
		return processor.apply( msg );
	}
}
