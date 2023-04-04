package com.example.bikerapplication;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class BikeListAdapter extends RecyclerView.Adapter<BikeListAdapter.MyViewHolder> {
    Context context;
    ArrayList<Bike> list;

    public BikeListAdapter(Context context, ArrayList<Bike> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showdatacardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bike bike = list.get(position);
        holder.bikeName.setText(bike.getBikeName());
        holder.bikePrice.setText(bike.getBikePrice());
        holder.bikeColor.setText(bike.getBikeColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bikeName, bikePrice, bikeColor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bikeName = itemView.findViewById(R.id.bikeshow);
            bikePrice = itemView.findViewById(R.id.model);
            bikeColor = itemView.findViewById(R.id.price);
        }
    }
}