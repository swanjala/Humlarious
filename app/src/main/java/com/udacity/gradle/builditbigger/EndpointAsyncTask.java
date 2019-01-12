package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nanodegree.sam.mainfragment.MainActivityDisplay;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import android.util.Log;
import android.util.Pair;

public class EndpointAsyncTask extends
        AsyncTask<Pair<Context, String>, Void, String> {
    private MyApi myApiService = null;
    private static String ROOTURL = "http://10.0.2.2:8080/_ah/api";
    private static String APPLICATIONNAME = "Humlarious";
    private static String LOADERROR = "Unable to load data";
    private static String INTENTEXTRA = "JokeExtra";
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params){
        if(myApiService == null){
            MyApi.Builder builder = new
                    MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl(ROOTURL)
                    .setApplicationName(APPLICATIONNAME)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> request) {
                    request.setDisableGZipContent(true);
                }
            });
            myApiService = builder.build();
        }
        context = params[0].first;
        String name = params[0].second;

        try{
            return myApiService.sayHi(name).execute().getData().concat(
                    "\n" + myApiService.getJokes().execute().getJoke());
        } catch (IOException e){
            Log.e(APPLICATIONNAME, e.getMessage());
            return LOADERROR;

        }
    }
    @Override
    protected void onPostExecute(String result ){
        Intent intent = new Intent(context, MainActivityDisplay.class);
        intent.putExtra(INTENTEXTRA, result);
        context.startActivity(intent);

    }

}
