package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AppEngineTest  {

    private String result = null;

    @Test
    public void test_app_integrates_with_local_app_engine() {

        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask();
        endpointAsyncTask.execute();

        try {
            result = endpointAsyncTask.get();
            assert(result.contains("Hi, Manfred \n" +
                    "Q:"));

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}