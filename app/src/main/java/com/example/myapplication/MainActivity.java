package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> store = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText;
        editText = findViewById(R.id.edittext_chatbox);


        Button sendButton;
        sendButton = findViewById(R.id.button_chatbox_send);

        store.add("Hello");
        store.add("Msg Received");


        final RecyclerView ListMessage = (RecyclerView) findViewById(R.id.ListMessage);

        ListMessage.setLayoutManager(new LinearLayoutManager(this));


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = (String) editText.getText().toString();
                Date currentTime = Calendar.getInstance().getTime();


                editText.setText("");
                store.add(st);
                store.add("Msg Received");
                ListMessage.scrollToPosition(store.size() - 1);
                editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

            }
        });

        ListMessage.setAdapter(new MessageAdapter(store));


    }
}