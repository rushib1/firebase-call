package io.example.flutter_plugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChildEventListener extends Service {
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    //Adding a childevent listener to firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    myRef.addValueEventListener(new ValueEventListener() {

      @Override
      public void onDataChange(DataSnapshot snapshot) {
        return;
        //Do something using DataSnapshot say call Notification
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {
        return;
      }

    });
    return Service.START_STICKY;
  }

}
