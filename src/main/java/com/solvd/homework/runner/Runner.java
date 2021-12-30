package com.solvd.homework.runner;

import com.solvd.homework.classes.Person;
import com.solvd.homework.classes.University;
import com.solvd.homework.enums.StudyTopic;
import com.solvd.homework.exceptions.TooMuchStudyHours;
import com.solvd.homework.utils.CreatedObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class Runner{
	public static void main( String[] args ){
		Logger LOGGER = Logger.getLogger( Runner.class.getName( ) );
		Calendar calendar = Calendar.getInstance( );
		calendar.set( 2021, Calendar.JULY, 12 );
		Date date = calendar.getTime( );
		try{
			//Using the class University which has a LinkedHashSet - HashMap - TreeMap
			University university = new University( "University of SOLVD.inc", 2020 );
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
			
			
			university.removeStudent( CreatedObjects.STUDENT1 );
			university.removeProfessor( CreatedObjects.PROFESSOR2 );
			
			LOGGER.info( "ProfessorsList: " + university.getProfessorsList( ) );
			LOGGER.info( "universityMembers: " + university.getUniversityMembers( ) );
			LOGGER.info( "School Calendar: " + university.getSchoolCalendar( ) );
			LOGGER.info( "University careers: " + university.getCareers( ) );
			LOGGER.info( "Is professor the id 1010? " + university.isProfessor( 1010 ) );
			LOGGER.info( "Gender of " + CreatedObjects.PROFESSOR1.getFirstName( ) + " it's " + CreatedObjects.PROFESSOR1.getGender( ) );
			
			university.getCareers( ).show( );
			university.showProfessorsList( );
			university.showUniversityData( );
			
			CreatedObjects.STUDENT1.studyHoursInADay( 2, StudyTopic.PROGRAMMING.name( ) );
			Person.addFavouriteFood( "Taquitos" );
			
			LOGGER.info( "" + CreatedObjects.STUDENT1.getCareerName( ) );
			CreatedObjects.STUDENT1.setCareerName( "Java QA" );
			CreatedObjects.STUDENT1.changeInfo( "Alphonse", "Elric", "UTN", "JAVA QA" );
		}catch( TooMuchStudyHours e ){
			e.printStackTrace( );
		}
		
	}
	
}
