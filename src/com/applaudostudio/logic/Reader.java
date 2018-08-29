package com.applaudostudio.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private String word;
    private ArrayList<String> movieList;

    /***
     * Return the whole file of movies
     * @return the complete file
     * @throws Exception
     */
    private File getFileContent() throws Exception {
        File file = new File("movies.txt");
        return file;
    }

    /***
     * Function to get the movies as a List
     * @return Arraylist of Movies
     * @throws Exception for files
     */
    public ArrayList<String> getMoviesList () throws  Exception{
        movieList = new ArrayList<String>();
        Scanner scanner = new Scanner(getFileContent());
        while(scanner.hasNextLine()){
            movieList.add(scanner.nextLine());
        }
        return this.movieList;
    }




}
