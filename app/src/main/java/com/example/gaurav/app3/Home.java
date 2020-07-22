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
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static  final String EXTRA_TEXT = "com.example.gaurav.sqlproject.EXTRA_TEXT";
    public static  final String EXTRA_TEXT2 = "com.example.gaurav.sqlproject.EXTRA_TEXT2";
    public static  final String EXTRA_ID = "com.example.gaurav.sqlproject.EXTRA_ID";
    String uname,pass,iddb;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
            case R.id.item1:
                Intent intent = new Intent(this,Account.class);


                intent.putExtra(EXTRA_TEXT,uname);
                intent.putExtra(EXTRA_TEXT2,pass);
                intent.putExtra(EXTRA_ID,iddb);
               startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent1 = new Intent(this,showCart.class);
                intent1.putExtra(EXTRA_TEXT,uname);
                intent1.putExtra(EXTRA_TEXT2,pass);
                intent1.putExtra(EXTRA_ID,iddb);
                startActivity(intent1);
                return true;

            case R.id.item3:
            Intent intent2 = new Intent(this,About.class);
            startActivity(intent2);
            return true;

            case R.id.item4:
                Intent intent3 = new Intent(this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"Logged Out Successfully ",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);


        return true;
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://uploads-ssl.webflow.com/5aedeed1810a6fc4aecb4871/5b51e736aee76797c7ad236e_Hrithik%20Roshan%20for%20YSW.jpg");
        mNames.add("Men");
        mImageUrls.add("http://www.thestarcelebrity.com/wp-content/uploads/2018/12/media6eh8Deepika.jpg");
        mNames.add("Women ");
        mImageUrls.add("https://www.deseretnews.com/images/article/hires/1122420/1122420.jpg");
        mNames.add("Kids");
        mImageUrls.add("https://dynaimage.cdn.cnn.com/cnn/w_1200/http%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F181019092852-madonna-home-super-tease.jpg");
        mNames.add("Home");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls,1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}