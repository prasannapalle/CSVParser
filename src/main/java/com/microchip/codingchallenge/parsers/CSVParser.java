package com.microchip.codingchallenge.parsers;

import com.microchip.codingchallenge.Strategy;
import com.microchip.codingchallenge.ValidateColumns;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVParser implements Strategy {

    ValidateColumns validate = new ValidateColumns();

    /**
     * parseFile method is uses CSVReader to parse the contents of the CSV file
     *
     * @param input
     */
    @Override
    public void parseFile(String input) {
        System.out.println("In CSV file strategy");
        //The array list which is used to read the column values of the table
        List<String[]> data = new ArrayList<>();
        //headings are the column names
        List<String> headings = new ArrayList<>();
        //header indexes are used to store the position of the columns
        HashMap<Integer, String> headerindexes = new HashMap<>();
        //The CSV Reader is used to parse the file with filename stored in input
        try (CSVReader reader = new CSVReader(new FileReader(input))) {
            headings = Arrays.asList(reader.peek()); // peek() method is used to get the first row of the file
            data = reader.readAll(); // reads all the lines of the CSV file
        } catch (IOException | CsvException ioException) {
            ioException.printStackTrace();
        }
        int count = 0;
        //iterate through the headings and store its positions in hashmap - headerindexes
        for (String header : headings) {
            headerindexes.put(count++, header);
            System.out.println(header);
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the number of Columns to be displayed ");
        int num = myObj.nextInt();
        System.out.println("Number of columns are : " + num);
        HashSet<Integer> headers = new HashSet<>();
        /**
         * Accept the number of columns followed by the names of the columns
         */
        int numColumns = num;
        while (numColumns >= 0) {
            String str = myObj.nextLine();
            for (int i = 0; i < headings.size(); i++) {

                if (str.equalsIgnoreCase(headings.get(i))) {
                    headers.add(i);
                }
            }
            numColumns--;
        }


        int listIndex = 0;
        /**
         *         iterate through the r arraylist of string arrays and find the appropriate column to display their values
         */
        for (String[] arrays : data) { // each row in the data


            listIndex++;


            int index = 0;
            for (String array : arrays) { // iterate through each column int the data


                if (headers.contains(index)) {

                    if (listIndex == 1)
                        System.out.print(array + "\t");
                    else {
                        //checking for invalid formats and displaying the proper data to the user
                        array = validate.checkForInvalidFormats(headerindexes.get(index), array);
                        System.out.print(array + "\t\t");

                    }
                }


                index++;
            }
            System.out.println();


        }
    }
}
