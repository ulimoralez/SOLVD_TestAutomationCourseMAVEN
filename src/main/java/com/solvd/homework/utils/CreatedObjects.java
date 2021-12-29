package com.solvd.homework.utils;

import com.solvd.homework.classes.*;
import com.solvd.homework.enums.Book;
import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;

public final class CreatedObjects{
	public static final Child CHILD1 = new Child( );
	public static final Child CHILD2 = new Child( );
	public static final Child CHILD3 = new Child( );
	public static final Child CHILD4 = new Child( );
	public static final Child CHILD5 = new Child( );
	public static final Person PERSON1 = new Person( "Lionel", "Messi", 34 );
	public static final Person PERSON2 = new Person( "Kylie", "Simpson", 29 );
	public static final Person PERSON3 = new Person( "Michael", "Jackson", 21 );
	public static final Person PERSON4 = new Person( "Morgan", "Freeman", 21 );
	public static final Person PERSON5 = new Person( "Ulises", "Moralez", 21 );
	public static final Professor PROFESSOR1 = new Professor( "Ulises", "Moralez", "UTN", "Programming", 1111 );
	public static final Professor PROFESSOR2 = new Professor( "Mozart", "Ella", "Programming", "UTN", 2222 );
	public static final Professor PROFESSOR3 = new Professor( "Chopin", "Nigth", "Data Science", "UTN", 3333 );
	public static final Professor PROFESSOR4 = new Professor( "Beeethoven", "Music", "Biology", "UNNE", 4444 );
	public static final Professor PROFESSOR5 = new Professor( "Kippie", "Bread", "UTN", "Programming", 5555 );
	public static final Professor PROFESSOR6 = new Professor( "Monika", "Ellum", "Female", 32, "Physics", "UTN",
			123123, Book.PROGRAMMING.getName( ) );
	public static final Professor PROFESSOR7 = new Professor( "Kippie", "Moralez", "Male", 34, "Physics", "UTN",
			124123, Book.PHYSICS.getName( ) );
	public static final Programmer PROGRAMMER1 = new Programmer( "Monika", "Townby", "Polygender", 3,
			ProgrammingLanguage.C.name( ), OperativeSystem.LINUX.name( ) );
	public static final Programmer PROGRAMMER2 = new Programmer( "Duffy", "Ellum", "Genderfluid", 3,
			ProgrammingLanguage.JAVASCRIPT.name( ), OperativeSystem.WINDOWS.name( ) );
	public static final Programmer PROGRAMMER3 = new Programmer( "Devlen", "Coppock", "Male", 3,
			ProgrammingLanguage.JAVA.name( ), OperativeSystem.MAC.name( ) );
	public static final Programmer PROGRAMMER4 = new Programmer( "Ripley", "Libero", "Agender", 3,
			ProgrammingLanguage.TYPESCRIPT.name( ), OperativeSystem.WINDOWS.name( ) );
	public static final Programmer PROGRAMMER5 = new Programmer( "Demetra", "Parlatt", "Sky", 3,
			ProgrammingLanguage.CSHARP.name( ), OperativeSystem.WINDOWS.name( ) );
	public static final Student STUDENT1 = new Student( "Stuart", "Sky", "Male", 25, "UTN",
			"TUP" );
	public static final Student STUDENT2 = new Student( "Ruthe", "Dockwray", "Male", 23, "UTN",
			"TUP" );
	public static final Student STUDENT3 = new Student( "Yoshiko", "Godfrey", "Bigender", 20, "UTN",
			"TUP" );
	public static final Student STUDENT4 = new Student( "Eugenie", "Arnatt", "Female", 27, "UTN",
			"TUP" );
	public static final Student STUDENT5 = new Student( "Vasilis", "Hackin", "Polygender", 25, "UTN",
			"TUP" );
	public static University university = new University( "SOLVD", 2021 );
	public static University university2 = new University( "JAVA", 2000 );
}
