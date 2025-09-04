package com.example.repairorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {
//xml is the UI frontend , java is the logic backend

    double numbers = 0.00;
    Button submitB;

    TextView subtotalTV;

    EditText laborET;
    EditText paintET;

    //creating anonymous listener for submitB button - creates onClick method
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random gen = new Random();
            double number = gen.nextDouble();
            String v1 = "$" + number;
            subtotalTV.setText(v1);

            String laborTypeValue = laborET.getText().toString();
            String paintTypeValue = paintET.getText().toString();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView totalTV = findViewById(R.id.totalNum);
        subtotalTV = findViewById(R.id.subtotalNum);
        submitB = findViewById(R.id.button); //has to be after the onCreate
        submitB.setOnClickListener(buttonListener); //tie button listener to button
        laborET = findViewById(R.id.laborInput);
        paintET = findViewById(R.id.PaintInput);

        // given the name of variable and the type and suffix (tv for text view - ET for edit text
        totalTV.setText(R.string.subtotalnum);
        //setting text
        CharSequence cs = totalTV.getText(); //gives u a char sequence
        String ex= cs.toString(); // or put all in one below
        String value= totalTV.getText().toString();


        Random gen = new Random();
        double number = gen.nextDouble();
        String v1 = "$" + number;
        subtotalTV.setText(v1);

        Log.i("TEXT", value);
    }
}