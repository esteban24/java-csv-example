package com.mycompany.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * @author Esteban Martín
 */
public class CsvFileWriter
{
	//Delimiter used in CSV file
	private static final String NEW_LINE_SEPARATOR = "\n";

	//CSV file header
	private static final Object [] FILE_HEADER = {"id","firstName","lastName","gender","age"};

	public static void writeCsvFile(String fileName)
	{

		//Create new students objects
		Student student1 = new Student(1, "Esteban", "Martín", "M", 25);
		Student student2 = new Student(2, "Sara", "Gallego", "F", 23);
		Student student3 = new Student(3, "Ronaldo", "Rua", "M", 24);
		Student student4 = new Student(4, "Roberto", "Gallardo", "M", 20);
		Student student5 = new Student(5, "Magdalena", "Álvarez", "F", 22);
		Student student6 = new Student(6, "Margarita", "Pérez", "F", 21);

		//Create a new list of student objects
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		//Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\r\n");

		try {

			//initialize FileWriter object
			fileWriter = new FileWriter(fileName);

			//initialize CSVPrinter object
	        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

	        //Create CSV file header
	        csvFilePrinter.printRecord(FILE_HEADER);

			//Write a new student object list to the CSV file
			for (Student student : students) {
				List<String> studentDataRecord = new ArrayList<String>();
	            studentDataRecord.add(String.valueOf(student.getId()));
	            studentDataRecord.add(student.getFirstName());
	            studentDataRecord.add(student.getLastName());
	            studentDataRecord.add(student.getGender());
	            studentDataRecord.add(String.valueOf(student.getAge()));
	            csvFilePrinter.printRecord(studentDataRecord);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
			}
		}
	}
}
