package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokesLib.JokeEngine;
import com.udacity.gradle.builditbigger.jokesLib.MyBean;

import javax.inject.Named;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {

        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "getJokes")
    public MyBean getJokes() {
        JokeEngine jokeEngine = new JokeEngine();

        MyBean jokeBean = new MyBean();
        String joke = jokeEngine.getMeAJoke();
        jokeBean.setJoke(joke);
        return jokeBean;
    }

}

