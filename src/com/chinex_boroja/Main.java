package com.chinex_boroja;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("movieList.txt");

        System.out.println("Welcome to the game of Guess the Movie!");
        System.out.println("The rules are simple, the computer randomly picks a movie title, and shows you how many letters its made up of.");
        System.out.println("Your goal is to try to figure out the movie by guessing one letter at a time.");
        System.out.println("If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point.");
        System.out.println("If you lose 10 points, game over!!");
        System.out.println("Let's start!");
        System.out.println("the movie title has " + game.getMoviesToGuess().length() + " characters (including spaces and punctuation).");

        while(!game.gameEnded()){
            System.out.println("You are guessing: " + game.getHiddenMovies());
            System.out.println("You have guessed (" + game.getWrongCharacters().length()/2+ ") wrong letters" + game.getWrongCharacters());
            game.guessCharacter();
        }
        if (game.isGameWon()) {
            System.out.println("You win!");
            System.out.println("You have guessed '"+ game.getMoviesToGuess()+"' correctly");
        }
        else {
            System.out.println("You have guessed ("+ game.getWrongCharacters().length()/2 +") wrong letters:" + game.getWrongCharacters());
            System.out.println("You lost!");
            System.out.println("The movie title was "+ game.getMoviesToGuess());
            System.out.println("Better luck next time.");
        }

    }
}
