package com.chinex_boroja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOfMovies {

    private ArrayList<String> movies;

    public ListOfMovies(String pathName) {
        movies = new ArrayList<>();
        File fileList = new File(pathName);

        //handling exceptions
        try {
            Scanner userInput = new Scanner(fileList);
            while (userInput.hasNextLine()) {
                movies.add(userInput.nextLine());
            }
        }catch (FileNotFoundException exception) {
            System.out.println("Error!!! File does not exist");
        }
    }

    //function to guess a movie randomly and return the result
    public String getRandomMovie() {
        int movieIndex = (int)(Math.random() * movies.size()); //movie is cast to int
        return movies.get(movieIndex);
    }
}
