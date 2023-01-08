package com.example.overlapped;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
    private static Database db_ = null;

    private FirebaseFirestore db;
    private CollectionReference events;

    private Database() {
        db = FirebaseFirestore.getInstance();
        events = db.collection("Events");

    }

    public static Database getInstance() {
        if (db_ == null) {
            db_ = new Database();
        }
        return db_;
    }

    public void addEventTest1(UUID ownerID) {

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
        Map<String, Map> month = new HashMap<>();
        Map<String, Map> dayMap = new HashMap<>();
        Map<String, Map> hourMap = new HashMap<>();
        Map<String, Integer> availMap = new HashMap<>();


        month.put("2", dayMap);

        dayMap.put("27",hourMap);

        hourMap.put("39",availMap);

        availMap.put("user1", 3);

        eventDetails.put("months", month);
        events.document("wowow").set(eventDetails, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
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

    public void getEventTest() {
//        events.document("test").collection("months").document("0")
//                .collection("days").document("23").collection("halfhours")
//                .document("32").collection("users").whereEqualTo("rank",2).get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        Log.d("wow","yay");
//                    }
//                });
        db.collectionGroup("months").whereEqualTo("balls","hello").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.d("wow","yay");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ass", "cheeks");
                    }
                });

    }

}
