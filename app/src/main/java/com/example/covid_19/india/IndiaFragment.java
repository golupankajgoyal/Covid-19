package com.example.covid_19.india;


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
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.DataLoader;
import com.example.covid_19.IndiaData;
import com.example.covid_19.NetworkUtils;
import com.example.covid_19.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class IndiaFragment extends Fragment implements LoaderManager.LoaderCallbacks<String> {

    private final static String STATE_URL = "https://api.rootnet.in/covid19-in/unofficial/covid19india.org/statewise";
    private RecyclerView mRecyclerView;
    private IndiaRecyclerViewAdapter mAdapter=null;
    private URL url=null;

    public IndiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_india,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView=view.findViewById(R.id.recyclerView);
        url= NetworkUtils.buildUrl(STATE_URL);
        ConnectivityManager cm = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork!= null && activeNetwork.isConnected()){
            getLoaderManager().initLoader(1,null,this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new DataLoader(getContext(),url);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

        List<IndiaData> formattedData=new ArrayList<>();
        formattedData=NetworkUtils.getIndiaFormattedData(data);
        mAdapter=new IndiaRecyclerViewAdapter(formattedData);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
