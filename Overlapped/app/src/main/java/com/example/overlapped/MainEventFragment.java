package com.example.overlapped;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainEventFragment extends Fragment implements RecyclerClickListener{
    FloatingActionButton addEvent;
    CalendarView calendarToAdd;
    RecyclerView eventRecyclerView;
    MaterialCalendarView calendarView;
    Database db;
    private View myView;

    @Override
    @NonNull
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        initializeViews();
    }

    private void initializeViews() {

        calendarView = (MaterialCalendarView) this.getView().findViewById(R.id.calendarView);
        eventRecyclerView = (RecyclerView) this.getView().findViewById(R.id.event_recycler);

        ArrayList<Event> allEvents = new ArrayList<Event>();
        CustomEventRecyclerAdapter recyclerAdapter = new CustomEventRecyclerAdapter(this.getActivity(), allEvents);
        eventRecyclerView.setAdapter(recyclerAdapter);

        db = Database.getInstance();
        List<CalendarDay> eventDays = new ArrayList<>();

        db.getConcreteEventsCollectionRef().whereArrayContains("users",
                FirebaseAuth.getInstance().getCurrentUser().getEmail()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        //List<CalendarDay> eventDays = new ArrayList<>();
                        for (DocumentSnapshot conc: task.getResult().getDocuments()) {
                            eventDays.add(CalendarDay.from(2023, Integer.valueOf(conc.getLong("startMonth").intValue()), Integer.valueOf(conc.getLong("startDay").intValue())));
                            int startHour,startMinute,endHour,endMinute;
                            if ((Integer.valueOf(conc.getLong("startHalfHour").intValue()) % 2) == 0) {
                                startHour = Integer.valueOf(conc.getLong("startHalfHour").intValue())/2;
                                startMinute = 0;
                            } else {
                                startHour = Integer.valueOf(conc.getLong("startHalfHour").intValue())/2;
                                startMinute = 30;
                            }

                            if ((Integer.valueOf(conc.getLong("endHalfHour").intValue()) % 2) == 0) {
                                endHour = Integer.valueOf(conc.getLong("endHalfHour").intValue())/2;
                                endMinute = 0;
                            } else {
                                endHour = Integer.valueOf(conc.getLong("endHalfHour").intValue())/2;
                                endMinute = 30;
                            }
                            User owner = new User();
                            owner.setEmail(conc.getString("owner"));
                            ArrayList<User> users = new ArrayList<>();
                            for (String obj: (ArrayList<String>)conc.get("users")) {
                                User user = new User();
                                user.setEmail(obj);
                                users.add(user);
                            }

                            allEvents.add(new ConcreteEvent(LocalDateTime.of(2023, conc.getLong("startMonth").intValue(), conc.getLong("startDay").intValue(),
                                    startHour,startMinute),LocalDateTime.of(2023, Integer.valueOf(conc.getLong("endMonth").intValue()), Integer.valueOf(conc.getLong("endDay").intValue()),
                                    endHour,endMinute),owner,users));
                            recyclerAdapter.notifyDataSetChanged();
                        }
                        EventDecorator eventHighlighter = new EventDecorator(Color.RED, eventDays, getContext());
                        calendarView.addDecorator(eventHighlighter);
                    }
                });
        db.getPotentialEventsCollectionRef().whereArrayContains("users",
                FirebaseAuth.getInstance().getCurrentUser().getEmail()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    }
                });
//                .document(FirebaseAuth.getInstance().getCurrentUser().getEmail()).get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        ArrayList<String> eventsList =  (ArrayList<String>)task.getResult().get("ConcreteEvents");
//                        for (String event: eventsList) {
//                            db.getConcreteEventsCollectionRef().document(event).collection("months").get()
//                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                            for (DocumentSnapshot month: task.getResult().getDocuments()) {
//                                                month.getReference().collection("days").get()
//                                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                                            @Override
//                                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                                List<CalendarDay> eventDays = new ArrayList<>();
//                                                                for (DocumentSnapshot day: task.getResult().getDocuments()){
//
//                                                                    eventDays.add(CalendarDay.from(2023, Integer.valueOf(month.getId()), Integer.valueOf(month.getId())));
//                                                                }
//                                                                EventDecorator eventHighlighter = new EventDecorator(Color.RED, eventDays, getContext());
//                                                                calendarView.addDecorator(eventHighlighter);
//                                                            }
//                                                        });
//                                            }
//                                        }
//                                    });
//                        }
//                    }
//                });

//        LocalDateTime time = LocalDateTime.of(2023, 1, 18, 1, 1);
//        LocalDateTime time1 = LocalDateTime.of(2023, 2, 11, 1, 1);

//        CalendarDay a = CalendarDay.from(time.getYear(), time.getMonthValue(), time.getDayOfMonth());
//        CalendarDay b = CalendarDay.from(time1.getYear(), time1.getMonthValue(), time1.getDayOfMonth());
//
//        eventDays.add(a);
//        eventDays.add(b);



//        Event MarcosDinner = new ConcreteEvent(time, time, new User(), new ArrayList<User>());
//        Event SehbazzDinner = new ConcreteEvent(time1, time1, new User(), new ArrayList<User>());



//        allEvents.add(MarcosDinner);
//        allEvents.add(SehbazzDinner);


        eventRecyclerView.setHasFixedSize(false);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }

    public MainEventFragment() {
        super(R.layout.home_fragment);


        //calendarView = (MaterialCalendarView) this.getView().findViewById(R.id.calendarView);



//        List<CalendarDay> eventDays = new ArrayList<>();
//
//        CalendarDay a = CalendarDay.from(2023, 01, 8);
//        CalendarDay b = CalendarDay.from(2023, 01, 10);
//        CalendarDay c = CalendarDay.from(2023, 01, 23);
//
//        eventDays.add(a);
//        eventDays.add(b);
//        eventDays.add(c);
//
//        EventDecorator eventHighlighter = new EventDecorator(Color.RED, eventDays, getContext());
//        calendarView.addDecorator(eventHighlighter);

    }


    @Override
    public void onItemClick(View view, int position) {
        //TODO: Item stub for click event.
    }
}
