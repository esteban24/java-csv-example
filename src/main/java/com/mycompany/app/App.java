package com.mycompany.app;

/**
 * @author Esteban Martín
 */
public class App
{
    public static void main( String[] args )
    {
		String fileName = System.getProperty("user.home") + "/student.csv";

		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);

		System.out.println("\nRead CSV file:");
		CsvFileReader.readCsvFile(fileName);
    }
}
