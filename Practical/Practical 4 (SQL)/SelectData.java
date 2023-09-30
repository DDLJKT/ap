package com.example.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SelectData extends AppCompatActivity {
    EditText e;
    Button btn;
    TextView d;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);

        e=findViewById(R.id.rollno);
        btn=findViewById(R.id.btn);
        d=findViewById(R.id.displaydata);
        DatabaseHandler db=new DatabaseHandler(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Details details=db.selectData(e.getText().toString());
                String result="RollNo: "+details.getRollno()+"Name: "+details.getName()+
                        "Age: "+details.getAge();
                d.setText(result);
            }
        });
    }
}