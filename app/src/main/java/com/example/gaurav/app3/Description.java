package com.example.gaurav.app3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class Description extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "GalleryActivity";
    Spinner size;
    Button addBtn,showBtn;
    DatabaseSqlite db;
    String imgurl;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        addBtn = findViewById(R.id.addcart);
        showBtn = findViewById(R.id.showbtn);
        db = new DatabaseSqlite(Description.this);
        size = findViewById(R.id.size_text);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sizeman,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(adapter);
        size.setOnItemSelectedListener(this);

        Log.d(TAG, "onCreate: started.");


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    db = new DatabaseSqlite(Description.this);
                    List<Cart> items = db.getCart();
                    int lengthuser = items.size();
                    String msg = "";
                    int i = 0;

                    for (Cart eachItem : items) {
                        i++;
                        msg = msg+"Id = "+eachItem.getId()+" URL= "+eachItem.getUrl()+"\n";

                    }

                    validationAlert(msg);
                    showCart();


            }
        });



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = new Cart();

                String ID = "1";
                String Name = "Jiiii";
                String url = imgurl;
                String price = "121212";


                cart.setPrice(price);
                cart.setId(ID);
                cart.setUrl(url);
                cart.setName(Name);
                System.out.println(url);

                long rowNum = db.insertItem(cart);
                System.out.println(rowNum);
                if(rowNum > 0) {
                    validationAlert("Successfully Inserted");
                }else {
                    validationAlert("Database Error");
                }
            }
        });

        getIncomingIntent();
    }







    public void showCart()
    {
        Intent intent1 = new Intent(this,showCart.class);
        startActivity(intent1);

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

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            imgurl = imageUrl;

            setImage(imageUrl, imageName);
        }
    }


    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
