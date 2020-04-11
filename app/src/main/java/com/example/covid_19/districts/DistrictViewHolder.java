package com.example.covid_19.districts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.DistrictData;
import com.example.covid_19.R;

public class DistrictViewHolder extends RecyclerView.ViewHolder {

    TextView districtNameTv;
    TextView totalCasesTv;
    public DistrictViewHolder(@NonNull View itemView) {
        super(itemView);
        districtNameTv=itemView.findViewById(R.id.district_name_tv);
        totalCasesTv=itemView.findViewById(R.id.district_total_cases_count_tv);
    }

    public void bind(DistrictData districtData){
        districtNameTv.setText(String.valueOf(districtData.getmDistrictName()));
        totalCasesTv.setText(String.valueOf(districtData.getmTotalCases()));
    }
}
