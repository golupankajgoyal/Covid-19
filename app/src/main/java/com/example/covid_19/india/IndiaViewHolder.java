package com.example.covid_19.india;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.IndiaData;
import com.example.covid_19.R;

public class IndiaViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageView imageView;
    public IndiaViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.total_cases);
        imageView=itemView.findViewById(R.id.icon);
    }

    public void bind(IndiaData indiaData){
        textView.setText("" + indiaData.getCases());
        imageView.setImageResource(indiaData.getImageResourceId());
    }
}
