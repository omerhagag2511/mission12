package com.example.mission12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{
    int red1 = 0;
    int blue1 = 0;
    Button blue;
    Button red;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blue =(Button)findViewById(R.id.blue);
        red = (Button)findViewById(R.id.red);
        red.setOnLongClickListener(this);
        blue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                blue1 ++;
            }
        });
    }
    public void go(View view){
        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
        intent.putExtra("blue_extra", blue1);
        intent.putExtra("red_extra", red1);
        startActivity(intent);
    }
    @Override
    public boolean onLongClick(View v) {
        red1 += 2;
        return true;
    }

}