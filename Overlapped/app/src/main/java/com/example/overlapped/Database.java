package com.example.overlapped;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static android.content.ContentValues.TAG;

public class Database {
    private static Database db_ = null;

    private FirebaseFirestore db;
    private CollectionReference events;

    public Database() {
        db = FirebaseFirestore.getInstance();
        events = db.collection("Events");

    }

    public static Database getInstance() {
        if (db_ == null) {
            db_ = new Database();
        }
        return db_;
    }

    public void getEventFields(String eventID){
        events.document(eventID).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "AWWW, No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

//    public List<DocumentSnapshot> getEventMonths(String eventID){
//
//        final List<DocumentSnapshot> documents; //TODO: THIS MAY NOT BE ASSIGNED
//
//        events.document(eventID).collection("months").add
//
//                .get().add
//
//                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    documents = task.getResult().getDocuments();
//                }
//            }
//        }
//    }
//            @Override
//            public void onComplete(@NonNull Task<> task) {
//                if (task.isSuccessful()) {
//                    Object document = task.getResult();
//                    if (document.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                    } else {
//                        Log.d(TAG, "AWWW, No such document");
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });


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

//    public void addEventTest(UUID ownerID) {
//
//        Map<String, Object> eventDetails = new HashMap<>();
//        Map<string, Map> month;
//
//        Map<string, Map> map;
//
//        month.put("2", map);
//        eventDetails.put("months", month);
//        events.document(UUID.randomUUID().toString()).set(eventDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Log.d("wow", "yay");
//                } else {
//                    Log.d("balls","balls");
//                }
//            }
//        });
//        //events.add(eventDetails);
//    }

}
