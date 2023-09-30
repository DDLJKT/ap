package com.example.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {
    EditText e;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        e=findViewById(R.id.get_rollno);
        btn=findViewById(R.id.btn);

        DatabaseHandler db=new DatabaseHandler(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean i=db.deleteDetails(e.getText().toString().trim());
                if (i==true){
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}