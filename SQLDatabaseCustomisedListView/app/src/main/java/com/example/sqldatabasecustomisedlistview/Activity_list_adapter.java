package com.example.sqldatabasecustomisedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_list_adapter extends AppCompatActivity {
    TextView name;
    TextView rollno;
    EditText name_ed;
    Button del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter);

        del=findViewById(R.id.button);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=findViewById(R.id.name);
                rollno=findViewById(R.id.rollno);
                MainActivity.sStatus= (String) name.getText();
                name.setText("nabiha");
            }
        });
    }

    /*public void delete(View view) {
        name=findViewById(R.id.name);
        rollno=findViewById(R.id.rollno);
        MainActivity.sStatus= (String) name.getText();
    }*/

}