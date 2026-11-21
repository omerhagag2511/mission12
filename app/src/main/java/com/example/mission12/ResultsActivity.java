package com.example.mission12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {
    TextView redScore, blueScore, winner;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        redScore = (TextView) findViewById(R.id.redScore);
        blueScore = (TextView) findViewById(R.id.blueScore);
        winner = (TextView) findViewById(R.id.winner);
        back = (Button) findViewById(R.id.back);

        int red_score = getIntent().getIntExtra("red_extra", 0);
        int blue_score = getIntent().getIntExtra("blue_extra", 0);

        redScore.setText("red's score: " + red_score);
        blueScore.setText("blue's score: " + blue_score);

        if (red_score > blue_score) {
            winner.setText("the winner is red!");
        } else if (blue_score > red_score) {
            winner.setText("the winner is blue!");
        } else {
            winner.setText("its a tie!");
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
