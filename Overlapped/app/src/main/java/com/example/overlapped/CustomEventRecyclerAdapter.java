package com.example.overlapped;


import android.app.usage.UsageEvents;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomEventRecyclerAdapter extends RecyclerView.Adapter<CustomEventRecyclerAdapter.ViewHolder>  {
    Context context;
    ArrayList<Event> events;
    private

    public CustomEventRecyclerAdapter(Context context, ArrayList<Event> events) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView monthText;
        private TextView dayNumberText;
        private TextView nameOfEventText;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            monthText = view.findViewById(R.id.month_text);
            dayNumberText = view.findViewById(R.id.day_number_text);
            nameOfEventText = view.findViewById(R.id.event_title);
        }

        public TextView getMonthText() {
            return this.monthText;
        }

        public TextView getDayNumberText() {
            return this.dayNumberText;
        }

        public TextView getNameOfEventText() {
            return this.nameOfEventText;
        }
    }

}
