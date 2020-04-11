package com.example.covid_19.states;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.StateData;

public class StateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView confirmedTv;
    private TextView activeTv;
    private TextView recoveredTv;
    private TextView deathTv;
    private TextView stateNameTv;
    private Button districtButton;
    private String stateName;

    public StateViewHolder(@NonNull View itemView) {
        super(itemView);
        confirmedTv = itemView.findViewById(R.id.state_confirmed_cases_count_tv);
        activeTv = itemView.findViewById(R.id.state_death_count_tv);
        recoveredTv = itemView.findViewById(R.id.state_death_count_tv);
        deathTv = itemView.findViewById(R.id.state_death_count_tv);
        stateNameTv = itemView.findViewById(R.id.state_name_tv);
        districtButton = itemView.findViewById(R.id.district_button);
        districtButton.setOnClickListener(this);
    }

    public void bind(StateData currentStateData) {
        confirmedTv.setText(String.valueOf(currentStateData.getmConfirmedCases()));
        activeTv.setText(String.valueOf(currentStateData.getmActiveCases()));
        recoveredTv.setText(String.valueOf(currentStateData.getmRecoveredCases()));
        deathTv.setText(String.valueOf(currentStateData.getmDeath()));
        stateName = currentStateData.getmStateName();
        stateNameTv.setText(stateName);
    }

    @Override
    public void onClick(View v) {
        NavDirections action = StateFragmentDirections.actionStateFragmentToDistricFragment().setStateName(stateName);
        Navigation.findNavController(v).navigate(action);
    }
}
