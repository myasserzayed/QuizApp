package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton mQuest1_RB1;
    private RadioButton mQuest1_RB2;
    private CheckBox mQuest2_CB1;
    private CheckBox mQuest2_CB2;
    private CheckBox mQuest2_CB3;
    private EditText mQuest3_Ans;
    private RadioButton mQuest4_RB1;
    private RadioButton mQuest4_RB2;
    private Button mSubmitBtn;
    private double scoreCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionsCheck();
        scoreContainer(scoreCounter);
    }

    private void scoreContainer(double scoreCounter) {
        TextView scoreContainer = findViewById(R.id.display);
        scoreContainer.setText(scoreCounter + " /4.0");
    }

    private void questionsCheck() {
        mQuest1_RB1 = findViewById(R.id.question1_RB1);
        mQuest1_RB2 = findViewById(R.id.question1_RB2);
        mQuest2_CB1 = findViewById(R.id.question2_CB1);
        mQuest2_CB2 = findViewById(R.id.question2_CB2);
        mQuest2_CB3 = findViewById(R.id.question2_CB3);
        mQuest3_Ans = findViewById(R.id.question3_Ans);
        mQuest4_RB1 = findViewById(R.id.question4_RB1);
        mQuest4_RB2 = findViewById(R.id.question4_RB2);
        mSubmitBtn = findViewById(R.id.submit_btn);
        mSubmitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mQuest1_RB2.isChecked()) {
            scoreCounter++;
        }

        if (mQuest2_CB1.isChecked() && mQuest2_CB2.isChecked() && !mQuest2_CB3.isChecked()) {
            scoreCounter++;
        }

        if (mQuest3_Ans.getText().toString().equalsIgnoreCase("lima")) {
            scoreCounter++;
        }

        if (mQuest4_RB2.isChecked()) {
            scoreCounter++;
        }

        scoreContainer(scoreCounter);

        if (scoreCounter == 0) {
            Toast.makeText(MainActivity.this, "You scored " + scoreCounter + " Try again!", Toast.LENGTH_LONG).show();
        } else if (scoreCounter >= 1 && scoreCounter < 4) {
            Toast.makeText(MainActivity.this, "Your score is " + scoreCounter + " /4.0", Toast.LENGTH_LONG).show();
        } else if (scoreCounter == 4) {
            Toast.makeText(MainActivity.this, "They are all right!" + "\n" + "Your score is " + scoreCounter + " /4.0", Toast.LENGTH_LONG).show();
        }

        scoreCounter = 0;
    }
}