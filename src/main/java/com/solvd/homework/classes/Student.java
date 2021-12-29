package com.solvd.homework.classes;

import com.solvd.homework.exceptions.TooMuchStudyHours;
import com.solvd.homework.functionalInterfaces.IStudentProcessor;
import com.solvd.homework.interfaces.IStudent;

import java.util.Objects;
import java.util.logging.Logger;

public class Student extends Person implements IStudent{
	private static final Logger LOGGER = Logger.getLogger( Student.class.getName( ) );
	private String collegeName;
	private String careerName;
	
	//Constructors
	public Student( ){
	
	}
	
	public Student( String firstName, String lastName, String gender, int age, String collegeName, String careerName ){
		this( firstName, lastName, gender, collegeName, careerName );
		super.setAge( age );
	}
	
	public Student( String firstName, String lastName, String gender, String collegeName, String careerName ){
		super( firstName, lastName, gender );
		changeInfo( collegeName, careerName );
	}
	
	//Methods and Functions
	public void changeInfo( String collegeName, String careerName ){
		this.collegeName = collegeName;
		this.careerName = careerName;
	}
	
	@Override
	public int hashCode( ){
		return Objects.hash( super.hashCode( ), collegeName, careerName );
	}
	
	@Override
	public boolean equals( Object o ){
		if( this == o ) return true;
		if( o == null || getClass( ) != o.getClass( ) ) return false;
		if( !super.equals( o ) ) return false;
		Student student = ( Student ) o;
		return Objects.equals( collegeName, student.collegeName ) && Objects.equals( careerName, student.careerName );
	}
	
	//Overriding Object functions
	@Override
	public String toString( ){
		return "Student{" +
				"FirstName = '" + super.getFirstName( ) + '\'' +
				", LastName ='" + super.getLastName( ) + '\'' +
				", Age ='" + super.getAge( ) + '\'' +
				'}';
	}
	
	@Override
	public void eat( ){
		LOGGER.info( "I eat when I'm not sleeping" );
	}
	
	@Override
	public void drink( ){
		LOGGER.info( "I love drink coffee" );
	}
	
	public Student( String firstName, String lastName, int age, String collegeName, String careerName ){
		super( firstName, lastName, age );
		changeInfo( collegeName, careerName );
	}
	
	public Student( String firstName, String lastName, String collegeName, String careerName ){
		super( firstName, lastName );
		changeInfo( collegeName, careerName );
	}
	
	//Lambdas
	public static void CheckCollege( Student student, String collegeName ){
		IStudentProcessor processor = ( Ostudent, OcollegeName ) -> {
			if( Ostudent.collegeName == collegeName ){
				LOGGER.fine( "The student: " + Ostudent.getFirstName( ) + " " + Ostudent.getLastName( ) + " has the same " +
						"college name than the University." );
			}else{
				LOGGER.severe( "The student: " + Ostudent.getFirstName( ) + " " + Ostudent.getLastName( ) + " has not the same " +
						"college name than the University :( ." );
			}
		};
		processor.checkCollege( student, collegeName );
	}
	
	public String getCollegeName( ){
		return collegeName;
	}
	
	public void setCollegeName( String collegeName ){
		this.collegeName = collegeName;
	}
	
	public String getCareerName( ){
		return careerName;
	}
	
	public void setCareerName( String careerName ){
		this.careerName = careerName;
	}
	
	public void changeInfo( String firstName, String lastName, String collegeName, String careerName ){
		super.setFirstName( firstName );
		super.setLastName( lastName );
		this.collegeName = collegeName;
		this.careerName = careerName;
	}
	
	public void studyHoursInADay( int hours, String studyTopic ) throws TooMuchStudyHours{
		if( hours > 24 ){
			throw new ArithmeticException( "This is impossible, a day only have 24 hours" );
		}else{
			if( hours > 15 ){
				throw new TooMuchStudyHours( );
			}else{
				LOGGER.info( "Sounds great! Tell me more about " + studyTopic );
			}
		}
	}
	
	//Overriding interface methods
	@Override
	public String themeToStudy( ){
		return ( "Java and Testing" );
	}
}
