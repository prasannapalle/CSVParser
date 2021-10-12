package com.microchip.codingchallenge;

import com.microchip.codingchallenge.parsers.CSVParser;

/**
 * Main Application - Contains Main() method and user enters the file name as input in the command line arguments
 */
public class MainApplication {
    public static void main(String args[]) {

        //Lets say the client needs to parse an XML file
        //The file type(XML/CSV) or extensions in future can also be taken as
        //input from command line args[]
        //based on the extension we can select the specific parser and parse the file
        String inputfilename = args[0];
        //The CSVParser object is sent to the FileParser
        FileParser fileParser = new FileParser(new CSVParser());
        fileParser.executeStrategy(inputfilename);
    }
}
