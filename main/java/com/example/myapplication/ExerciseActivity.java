package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercise);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ImageView gifImageView1 = findViewById(R.id.gifImageView1);
        ImageView gifImageView2 = findViewById(R.id.gifImageView2);
        ImageView gifImageView3 = findViewById(R.id.gifImageView3);
        ImageView gifImageView4 = findViewById(R.id.gifImageView4);
        ImageView gifImageView5 = findViewById(R.id.gifImageView5);
        ImageView gifImageView6 = findViewById(R.id.gifImageView6);

        gifImageView1.setImageResource(R.drawable.gif1);
        gifImageView2.setImageResource(R.drawable.gif2);
        gifImageView3.setImageResource(R.drawable.gif3);
        gifImageView4.setImageResource(R.drawable.gif4);
        gifImageView5.setImageResource(R.drawable.gif5);
        gifImageView6.setImageResource(R.drawable.gif6);



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}