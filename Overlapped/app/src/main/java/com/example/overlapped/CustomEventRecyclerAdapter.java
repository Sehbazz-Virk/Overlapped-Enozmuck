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
    ArrayList<Event> events; //TODO: Need to actually implement the event class.
    //TODO: Add listener.

    public CustomEventRecyclerAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////        holder.getMonthText().setText(getEvents().get(position)//TODO Add the getText from the event here);
//    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    private ArrayList<Event> getEvents() {
//        return this.events;
//    }

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
