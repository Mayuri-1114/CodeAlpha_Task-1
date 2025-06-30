package com.example.flashcardquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] questions = {"What is the capital of India?", "What is 2 + 2?", "What is the color of the sky?"};
    String[] answers = {"New Delhi", "4", "Blue"};
    int currentIndex = 0;
    boolean isAnswerVisible = false;

    TextView flashcardText;
    Button showAnswerButton, nextButton, previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardText = findViewById(R.id.flashcardText);
        showAnswerButton = findViewById(R.id.showAnswerButton);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);

        flashcardText.setText(questions[currentIndex]);

        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnswerVisible) {
                    flashcardText.setText(answers[currentIndex]);
                    isAnswerVisible = true;
                    showAnswerButton.setText("Show Question");
                } else {
                    flashcardText.setText(questions[currentIndex]);
                    isAnswerVisible = false;
                    showAnswerButton.setText("Show Answer");
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questions.length;
                flashcardText.setText(questions[currentIndex]);
                isAnswerVisible = false;
                showAnswerButton.setText("Show Answer");
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex - 1 + questions.length) % questions.length;
                flashcardText.setText(questions[currentIndex]);
                isAnswerVisible = false;
                showAnswerButton.setText("Show Answer");
            }
        });
    }
}