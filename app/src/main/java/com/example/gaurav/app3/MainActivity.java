package com.example.gaurav.app3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button loginbtn,registerbtn;
    DatabaseSqlite db;
    EditText username,password;
    TextView id1;
    public static  final String EXTRA_TEXT = "com.example.gaurav.sqlproject.EXTRA_TEXT";
    public static  final String EXTRA_TEXT2 = "com.example.gaurav.sqlproject.EXTRA_TEXT2";
    public static  final String EXTRA_ID = "com.example.gaurav.sqlproject.EXTRA_ID";

    @Override
    public void onBackPressed() {


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseSqlite(MainActivity.this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        id1 = findViewById(R.id.idText);

        loginbtn = findViewById(R.id.loginBtn);
        registerbtn = findViewById(R.id.registerBtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> users = db.getAllUSers();
                int lengthuser = users.size();
                int i = 0;

                for (User eachUser : users) {
                    i++;

                    String uname = username.getText().toString();
                    String pass = password.getText().toString();
                    if (uname.isEmpty() == false && pass.isEmpty()== false)
                    {
                        if (eachUser.getName().equals(uname) &&
                                eachUser.getPassword().equals(pass)) {
                            String st = String.valueOf(eachUser.getId());
                            Intent intent = new Intent(MainActivity.this,Home.class);
                            intent.putExtra(EXTRA_TEXT,uname);
                            intent.putExtra(EXTRA_TEXT2,pass);
                            intent.putExtra(EXTRA_ID,st);
                            System.out.println("Id = "+st);


                            startActivity(intent);
                            return;
                        }
                        else
                        {
                            if (i == lengthuser)
                            {
                                validationAlert("lOGIN UNSUCCESSFULL");
                                return;
                            }
                            continue;


                        }

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Enter username and Password",Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(loginIntent);
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