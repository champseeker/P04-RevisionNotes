package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStar;
    Button btnInsert, btnShow;
    RadioButton rbSelected;

    String note;
    int star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = findViewById(R.id.editTextNote);
        rgStar = findViewById(R.id.radioGroupStars);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                note = etNote.getText().toString();
                int selectedRB = rgStar.getCheckedRadioButtonId();
                rbSelected = (RadioButton) findViewById(selectedRB);
                star = Integer.parseInt(rbSelected.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);

                db.insertNote(note, star);

                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                db.close();

                etNote.setText("");

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(intent);

            }
        });

    }
}
