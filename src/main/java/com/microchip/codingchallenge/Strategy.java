package com.microchip.codingchallenge;

/**
 * The Strategy interface is implemented by the CSVParser and its methods are overriden by the implementation class
 */
public interface Strategy {
    public void parseFile(String input);
}