package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.app.Application;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import com.udacity.gradle.builditbigger.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MainActivityBasicTest {
    private MyApi myApi = null;
    private String name = "myName";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        mainActivityActivityTestRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction();
        mainActivityActivityTestRule.getActivity();

    }

    @Test
    public void test_that_main_activity_displays_the_button() {
        onView(withId(R.id.loadJoke)).check(matches(isDisplayed()));
    }

    @Test
    public void testAppGetsDataFromNetwork() {


                // perform a click event load another


     //   EndpointAsyncTask endpointAsyncTask = new Endp

//        final AsyncTask<Context, Void, String> dataCall = new
//                AsyncTask<Context, Void, String>() {
//                    @Override
//                    protected String doInBackground(Context... contexts) {
//
//                        MyApi.Builder builder = new MyApi.Builder(
//                                AndroidHttp.newCompatibleTransport(),
//                                new AndroidJsonFactory(), null)
//                                .setRootUrl("http://10.0.2.2:8080")
//                                .setApplicationName("Humlarious")
//                                .setGoogleClientRequestInitializer
//                                        (new GoogleClientRequestInitializer() {
//                                            @Override
//                                            public void initialize(AbstractGoogleClientRequest<?> request)
//                                                    throws IOException {
//                                                request.setDisableGZipContent(true);
//                                            }
//                                        });
//                        myApi = builder.build();
//
//                        String result = null;
//                        try {
//                            result = myApi.sayHi(name).execute().getData();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        return result;
//                    }
//
//                    @Override
//                    protected void onPostExecute(String results) {
//                        assert (results.equals("Hi, " + name));
//                    }
//                };

    }
}
