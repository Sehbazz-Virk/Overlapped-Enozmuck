package com.example.overlapped;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

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


    public void addEventTest(UUID ownerID) {

        Map<String, Object> eventDetails = new HashMap<>();
        Map<String, Map> month = new HashMap<>();
        Map<String, Map> dayMap = new HashMap<>();
        Map<String, Map> hourMap = new HashMap<>();
        Map<String, Integer> availMap = new HashMap<>();


        month.put("2", dayMap);

        dayMap.put("27", hourMap);

        hourMap.put("39", availMap);

        availMap.put("user1", 3);

        eventDetails.put("months", month);
        //events.document("wowow").set(eventDetails, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
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