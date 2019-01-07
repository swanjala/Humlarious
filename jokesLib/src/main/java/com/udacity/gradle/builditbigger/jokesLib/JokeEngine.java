package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.builditbigger.jokesLib.JokeFactory;
import  java.util.Random;

import java.util.ArrayList;

public class JokeEngine {

    JokeFactory jokeFactory = new JokeFactory();

    public String getMeAJoke() {

        jokeFactory.loadJokes();

        ArrayList<String> jokeList = jokeFactory.supplyJokes();

        Random r = new Random();


        return jokeList.get(r.nextInt((jokeList.size() - 0) + 1));

    }
}
