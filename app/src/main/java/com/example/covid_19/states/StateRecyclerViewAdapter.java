package com.example.covid_19.states;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.StateData;

import java.util.List;

public class StateRecyclerViewAdapter extends RecyclerView.Adapter<StateViewHolder> {

    private List<StateData> stateData;

    public StateRecyclerViewAdapter(List<StateData> data) {
        stateData = data;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_states_data, parent, false);
        StateViewHolder stateViewHolder = new StateViewHolder(view);
        return stateViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {
        holder.bind(stateData.get(position));
    }

    @Override
    public int getItemCount() {
        return stateData.size();
    }
}
