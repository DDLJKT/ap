package com.example.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {

    EditText rollno,name,age,phonenumber,email,address;
    String rn,n,a,ph,e,g="",ad;
    RadioButton male,female,other;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        name=findViewById(R.id.get_name);
        age=findViewById(R.id.get_age);
        address=findViewById(R.id.get_address);
        phonenumber=findViewById(R.id.get_phone_number);
        email=findViewById(R.id.get_email);
        rollno=findViewById(R.id.get_roll_no);
        btn=findViewById(R.id.btn);
        male=findViewById(R.id.get_male);
        female=findViewById(R.id.get_female);
        other=findViewById(R.id.get_other);

        DatabaseHandler databaseHandler=new DatabaseHandler(this);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rn=rollno.getText().toString().trim();
                n=name.getText().toString().trim();
                a=age.getText().toString().trim();
                ph=phonenumber.getText().toString().trim();
                e=email.getText().toString().trim();
                ad=address.getText().toString().trim();

                if (male.isChecked()){
                    g="Male";
                }
                if (female.isChecked()){
                    g="Female";
                }
                if (other.isChecked()){
                    g="Other";
                }


                if (rn.isEmpty() || n.isEmpty() || a.isEmpty() || ph.isEmpty() || e.isEmpty() || ad.isEmpty() ||g.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Fill The Details", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean i=databaseHandler.updateDetail(rn,n,a,ph,e,ad,g);

                    if (i==true){
                        Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Failed To Insert", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}