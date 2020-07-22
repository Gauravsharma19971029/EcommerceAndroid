package com.example.gaurav.app3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    Button signup,login;

    EditText name,password,phone,address;

    DatabaseSqlite db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signup= findViewById(R.id.signup);
        login= findViewById(R.id.login);
        name= findViewById(R.id.name);
        password= findViewById(R.id.password);
        phone= findViewById(R.id.phone);
        address= findViewById(R.id.address);

        db = new DatabaseSqlite(RegisterActivity.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(loginIntent);

             /*   List<User> users = db.getAllUSers();
                validationAlert("Enter Username");

                for(User eachUser :users){

                    if(eachUser.getName().equals("Veerendra") &&
                            eachUser.getPassword().equals("12345")){
                        validationAlert("lOGIN SUCCESSFULLY");    */
            }

        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uName = name.getText().toString();
                String PassWd = password.getText().toString();
                String mobile = phone.getText().toString();
                String adrss = address.getText().toString();

                if(TextUtils.isEmpty(uName)){
                    validationAlert("Enter Username");
                }else if(TextUtils.isEmpty(PassWd)){
                    validationAlert("Enter Password");
                }else if(TextUtils.isEmpty(mobile)){
                    validationAlert("Enter Mobile");
                }else if(TextUtils.isEmpty(adrss)){
                    validationAlert("Enter Address");
                }else {

                    User sjbitUser = new User();
                    sjbitUser.setName(uName);
                    sjbitUser.setPassword(PassWd);
                    sjbitUser.setMobile_no(mobile);
                    sjbitUser.setAddress(adrss);

                    long rowNum = db.insertUser(sjbitUser);
                    if(rowNum > 0) {
                        validationAlert("Successfully Inserted");
                    }else {
                        validationAlert("Database Error");
                    }
                }
            }
        });
    }

    public void validationAlert(String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Agree",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
