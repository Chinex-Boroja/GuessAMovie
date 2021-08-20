package com.chinex_boroja;

import java.util.Scanner;

public class Game {

    //Declaring fields
    private final String moviesToGuess;
    private int pointsLost;
    private String wrongCharacters;
    private  String correctCharacters;
    private boolean gameWon;

    //Declaring default constructor and Initializing parameters
    public Game(String pathName) {
        ListOfMovies lisOfMovies = new ListOfMovies(pathName);
        moviesToGuess = lisOfMovies.getRandomMovie().trim();

        pointsLost = 0;
        correctCharacters = "";
        wrongCharacters = "";
        gameWon = false;
    }

    //getter to return movie title
    public String getMoviesToGuess() {
        return moviesToGuess;
    }
    /* method that replaces all the letters in the movie title with underscores pending if no letter has been guessed correctly */
    public String getHiddenMovies() {
        if (correctCharacters.equals("")) {
            return  moviesToGuess.replaceAll("[a-zA-Z]", "_");
        }
        else {
            return moviesToGuess.replaceAll("[a-zA-Z&&[^" + correctCharacters + "]]", "_");
        }
    }
    //Return letters guessed that are not in the movie
    public String getWrongCharacters() {
        return wrongCharacters;
    }
    public boolean isGameWon() {
        return gameWon;
    }
    public boolean gameEnded() {
        if (pointsLost >= 10) {
            return true;
        }
        if (!getHiddenMovies().contains("_")) {
            gameWon = true;
            return true;
        }
        return false;
    }
    //Method that asks the player to input a letter and converts it to lower case;

    private String inputCharacter() {
        System.out.println("Guess the letter: ");
        Scanner input = new Scanner(System.in);
        String character = input.nextLine().toLowerCase();

        if (!character.matches("[a-z]")) {
            System.out.println("This is not a letter.");
            return inputCharacter();
        }
        else if (wrongCharacters.contains(character) || correctCharacters.contains(character)) {
            System.out.println("You've guessed the letter already!");
            return inputCharacter();
        }
        else return character;
    }

    public void guessCharacter() {
        String guessedCharacter = inputCharacter();

        if (moviesToGuess.toLowerCase().contains(guessedCharacter)) {
            correctCharacters += guessedCharacter + guessedCharacter.toUpperCase();
        }
        else {
            pointsLost++;
            wrongCharacters += " " + guessedCharacter;
        }

    }

}
