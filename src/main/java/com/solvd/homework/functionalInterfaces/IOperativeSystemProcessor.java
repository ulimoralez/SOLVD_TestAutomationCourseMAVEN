package com.solvd.homework.functionalInterfaces;

import com.solvd.homework.classes.Programmer;
import com.solvd.homework.enums.OperativeSystem;

import java.util.ArrayList;

public interface IOperativeSystemProcessor{
	ArrayList< Programmer > getProgrammersIn( ArrayList< Programmer > programmersList, OperativeSystem operativeSystem );
}
