package com.example.gaurav.app3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private Context mContext;
    private  String priceText;
    private  String ItemidText;
    private  int flag;
    DatabaseSqlite db;
    public RecyclerViewAdapter( Context Context,ArrayList<String> ImageNames, ArrayList<String> Images,int flag1) {
        mImageNames = ImageNames;
        mImages = Images;
        mContext = Context;
        flag = flag1;
    }

    public RecyclerViewAdapter( Context Context,ArrayList<String> ImageNames, ArrayList<String> Images,int flag1,ArrayList<String> price) {
        mImageNames = ImageNames;
        mImages = Images;
        mContext = Context;
        mPrice = price;
        flag = flag1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: Called");


            Glide.with(mContext)
                    .asBitmap()
                    .load(mImages.get(position))
                    .into(holder.image);



        holder.imagename.setText(mImageNames.get(position));
        if (flag == 3 ){
            holder.price.setText("INR "+mPrice.get(position));

        }
        if (flag == 4 ){

                holder.price.setText(mPrice.get(position) );

            System.out.println(priceText+" price");
               // holder.itemid.setText(mPrice.get(position));


        }



        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag == 1)
                {
                    Log.d(TAG,"onClick: Clicked on: "+ mImageNames.get(position));
                    Intent intent = new Intent(mContext,ListItem.class);
                    intent.putExtra("image_url", mImages.get(position));
                    intent.putExtra("image_name", mImageNames.get(position));
                    mContext.startActivity(intent);

                    Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_SHORT).show();

                }
                else if(flag == 2)
                {
                    Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                    Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(mContext, ListItem1.class);
                    intent.putExtra("image_url", mImages.get(position));
                    intent.putExtra("image_name", mImageNames.get(position));
                    mContext.startActivity(intent);
                }
                else if(flag == 3)
                {
                    Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                    Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(mContext, Description.class);
                    intent.putExtra("image_url", mImages.get(position));
                    intent.putExtra("image_name", mImageNames.get(position));
                    mContext.startActivity(intent);
                }
                else if (flag == 4)
                {
                    priceText = mPrice.get(position);
                    Toast.makeText(mContext, "Selected Id"+priceText, Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imagename;
        TextView price;
        TextView itemid;
        Button removeBtn;
        RelativeLayout parentLayout;

        public ViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imagename = itemView.findViewById(R.id.imagename);
            price = itemView.findViewById(R.id.price);


            parentLayout = itemView.findViewById(R.id.parent_layout);
            itemid = itemView.findViewById(R.id.txt);

           // priceText = price.getText().toString();



            if(flag == 1 || flag == 2)
            {
                itemView.findViewById(R.id.price).setVisibility(View.INVISIBLE);

            }
            if(flag == 1 || flag == 2 || flag == 3)
            {
                itemView.findViewById(R.id.rmvbtn).setVisibility(View.INVISIBLE);
                itemView.findViewById(R.id.txt).setVisibility(View.INVISIBLE);

            }
            if (flag == 4)
            {

                Button rmvbtn = itemView.findViewById(R.id.rmvbtn);

                        System.out.println("Here2");
                     //   priceText = price.getText().toString();
                rmvbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        db = new DatabaseSqlite(mContext);
                        int isdelete = db.deleteItem("1",priceText);
                        if(isdelete > 0)
                        {
                            System.out.println("Success");
                            Toast.makeText(mContext, "Deleted Item id "+priceText, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(mContext, showCart.class);
                            mContext.startActivity(intent);


                        }
                        else
                        {

                        }
                    }
                });
            }
        }
    }
}
