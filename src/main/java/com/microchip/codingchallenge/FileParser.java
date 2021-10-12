package com.microchip.codingchallenge;

/**
 * FileParser is used to define an object which implements strategy and calls the method which is defined in the strategy object
 */

    public class FileParser {
    private Strategy strategy;

    public FileParser(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String input) {
        strategy.parseFile(input);
    }
}
