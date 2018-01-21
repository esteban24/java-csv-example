package com.mycompany.app;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * @author Esteban Martín
 */
public class CsvFileReader
{
	//CSV file header
    private static final String [] HEADER = {"id", "firstName", "lastName", "gender", "age"};

	//Student attributes
	private static final String ID = "id";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";
	private static final String GENDER = "gender";
	private static final String AGE = "age";

	public static void readCsvFile(String fileName)
    {

		FileReader fileReader = null;

		CSVParser csvFileParser = null;

		//Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(HEADER);

        try {

        	//Create a new list of student to be filled by CSV file data
        	List<Student> students = new ArrayList<Student>();

            //initialize FileReader object
            fileReader = new FileReader(fileName);

            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);

            //Get a list of CSV file records
            List<CSVRecord> csvRecords = csvFileParser.getRecords();

            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
            	CSVRecord record = csvRecords.get(i);
            	//Create a new student object and fill his data
            	Student student = new Student(Long.parseLong(record.get(ID)), record.get(FIRSTNAME), record.get(LASTNAME), record.get(GENDER), Integer.parseInt(record.get(AGE)));
                students.add(student);
			}

            //Print the new student list
            for (Student student : students) {
				System.out.println(student.toString());
			}
        }
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

	}

}
