package com.example.app;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
public class Chatbot_repoMainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    TextView welcomeTextView;
    EditText messageEditText;
    ImageButton sendButton;
    List<Message_repo> messageList;
    MessageAdapter_repo messageAdapterRepo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot_repolayout);
        messageList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        welcomeTextView = findViewById(R.id.welcome_text);
        messageEditText = findViewById(R.id.message_edit_text);
        sendButton = findViewById(R.id.send_btn);

        //setup recycler view
        messageAdapterRepo = new MessageAdapter_repo(messageList);
        recyclerView.setAdapter(messageAdapterRepo);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        sendButton.setOnClickListener((v)->{
            String question = messageEditText.getText().toString().trim();
            addToChat(question,Message_repo.SENT_BY_ME);
            messageEditText.setText("");
            welcomeTextView.setVisibility(View.GONE);
        });
    }

    void addToChat(String message, String sentBy) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message_repo(message, sentBy));
                messageAdapterRepo.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapterRepo.getItemCount());
                botreply(message, Message_repo.SENT_BY_BOT);
            }
        });
    }

    void botreply(String message, String sentBy) {
        String bot_response = " ";

        if (message.contains("drought resistant corn")) {
            bot_response = "Researchers are exploring several strategies for drought resistance in corn. " +
                    "Some varieties have deeper root systems to access more water from the soil. " +
                    "Others have genes that allow them to tolerate drier conditions by closing their stomata (leaf pores) to reduce water loss." +
                    " Additionally, scientists are investigating genes that regulate stress response and osmoprotectant production, " +
                    "molecules that help plants maintain cell function during drought.";
            messageList.add(new Message_repo(bot_response, sentBy));

            String[] stringArray = new String[]{"traditional methods", "improve corn and rice"};
        } else if (message.contains("traditional methods")) {
            bot_response = "Traditional breeding is a time-tested method that involves selecting plants with desirable traits, " +
                    "like high yield or disease resistance, and crossing them to create new generations with those traits. " +
                    "This method has been used for centuries and is still a valuable tool for crop improvement.";
            messageList.add(new Message_repo(bot_response, sentBy));
        } else {
            Toast.makeText(this, "Input Something", Toast.LENGTH_SHORT).show();
        }


        messageAdapterRepo.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(messageAdapterRepo.getItemCount());
    }
}


