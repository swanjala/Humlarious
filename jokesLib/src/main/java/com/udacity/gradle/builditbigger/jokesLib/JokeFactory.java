package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;

public class JokeFactory {

    public ArrayList<String> jokesList;

    public String jokes;

    public void loadJokes () {

        jokesList.add("Q: What did the grandma cat say to her grandson when she saw him slouching? " +
                "A: You need to pay more attention to my pawsture.");
        jokesList.add("Q: What does lactose free milk wish to the world?\n" +
                "\n" +
                "A: Soy to the world");
        jokesList.add("Q: What does lactose free milk wish to the world?\n" +
                "\n" +
                "A: Soy to the world");
    }
    public String supplyJokes() {
        return jokes;
    }
}
