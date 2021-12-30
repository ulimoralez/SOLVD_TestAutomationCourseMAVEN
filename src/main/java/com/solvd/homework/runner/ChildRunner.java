package com.solvd.homework.runner;

import com.solvd.homework.classes.Child;

public class ChildRunner{
	public static void main( String[] args ){
		Child child = new Child( "Marcus", "Sanabria" );
		
		child.changeInfo( "NotMarcus", "KindaSanabria", 10 );
		child.favouritePet( );
		child.sayHello( );
		Child.sayFavouriteGame( );
	}
}
