package com.example.sqldatabasecustomisedlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class List_Adapter extends ArrayAdapter<StudentModel> {

    Context cxt;
    public List_Adapter(@NonNull Context context, ArrayList<StudentModel> arrayList) {
        super(context,0, arrayList);
        cxt=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StudentModel sm=getItem(position);
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_list_adapter,parent,false);

        TextView name=convertView.findViewById(R.id.name);
        TextView rollno=convertView.findViewById(R.id.rollno);
        TextView enroll=convertView.findViewById(R.id.enroll);
        Button del=convertView.findViewById(R.id.button);
        Button update=convertView.findViewById(R.id.update);
        update.setVisibility(View.GONE);
        Button pointer=convertView.findViewById(R.id.pointer);

        name.setText(sm.getName());
        rollno.setText(Integer.toString(sm.getRollNmber()));
        enroll.setText(Boolean.toString(sm.isEnroll()));

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // MainActivity.editName= (String) name.getText();
               // name.setText("nabiha");
                DBHelper dbHelper  = new DBHelper(getContext());
                dbHelper.deleteStudent(Integer.toString(sm.getRollNmber()));

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtname =  ((Activity)cxt).findViewById(R.id.editTextName);
                EditText txtrollno =  ((Activity)cxt).findViewById(R.id.editTextRollNumber);
                Switch isenroll =  ((Activity)cxt).findViewById(R.id.switchStudent);
                StudentModel student=new StudentModel(txtname.getText().toString(),Integer.parseInt(txtrollno.getText().toString()),isenroll.isChecked());

                DBHelper dbHelper  = new DBHelper(getContext());
                dbHelper.updateStudent(student,Integer.toString(sm.getRollNmber()));

                txtname.setText("");
                txtrollno.setText("");
                isenroll.setChecked(false);
            }
        });
        pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtname =  ((Activity)cxt).findViewById(R.id.editTextName);
                EditText txtrollno =  ((Activity)cxt).findViewById(R.id.editTextRollNumber);
                Switch isenroll =  ((Activity)cxt).findViewById(R.id.switchStudent);
                txtname.setText(sm.getName());
                txtrollno.setText(Integer.toString(sm.getRollNmber()));
                isenroll.setChecked(sm.isEnroll());
                update.setVisibility(View.VISIBLE);
            }
        });
        return convertView;

    }
}
