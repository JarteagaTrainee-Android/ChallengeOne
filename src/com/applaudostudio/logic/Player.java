package com.applaudostudio.logic;

import java.util.ArrayList;

public class Player {
    private int mTries;
    private ArrayList<Character> mListLetters;

    public Player() {
        mListLetters =new ArrayList<Character>();
    }


    public int getmTries() {
        return mTries;
    }

    public void setmTries(int mTries) {
        this.mTries = mTries;
    }

    public ArrayList<Character> getmListLetters() {
        return mListLetters;
    }

    public void setmListLetters(ArrayList<Character> mListLetters) {
        this.mListLetters = mListLetters;
    }

    /***
     * add a letter in the list of letters
     * @param letter new letter to be added
     * @return returns true or false if the letter is added.
     */
    public boolean addLetterToList(Character letter){
        if(!this.mListLetters.contains(letter)){
            mListLetters.add(letter);
            return true;
        }
        return false;
    }

}
