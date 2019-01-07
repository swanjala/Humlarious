package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


@RunWith(AndroidJUnit4.class)
public class MainActivityBasicTest {
    private MyApi myApi = null;
    private String name = "myName";

    @Test
    public void testAppGetsDataFromNetwork() {

        final AsyncTask<Context, Void, String> dataCall = new
                AsyncTask<Context, Void, String>() {
                    @Override
                    protected String doInBackground(Context... contexts) {

                        MyApi.Builder builder = new MyApi.Builder(
                                AndroidHttp.newCompatibleTransport(),
                                new AndroidJsonFactory(), null)
                                .setRootUrl("http://10.0.2.2:8080")
                                .setApplicationName("Humlarious")
                                .setGoogleClientRequestInitializer
                                        (new GoogleClientRequestInitializer() {
                                            @Override
                                            public void initialize(AbstractGoogleClientRequest<?> request)
                                                    throws IOException {
                                                request.setDisableGZipContent(true);
                                            }
                                        });
                        myApi = builder.build();

                        String result = null;
                        try {
                            result = myApi.sayHi(name).execute().getData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return result;
                    }

                    @Override
                    protected void onPostExecute(String results) {
                        assert (results.equals("Hi, " + name));
                    }
                };

    }
}
