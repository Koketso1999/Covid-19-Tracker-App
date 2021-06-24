package com.example.mk17000504;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    RegistrationDatabase registrationdatabase;
    EditText et_firstname, et_lastname, et_contact, et_dateVisit, et_temparature;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registrationdatabase = new RegistrationDatabase(this);
        et_firstname = (EditText)findViewById(R.id.et_firstname);
        et_lastname = (EditText)findViewById(R.id.et_lastname);
        et_contact = (EditText)findViewById(R.id.et_visitor_contact);
        et_dateVisit = (EditText)findViewById(R.id.et_dateVisit);
        et_temparature = (EditText)findViewById(R.id.et_temparature);

        btn_add = (Button)findViewById(R.id.btn_add);

        AddData();
    }

    public void AddData(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hasInserted =  registrationdatabase.InsertData(et_firstname.getText().toString(), et_lastname.getText().toString(), et_contact.getText().toString(),
                        et_dateVisit.getText().toString(), et_temparature.getText().toString());

                if (hasInserted == true){
                    Toast.makeText(Registration.this, "Successfully Inserted Data", Toast.LENGTH_SHORT).show();
                    et_firstname.setText("");
                    et_lastname.setText("");
                    et_contact.setText("");
                    et_dateVisit.setText("");
                    et_temparature.setText("");

                }
            }
        });
    }
}
