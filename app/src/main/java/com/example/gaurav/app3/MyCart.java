package com.example.gaurav.app3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {
    DatabaseSqlite db;
    Button removebtn;

    private static final String TAG = "CartActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onRestart() {
        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        db = new DatabaseSqlite(MyCart.this);
        initImageBitmaps();



    }


        private void initImageBitmaps(){
            Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

            mImageUrls.add("A");
            mNames.add("B");
            mImageUrls.add("A");
            mNames.add("B");            mImageUrls.add("A");
            mNames.add("B");            mImageUrls.add("A");
            mNames.add("B");            mImageUrls.add("A");
            mNames.add("B");            mImageUrls.add("A");
            mNames.add("B");            mImageUrls.add("A");
            mNames.add("B");


            initRecyclerView();
        }



    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapterCart adapter = new RecyclerViewAdapterCart(this, mNames, mImageUrls,1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void validationAlert(String message) {
        android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(this);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Agree",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        android.app.AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}


