package com.example.covid_19.india;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.IndiaData;
import com.example.covid_19.R;

import java.util.List;

public class IndiaRecyclerViewAdapter extends RecyclerView.Adapter<IndiaViewHolder> {

    private List<IndiaData> mData;

    public IndiaRecyclerViewAdapter(List<IndiaData> data){
        mData=data;
    }

    @NonNull
    @Override
    public IndiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_india_data,parent,false);
        IndiaViewHolder viewHolder=new IndiaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IndiaViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        } else
            return mData.size();
    }


}
