package com.solvd.homework.classes;

import com.solvd.homework.customlinkedlist.GenericLinkedList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class University{
	private static final Logger LOGGER = Logger.getLogger( University.class.getName( ) );
	//The unique way to create if it's in the constructor
	private final HashSet< String > universityMembers = new HashSet<>( );
	//Key = professorId - Value = Proffesor firstname and lastname
	private final HashMap< Integer, String > professorsList = new HashMap<>( );
	//Ordered as inserted
	private final LinkedHashSet< String > classDates = new LinkedHashSet<>( );
	//Careers that have the Uni
	private final GenericLinkedList< String > careers = new GenericLinkedList<>( );
	//Have no order and can have duplicates
	ArrayList< Student > studentsList = new ArrayList<>( );
	private String name;
	private int yearOfFoundation;
	private int averageAgeOfStudents = 0;
	
	public University( String name, int yearOfFoundation ){
		this.name = name;
		int currentYear = Calendar.getInstance( ).get( Calendar.YEAR );
		if( yearOfFoundation > 1000 || yearOfFoundation < currentYear ){
			this.yearOfFoundation = yearOfFoundation;
		}else{
			LOGGER.severe( "Invalid date in year of foundation" );
		}
	}
	
	public static void checkStudents( University university ){
		university.studentsList.forEach( student -> Student.CheckCollege( student, university.name ) );
	}
	
	//Adders
	public void addProfessor( Professor... professor ){
		for( Professor value : professor ){
			this.universityMembers.add( value.getFirstName( ) + " " + value.getLastName( ) );
			professorsList.put( value.getId( ), value.getFirstName( ) + " " + value.getLastName( ) );
		}
	}
	
	public void addStudent( Student... student ){
		for( Student value : student ){
			this.universityMembers.add( value.getFirstName( ) + " " + value.getLastName( ) );
			this.studentsList.add( value );
		}
	}
	
	public void addClass( Date date, Professor professor, String theme ){
		classDates.add( date + " " +
				"\nProfessor " + professor.getFirstName( ) + " " + professor.getLastName( ) + " it's explainig: " + theme );
	}
	
	public void addCareer( String careerName ){
		this.careers.insert( careerName );
	}
	
	//Remove
	public void removeStudent( Student student ){
		this.universityMembers.remove( student );
	}
	
	public void removeProfessor( Professor professor ){
		professorsList.remove( professor );
	}
	
	//Getters
	public HashMap getProfessorsList( ){
		return this.professorsList;
	}
	
	public LinkedHashSet getSchoolCalendar( ){
		return this.classDates;
	}
	
	public HashSet< String > getUniversityMembers( ){
		return universityMembers;
	}
	
	public GenericLinkedList getCareers( ){
		return this.careers;
	}
	
	public String getName( ){
		return name;
	}
	
	//Methods
	public boolean isProfessor( int professorid ){
		return professorsList.containsKey( professorid );
	}
	
	public void changeUniversityName( String newName ){
		this.name = newName;
		this.studentsList.forEach( student -> student.setCollegeName( newName ) );
	}
	
	//Foreach implements a Consumer function, I think it applies to the task
	public void changeCareerName( String newCareerName ){
		this.studentsList.forEach( x -> x.changeInfo( x.getCollegeName( ), newCareerName ) );
	}
	
	public int getAverageYearOfStudents( ){
		this.averageAgeOfStudents = 0;
		Consumer< Student > consumer = student -> {
			LOGGER.info( "" + student.getAge( ) );
			this.averageAgeOfStudents += student.getAge( );
		};
		this.studentsList.forEach( consumer );
		return this.averageAgeOfStudents / this.studentsList.size( );
	}
	
	public ArrayList< Student > getStudentsWithTheSameAge( int age ){
		ArrayList< Student > result;
		Function< ArrayList< Student >, ArrayList< Student > > function = ( studentList ) -> {
			ArrayList< Student > studentsWithTheSameAge = new ArrayList<>( );
			studentList.forEach( student -> {
				if( student.getAge( ) == age ){
					LOGGER.info( "Student: " + student.getFirstName( ) + " " + student.getLastName( ) + ". Age: " + student.getAge( ) );
					studentsWithTheSameAge.add( student );
				}
			} );
			return studentsWithTheSameAge;
		};
		result = function.apply( this.studentsList );
		return result;
	}
	
	//Non-Terminal operations Stream
	public ArrayList< Student > filterStudentsForFirstname( String pattern ){
		return new ArrayList<>( this.studentsList.stream( )
				.filter( student -> student.getFirstName( ).contains( pattern ) )
				.collect( Collectors.toList( ) ) );
	}
	
	public ArrayList< Student > filterStudentByAge( int age ){
		return new ArrayList<>( this.studentsList.stream( )
				.filter( student -> student.getAge( ) == age )
				.collect( Collectors.toList( ) ) );
	}
	
	public ArrayList< Student > sortStudentByAscendantAge( ){
		return new ArrayList<>( this.studentsList.stream( )
				.sorted( Comparator.comparing( Student::getAge ) )
				.collect( Collectors.toList( ) ) );
	}
	
	//Terminal streams
	public Optional< Student > getMinimunAgeStudent( ){
		Stream< Student > students = this.studentsList.stream( );
		
		return students
				.min( Comparator.comparingInt( Student::getAge ) );
	}
	
	public Long getTotalOfStudents( ){
		Stream< Student > students = this.studentsList.stream( );
		
		return students
				.count( );
	}
	
	public Stream< Student > addYearsOnStudentsAge( int age ){
		Stream< Student > students = this.studentsList.stream( );
		students.forEach( student -> {
			student.setAge( student.getAge( ) + age );
			LOGGER.info( "Age of: " + student );
		} );
		return students;
	}
	
	public Optional< Student > getFirstStudent( ){
		Stream< Student > studentStream = this.studentsList.stream( );
		return studentStream.findFirst( );
	}
	
	
	//Showing methods
	public void showProfessorsList( ){
		for( Integer key : professorsList.keySet( ) ){
			LOGGER.info( "IdProfessor: " + key + " - Name: " + professorsList.get( key ) );
		}
	}
	
	/**
	 * Returns the total of Students, professors and careers
	 */
	public void showUniversityData( ){
		LOGGER.info( "The university called: " + this.name + " Founded at: " + this.yearOfFoundation + "\nHas a total of: " + ( universityMembers.size( ) + 1 ) + " members." +
				"\n" + professorsList.size( ) + " are professors" +
				"\n" + studentsList.size( ) + " are students" );
	}
}
