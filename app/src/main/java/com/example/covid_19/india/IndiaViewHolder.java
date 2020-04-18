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
    private TextView title_tv;
    public IndiaViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.total_cases);
        imageView=itemView.findViewById(R.id.icon);
        title_tv=itemView.findViewById(R.id.title);
    }

    public void bind(IndiaData indiaData){
        textView.setText("" + indiaData.getCases());
        title_tv.setText(""+ indiaData.getCasesTitle());
        imageView.setImageResource(indiaData.getImageResourceId());
    }
}
