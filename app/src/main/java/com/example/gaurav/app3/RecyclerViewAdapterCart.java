package com.example.gaurav.app3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class RecyclerViewAdapterCart extends  RecyclerView.Adapter<RecyclerViewAdapterCart.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mItemids = new ArrayList<>();
    private ArrayList<String> mprices = new ArrayList<>();
    private Context mContext;
    private  String priceText;
    private  int flag;
    DatabaseSqlite db;

    public RecyclerViewAdapterCart( Context Context,ArrayList<String> Itemids, ArrayList<String> prices,int flag1) {
        mItemids = Itemids;
        mprices = prices;
        mContext = Context;
        flag = flag1;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: Called");

        Glide.with(mContext)
                .asBitmap()
                .load(mItemids.get(position));



        holder.price.setText(mprices.get(position));






    }

    @Override
    public int getItemCount() {
        return mItemids.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{



        TextView price;
        TextView itemid;
        Button removeBtn;
        RelativeLayout parentLayout2;



        public ViewHolder(View itemView) {
            super(itemView);
            itemid = itemView.findViewById(R.id.itemcart);
            price = itemView.findViewById(R.id.pricecart);
            parentLayout2 = itemView.findViewById(R.id.parent_layout2);
            removeBtn = itemView.findViewById(R.id.removebtn);




            removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"Removed",Toast.LENGTH_SHORT).show();
                    db = new DatabaseSqlite(mContext);
                   int  a = db.deleteItem("1111","1");
                   System.out.println("HAHA"+a);





                }
            });
        }
    }
    }
