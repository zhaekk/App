package com.example.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {


    private CardView cardView;

    private CardView recoCardView;
    private CardView analyticsCardView;
    private CardView pestCardView;
    private CardView hvCardView;
    private CardView tutorialCardView;
    private CardView chatbotCardView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        cardView = rootView.findViewById(R.id.cvcalendar);
        recoCardView = rootView.findViewById(R.id.card1);
        analyticsCardView = rootView.findViewById(R.id.card2);
        pestCardView = rootView.findViewById(R.id.card3);
        hvCardView = rootView.findViewById(R.id.card4);
        tutorialCardView = rootView.findViewById(R.id.card5);
        chatbotCardView = rootView.findViewById(R.id.card6);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to navigate to the next activity
                Intent intent = new Intent(getActivity(), Calendarclass.class);
                startActivity(intent);
            }
        });
        recoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecoMainActivity.class);
                startActivity(intent);
            }
        });
        analyticsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnalyticMainActivity.class);
                startActivity(intent);
            }
        });
        pestCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PestMainActivity.class);
                startActivity(intent);
            }
        });
        hvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HarvestVolMainActivity.class);
                startActivity(intent);
            }
        });
        tutorialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TutorialMainActivity.class);
                startActivity(intent);
            }
        });
        chatbotCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Chatbot_repoMainActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}