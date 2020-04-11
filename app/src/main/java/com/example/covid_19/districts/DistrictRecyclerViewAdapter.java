package com.example.covid_19.districts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.DistrictData;
import com.example.covid_19.R;

import java.util.List;

public class DistrictRecyclerViewAdapter extends RecyclerView.Adapter<DistrictViewHolder> {

    private List<DistrictData> districtData;

    public DistrictRecyclerViewAdapter(List<DistrictData> data){
        districtData=data;
    }

    @NonNull
    @Override
    public DistrictViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_district_data,parent,false);
        DistrictViewHolder districtViewHolder=new DistrictViewHolder(view);
        return districtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DistrictViewHolder holder, int position) {
        holder.bind(districtData.get(position));
    }

    @Override
    public int getItemCount() {
        return districtData.size();
    }
}
