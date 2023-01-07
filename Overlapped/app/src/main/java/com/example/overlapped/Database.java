package com.example.overlapped;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
    private static Database db_ = null;

    private FirebaseFirestore db;
    private CollectionReference events;

    private Database() {
        db = FirebaseFirestore.getInstance();
        events = db.collection("eventsTester");

    }

    public static Database getInstance() {
        if (db_ == null) {
            db_ = new Database();
        }
        return db_;
    }

    public void addEventTest(UUID ownerID) {

        Map<String, Object> eventDetails = new HashMap<>();
        eventDetails.put("owner", ownerID.toString());
        events.document(UUID.randomUUID().toString()).set(eventDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d("wow", "yay");
                } else {
                    Log.d("balls","balls");
                }
            }
        });
        //events.add(eventDetails);
    }

    public void addEventTest(UUID ownerID) {

        Map<String, Object> eventDetails = new HashMap<>();
        Map<string, Map> month;

        Map<string, Map> map;

        month.put("2", map);
        eventDetails.put("months", month);
        events.document(UUID.randomUUID().toString()).set(eventDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d("wow", "yay");
                } else {
                    Log.d("balls","balls");
                }
            }
        });
        //events.add(eventDetails);
    }

}
