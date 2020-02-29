package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave;

    EditText txtList, txtContent;
    int listNumber = 0;
    TagMapModel map = new TagMapModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = findViewById(R.id.txtContent);
        txtList = findViewById(R.id.txtList);


        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listNumber++;

                NoteModel note = new NoteModel();
                note.list = txtList.getText().toString();
                note.content = note.list;

                //map.add(note.content); // update tags!

                SharedPreferences pref = getPreferences(0);
                SharedPreferences.Editor editor = pref.edit();

                String json = note.toJson();
                Log.i("note.json", json);

                note.fromJson(json);

                editor.putString(note.content, json);

                //json = map.toJson();
                //Log.i("map.json", json);
                //editor.putString("tagmap", json);

                editor.commit();


                txtContent.setText(txtContent.getText().toString() + "\n" + listNumber + "." + note.content);

            }
        });

    }

}
