package com.example.overlapped;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static android.content.ContentValues.TAG;

public class Database {
    private static Database db_ = null;

    private FirebaseFirestore db;
    private CollectionReference potentialEvents;
    private CollectionReference concreteEvents;
    private CollectionReference users;

    public Database() {
        db = FirebaseFirestore.getInstance();
        potentialEvents = db.collection("PotentialEvents");
        concreteEvents = db.collection("ConcreteEvents");
        users = db.collection("Users");

    }

    public static Database getInstance() {
        if (db_ == null) {
            db_ = new Database();
        }
        return db_;
    }

    public FirebaseFirestore getFirebaseFirestoreRef(){
        return db;
    }

    public CollectionReference getUsersCollectionRef() {
        return users;
    }

    public CollectionReference getPotentialEventsCollectionRef() {
        return potentialEvents;
    }

    public CollectionReference getConcreteEventsCollectionRef() {
        return concreteEvents;
    }

    public void registerNewUser(String email) {
        Map<String, List> userEvents = new HashMap<>();
        userEvents.put("events",new ArrayList());
        users.document(email).set(userEvents);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addConcreteEvent(ConcreteEvent concreteEvent) {
        Map<String, Object> eventDetails = new HashMap<>();
        eventDetails.put("owner", concreteEvent.getOwner().getEmail());
        eventDetails.put("users", concreteEvent.getUsersEmails());
        eventDetails.put("startMonth", concreteEvent.getStartTime().getMonthValue());
        eventDetails.put("startDay", concreteEvent.getStartTime().getDayOfMonth());
        eventDetails.put("startHalfHour", (Double.valueOf((double)concreteEvent.getStartTime().getHour())+(Double.valueOf((double)concreteEvent.getStartTime().getMinute()/60.0)))*2);
        eventDetails.put("endMonth", concreteEvent.getEndTime().getMonthValue());
        eventDetails.put("endDay", concreteEvent.getEndTime().getDayOfMonth());
        eventDetails.put("endHalfHour", (Double.valueOf((double)concreteEvent.getEndTime().getHour())+(Double.valueOf((double)concreteEvent.getEndTime().getMinute()/60.0)))*2);
        concreteEvent.setId(UUID.randomUUID().toString());
        concreteEvents.document(concreteEvent.getId()).set(eventDetails);
//        Map<String, Object> eventDetails = new HashMap<>();
//        Map<String, Map> month = new HashMap<>();
//        Map<String, Map> dayMap = new HashMap<>();
//        Map<String, Map> hourMap = new HashMap<>();
//        Map<String, Integer> availMap = new HashMap<>();
//
//
//        month.put("2", dayMap);
//
//        dayMap.put("27", hourMap);
//
//        hourMap.put("39", availMap);
//
//        availMap.put("user1", 3);
//
//        eventDetails.put("months", month);
        //events.document("wowow").set(eventDetails, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
    }

//    public void getEventFields(String eventID){
//        events.document(eventID).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
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
//    }

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


//    public void getEventTest() {
//        events.document("test").collection("months").document("0")
//                .collection("days").document("23").collection("halfhours")
//                .document("32").collection("users").whereEqualTo("rank",2).get()
////                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
////                    @Override
////                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
////                        Log.d("wow","yay");
////                    }
////                });
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        task.getResult().getDocuments().get(0);
//                    }
//                });}
//        db.collectionGroup("months").whereEqualTo("balls","hello").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        Log.d("wow","yay");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d("ass", "cheeks");
//                    }
//                });



}