package com.udacity.gradle.builditbigger.jokesLib;

import java.util.ArrayList;

public class JokeFactory {

    String joke;
    ArrayList<String> jokesList = new ArrayList<>();


    public void loadJokes () {

        this.jokesList.add("Q: What did the grandma cat say to her grandson when she saw him slouching? " +
                "A: You need to pay more attention to my pawsture.");
        this.jokesList.add("Q: What did the fish say when he hit his head?\n" +
                "\n" +
                "A: Dam!");
        this.jokesList.add("Q: What does lactose free milk wish to the world?\n" +
                "\n" +
                "A: Soy to the world");
    }
    public ArrayList<String> supplyJokes() {

        return jokesList;
    }

}
