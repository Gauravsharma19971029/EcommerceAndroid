package com.example.gaurav.app3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSqlite extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sjbit2.db";
    public static String TABLE_NAME = "sjbit_users";
    public static String TABLE_NAME2 = "cart";
    public static String _ID = "id";
    public static String _Name = "name";
    public static String _URL = "url";
    public static String _PRICE= "price";
    public static String _ItemId= "itemid";

    public static String _Pass = "password";
    public static String _MOBILE = "mobile_no";
    public static String _ADDRESS = "address";

    Context context;
    public String TABLE_QUERY =    "CREATE TABLE " + TABLE_NAME + " (" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            _Name + " TEXT," +
            _Pass + " TEXT)";
    public String TABLE_QUERY2 =    "CREATE TABLE " + TABLE_NAME2 + " (" +
            _ID + " TEXT ," +
            _Name + " TEXT ," +
            _URL + " TEXT," +
            _PRICE + " TEXT,"+
            _ItemId + " INTEGER PRIMARY KEY AUTOINCREMENT)";

    public DatabaseSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_QUERY2);
        db.execSQL(TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }


    public long insertUser(User sjbitUser){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_Name, sjbitUser.getName());
        values.put(_Pass, sjbitUser.getPassword());


        long rowNum = db.insert(TABLE_NAME, null, values);

        return rowNum;
    }

    public long insertItem(Cart cart){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_ID, cart.getId());
        values.put(_Name, cart.getName());
        values.put(_URL, cart.getUrl());
        values.put(_PRICE, cart.getPrice());
        values.put(_ItemId, cart.getItemid());



        long rowNum = db.insert(TABLE_NAME2, null, values);

        return rowNum;
    }


    public List<User> getAllUSers() {

        List<User> users = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User sjbitUser = new User();
                sjbitUser.setId(cursor.getInt(cursor.getColumnIndex(_ID)));
                sjbitUser.setName(cursor.getString(cursor.getColumnIndex(_Name)));
                sjbitUser.setPassword(cursor.getString(cursor.getColumnIndex(_Pass)));

                users.add(sjbitUser);

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return users;
    }

    public List<Cart> getCart() {

        List<Cart> carts = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Cart sjbitUser = new Cart();
                sjbitUser.setId(cursor.getString(cursor.getColumnIndex(_ID)));
                sjbitUser.setName(cursor.getString(cursor.getColumnIndex(_Name)));
                sjbitUser.setUrl(cursor.getString(cursor.getColumnIndex(_URL)));
                sjbitUser.setPrice(cursor.getString(cursor.getColumnIndex(_PRICE)));
                sjbitUser.setItemid(cursor.getString(cursor.getColumnIndex(_ItemId)));



                carts.add(sjbitUser);

            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return carts;
    }


    public boolean updateAccount(String id1,String name,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(id1+" UPDATE HERE");
        ContentValues Values = new ContentValues();
        Values.put(_ID,id1);
        Values.put(_Name,name);
        Values.put(_Pass,password);
        db.update(TABLE_NAME,Values,"id = ?",new String[]{String.valueOf(id1)});
        return true;
    }
    public  int deleteAccount(String id1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(id1+"DELETE HERE");
        return db.delete(TABLE_NAME,"id = ?",new String[] {id1});



    }

    public int deleteItem(String id1,String itemid1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2,"id = ? and itemid = ?",new String[] {id1,itemid1});

    }

}