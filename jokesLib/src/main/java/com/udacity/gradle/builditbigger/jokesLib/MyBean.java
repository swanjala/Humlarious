package com.udacity.gradle.builditbigger.jokesLib;

public class MyBean {

    public String myData;
    public String joke;

    public String getData(){
        return myData;
    }
    public void setData(String data){
        myData = data;
    }
    public void setJoke(String jokeString) {
        joke = jokeString;
    }
    public String getJoke() {
        return joke;
    }


}
