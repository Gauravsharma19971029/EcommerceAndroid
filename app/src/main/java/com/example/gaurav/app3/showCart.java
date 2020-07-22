package com.example.gaurav.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gaurav.app3.R;
import com.example.gaurav.app3.R;

import java.util.ArrayList;
import java.util.List;

public class showCart extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static  final String EXTRA_TEXT = "com.example.gaurav.app3.EXTRA_TEXT";
    public static  final String EXTRA_TEXT2 = "com.example.gaurav.app3.EXTRA_TEXT2";
    public static  final String EXTRA_ID = "com.example.gaurav.app3.EXTRA_ID";
    String uname,pass,iddb;
    DatabaseSqlite db;

    //vars
    private ArrayList<String> mid = new ArrayList<>();
    private ArrayList<String> murl = new ArrayList<>();
    private ArrayList<String> mitemid = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        Intent intent = getIntent();
        uname = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        pass = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        iddb = intent.getStringExtra(MainActivity.EXTRA_ID);
        Log.d(TAG, "onCreate: started.");


        initImageBitmaps();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.item0:
                Intent intent = new Intent(this,Account.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent intent2 = new Intent(this,Home.class);
        startActivity(intent2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_checkout,menu);
        return true;
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        List<Cart> carts = new ArrayList<>();
        db = new DatabaseSqlite(showCart.this);
        List<Cart> items = db.getCart();
        System.out.println("Here1");
        int lengthuser = items.size();
        String msg = "";
        int i = 0;

        for (Cart eachItem : items) {
            i++;
            mid.add(eachItem.getId());
            murl.add(eachItem.getUrl());
            mitemid.add(eachItem.getItemid());




                }
                System.out.println(i + " i");



        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mid, murl,4,mitemid);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}