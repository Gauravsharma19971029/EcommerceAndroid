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

public class ListItem1 extends AppCompatActivity {

    private static final String TAG = "ListItem1Activity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();

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
            case "Topwear":
                mImageUrls.add("https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/6871273/2018/12/14/4240f0cd-e477-41bf-b9e0-90a50ddad9371544771972191-HRX-by-Hrithik-Roshan-Men-Black--Olive-Green-Colourblocked-S-1.jpg");
                mNames.add("Topwear");
                mPrice.add("1200");
                mImageUrls.add("https://www.indianterrain.com/media/catalog/product/cache/0152700198d106b26862de7ff762c33f/6/7/6720579_1.jpg");
                mNames.add("Topwear");
                mPrice.add("1300");
                mImageUrls.add("https://www.indianterrain.com/media/catalog/product/cache/0152700198d106b26862de7ff762c33f/4/6/4619413_1.jpg");
                mNames.add("Topwear");
                mPrice.add("1100");
                mImageUrls.add("https://www.indianterrain.com/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/6/7/6720622_1.jpg");
                mNames.add("Topwear");
                mPrice.add("1150");
                mImageUrls.add("https://www.indianterrain.com/media/catalog/product/cache/0152700198d106b26862de7ff762c33f/5/8/5802590_1.jpg");
                mNames.add("Topwear");
                mPrice.add("1200");
                mImageUrls.add("https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/6871273/2018/12/14/4240f0cd-e477-41bf-b9e0-90a50ddad9371544771972191-HRX-by-Hrithik-Roshan-Men-Black--Olive-Green-Colourblocked-S-1.jpg");
                mNames.add("Topwear");
                mPrice.add("1200");
                mImageUrls.add("https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/6871273/2018/12/14/4240f0cd-e477-41bf-b9e0-90a50ddad9371544771972191-HRX-by-Hrithik-Roshan-Men-Black--Olive-Green-Colourblocked-S-1.jpg");
                mNames.add("Topwear");
                mPrice.add("1200");
                mImageUrls.add("https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/6871273/2018/12/14/4240f0cd-e477-41bf-b9e0-90a50ddad9371544771972191-HRX-by-Hrithik-Roshan-Men-Black--Olive-Green-Colourblocked-S-1.jpg");
                mNames.add("Topwear");
                mPrice.add("1200");

                break;

            case "Sachin":
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
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls,3,mPrice);
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

