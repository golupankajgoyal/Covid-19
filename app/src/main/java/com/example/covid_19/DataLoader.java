package com.example.covid_19;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.net.URL;

public class DataLoader extends AsyncTaskLoader<String> {

    private URL mUrl;

    public DataLoader(@NonNull Context context,URL url) {
        super(context);
        mUrl=url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        String jsonResponse = null;

        try {

            jsonResponse = NetworkUtils.getResponseFromUrl(mUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }
}
