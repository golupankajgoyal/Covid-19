package com.example.covid_19.states;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.DataLoader;
import com.example.covid_19.NetworkUtils;
import com.example.covid_19.R;
import com.example.covid_19.StateData;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StateFragment extends Fragment implements LoaderManager.LoaderCallbacks<String> {

    private final static String STATE_URL = "https://api.rootnet.in/covid19-in/unofficial/covid19india.org/statewise";
    private static URL url;
    private StateRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public StateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_state, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView=view.findViewById(R.id.state_recyclerView);
        url=NetworkUtils.buildUrl(STATE_URL);
        ConnectivityManager cm = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork!= null && activeNetwork.isConnected()){
            getLoaderManager().initLoader(0,null,this);
        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new DataLoader(getContext(),url);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        List<StateData> formattedData=null;
        formattedData=NetworkUtils.getFormattedStateData(data);
        mAdapter=new StateRecyclerViewAdapter(formattedData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
