package com.applaudostudio.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

 class Reader {

    /***
     * Return the whole file of movies
     * @return the complete file
     */
    private File getFileContent() {
        return new File("movies.txt");
    }

    /***
     * Function to get the movies as a List
     * @throws Exception for files
     */
    ArrayList<String> getMoviesList() throws  Exception{
        ArrayList<String> movieList = new ArrayList<>();
        Scanner scanner = new Scanner(getFileContent());
        while(scanner.hasNextLine()){
            movieList.add(scanner.nextLine());
        }
        return movieList;
    }




}
