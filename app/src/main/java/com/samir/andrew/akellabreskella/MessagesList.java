package com.samir.andrew.akellabreskella;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samir.andrew.akellabreskella.adapters.MessagesAdapter;
import com.samir.andrew.akellabreskella.models.NotificationModel;

import java.util.ArrayList;

public class MessagesList extends AppCompatActivity {

    ArrayList<NotificationModel> notificationModelArrayList;

    MessagesAdapter messagesAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.lvMessagesFragment);
        getNotificationData();


    }

    private void getNotificationData() {

        notificationModelArrayList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Messages/");
        myRef.keepSynced(true);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
                notificationModelArrayList = new ArrayList<>();

                Iterable<DataSnapshot> myChildren = dataSnapshot.getChildren();

                while (myChildren.iterator().hasNext()) {

                    DataSnapshot myChild = myChildren.iterator().next();

                    notificationModelArrayList.add(new NotificationModel(myChild.child("text").getValue().toString(),

                            myChild.child("time").getValue().toString()));
                }

                messagesAdapter = new MessagesAdapter(MessagesList.this, R.layout.item_notification_message, notificationModelArrayList);
                listView.setAdapter(messagesAdapter);
                listView.setSelection(listView.getAdapter().getCount() - 1);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.d("error", error.toString());
                // Failed to read value
            }
        });
    }


}
