package com.applaudostudio.logic;

import java.util.ArrayList;

class Player {
    private ArrayList<Character> mListLetters;
    private ArrayList<Character> mCorrectLetters;

    Player() {
        mListLetters =new ArrayList<>();
        mCorrectLetters = new ArrayList<>();
    }

    ArrayList<Character> getmListLetters() {
        return mListLetters;
    }
    ArrayList<Character> getmCorrectLetters() {
        return mCorrectLetters;
    }


    /***
     * add a letter in the list of letters
     * @param letter new letter to be added
     */
     void addLetterToList(Character letter){
        if(!this.mListLetters.contains(letter)){
            mListLetters.add(letter);
        }
    }

    /***
     * Function to add correct letters to the list
     * @param letter
     */
    void addCorrecLetterToList(Character letter){
        if(!this.mCorrectLetters.contains(letter)){
            mCorrectLetters.add(letter);
        }
    }


}
