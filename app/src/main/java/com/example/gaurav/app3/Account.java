package com.example.gaurav.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends AppCompatActivity {

    EditText name,password;
    Button updatebtn,deletebtn;
    TextView id1;
    DatabaseSqlite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Intent intent = getIntent();
        final String uname = intent.getStringExtra(Home.EXTRA_TEXT);
        final String pass = intent.getStringExtra(Home.EXTRA_TEXT2);
        final String iddb = intent.getStringExtra(Home.EXTRA_ID);

        System.out.println("Logged In Id = "+iddb);

        name = findViewById(R.id.nameText);
        password = findViewById(R.id.passText);
        id1 = findViewById(R.id.idText);
        updatebtn = findViewById(R.id.updateBtn);
        deletebtn = findViewById(R.id.deleteBtn);
        db = new DatabaseSqlite(Account.this);

        name.setText(uname);
        password.setText(pass);
        id1.setText(iddb);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() == false && password.getText().toString().isEmpty() == false)
                {
                    boolean isUpdate = db.updateAccount(iddb,name.getText().toString(),password.getText().toString());
                    if(isUpdate == true)
                    {
                        Toast.makeText(getApplicationContext(),"Update Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Update Unsuccessful", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext()," Name or Password is Empty ", Toast.LENGTH_SHORT).show();

                }


            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isdelete = db.deleteAccount(id1.getText().toString());
                if(isdelete > 0)
                {
                    Toast.makeText(getApplicationContext(),"Delete Succesful", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Account.this,MainActivity.class);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Delete Unsuccesful", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
