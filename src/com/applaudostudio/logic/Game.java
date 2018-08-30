package com.applaudostudio.logic;

import java.util.*;

public class Game {

    private int MaxIntent;

    public Game(int maxIntent) {
        MaxIntent = maxIntent;
    }


    /***
     * Function to hidde unfound letters of the movie name
     * @param movieName the name of a movie
     * @return a string with the hide name or the name if you found the full name of a movie.
     */
    private String hideLetters(String movieName, ArrayList<Character> letterList) {
        StringBuilder hideWord = new StringBuilder();
        for (Character ch : movieName.toCharArray()) {
            if (ch == ' ') {
                hideWord.append(" ");
            } else {
                hideWord.append("_");
            }
        }

        for (Character letter : letterList) {
            hideWord = new StringBuilder(this.replaceLetters(movieName, hideWord.toString(), letter));
        }

        return hideWord.toString();
    }

    /***
     * Function to replace letters on the hidden word
     * @param movieName name of the movie
     * @param hiddenWords hidden movie name
     * @param letter letter to check if it posible to hide
     * @return
     */
    private String replaceLetters(String movieName, String hiddenWords, Character letter) {
        String result;
        char[] hiddenArray = hiddenWords.toCharArray();

        for (int i = 0; i < movieName.length(); i++) {
            if (movieName.toCharArray()[i] == letter) {
                hiddenArray[i] = letter;
            }
        }
        result = String.valueOf(hiddenArray);
        return result;
    }


    /***
     *
     * @param word movies name
     * @param lettersList list of letters added by User
     * @return number of incorrect letters
     */
    private ArrayList<Character> getIncorrectLetters(String word, ArrayList<Character> lettersList) {
        ArrayList<Character> incorrectList = new ArrayList<>();
        for (Character letter : lettersList) {
            if (!word.contains(letter.toString()))
                incorrectList.add(letter);
        }
        return incorrectList;
    }


    private ArrayList<Character> getCorrectLetters(String word, ArrayList<Character> lettersList) {
        Player gamer = new Player();
        for (Character letter : lettersList) {
            if (word.contains(letter.toString())) {
                gamer.addCorrecLetterToList(letter);
            }

        }
        return gamer.getmCorrectLetters();
    }


    private String printIncorrect(ArrayList<Character> lettersList) {
        StringBuilder result = new StringBuilder();
        for (Character letter : lettersList) {
            result.append(letter).append(", ");
        }

        return result.toString();
    }


    /***
     * Function to randome choose a movie of the list
     * @param listOfMovies
     * @return
     */
    private String randomChooser(ArrayList<String> listOfMovies) {
        String randomWord;
        int randomIndex = (int) (Math.random() * listOfMovies.size());
        randomWord = listOfMovies.get(randomIndex);
        return randomWord;
    }


    /***
     * Function to start to playing
     * @throws Exception
     */
    public boolean startGame() throws Exception {
        Player player = new Player();
        Reader reader = new Reader();

        String randomMovieName;
        String Gueesed;
        Scanner scanner = new Scanner(System.in);


        randomMovieName = this.randomChooser(reader.getMoviesList());
        System.out.println("LETS PLAY GUESS A MOVIE");
        System.out.println("TRY TO FIND A HIDDEN MOVIE NAME");

        do {
            System.out.println("Please Enter a Letter (" + randomMovieName + ")");
            Character letter;
            letter = scanner.next().charAt(0);
            player.addLetterToList(letter);
            Gueesed = this.hideLetters(randomMovieName, player.getmListLetters());
            System.out.println("You Are Guessing: " + Gueesed);
            System.out.println("You Have guessed: (" + this.getCorrectLetters(randomMovieName, player.getmListLetters()).size() + ") Incorrect Letters: " + this.printIncorrect(this.getIncorrectLetters(randomMovieName, player.getmListLetters())));
            if (Gueesed.equals(randomMovieName)) {
                System.out.println("***** WOOOOOOOOH!! YOU ARE THE WINNER *****");
                return true;
            }

        } while (this.getIncorrectLetters(randomMovieName, player.getmListLetters()).size() < this.MaxIntent);


        System.out.println("DOH!! , YOU LOSE");

        return false;

    }


}
