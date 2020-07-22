package com.example.gaurav.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListItem extends AppCompatActivity {

    private static final String TAG = "ListItemActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    String imageName;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        switch(imageName){
            case "Men":
                mImageUrls.add("https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/6871273/2018/12/14/4240f0cd-e477-41bf-b9e0-90a50ddad9371544771972191-HRX-by-Hrithik-Roshan-Men-Black--Olive-Green-Colourblocked-S-1.jpg");
                mNames.add("Topwear");
                mImageUrls.add("https://images.bewakoof.com/t320/zaffre-blue-slim-fit-cotton-chino-pants-men-s-slim-fit-cotton-chino-pants-191255-1539858928.jpg");
                mNames.add("Bottomwear");
                mImageUrls.add("https://sslimages.shoppersstop.com/B8AC9759D45547D9AEF177F0DE13B7C8/img/BAD26E1468DF4B9EBCD20FDF9213C892/204498880_9607_BAD26E1468DF4B9EBCD20FDF9213C892.jpg");
                mNames.add("Sportswear");
                mImageUrls.add("https://static2.fashionbeans.com/wp-content/uploads/2016/11/2016watchestop-5.jpg");
                mNames.add("Watches and Wearable");
                mImageUrls.add("https://ae01.alicdn.com/kf/HTB1IBt.JFXXXXb0XXXXq6xXFXXXn/YOOSKE-Brand-Metal-Sunglasses-Men-Polarized-Driving-black-male-Sun-Glasses-Mens-Sunglasses-Brand-Designer-masculine.jpg_640x640.jpg");
                mNames.add("Sunglasses");
                mImageUrls.add("https://i.pinimg.com/736x/a5/6f/96/a56f96251b6986057f80cdcf68739a40--winter-boots-for-men-casual-male-fashion.jpg");
                mNames.add("Footwear");
                mImageUrls.add("https://joojoobs.com/wp-content/uploads/2016/01/minimalist-slim-leather-wallet-024p2_resize.jpg");
                mNames.add("Fashion Accessories");
                break;

            case "Women":
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                mImageUrls.add("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/12/22/635427-sachin-tendulkar.jpg");
                mNames.add("Sachin");
                break;
            default:
                mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/12/VIRAT_KOHLI_JAN_2015_%28cropped%29.jpg");
                mNames.add("Virat");
                mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/12/VIRAT_KOHLI_JAN_2015_%28cropped%29.jpg");
                mNames.add("Virat");
                mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/12/VIRAT_KOHLI_JAN_2015_%28cropped%29.jpg");
                mNames.add("Virat");
                mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/12/VIRAT_KOHLI_JAN_2015_%28cropped%29.jpg");
                mNames.add("Virat");
                mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/12/VIRAT_KOHLI_JAN_2015_%28cropped%29.jpg");
                mNames.add("Virat");
                mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/12/VIRAT_KOHLI_JAN_2015_%28cropped%29.jpg");
                mNames.add("Virat");


        }





        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls,2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            imageUrl = getIntent().getStringExtra("image_url");
            imageName = getIntent().getStringExtra("image_name");

            //setImage(imageUrl, imageName);
        }
    }


    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.imagename);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}

