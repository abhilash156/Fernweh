package com.artalos.fernweh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    //Constants
    private static final int DATABASE_VERSION = 0;
    private static final String DATABASE_NAME = "FERNWEH_DB";
    private static DatabaseHandler mDB = null;
    //Object-Relational Mapping (ORM)
    //Class --> Table
    //Properties -- > Columns

    private static final String TABLE_USER = "USER";  //table name

    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_CONTACT = "USER_CONTACT";
    private static final String USER_CITY = "USER_CITY";
    private static final String USER_BUDGET_MIN = "USER_BUDGET_MIN";
    private static final String USER_BUDGET_MAX = "USER_BUDGET_MAX";
    private static final String USER_BIO = "USER_BIO";
    private static final String USER_INTERESTS = "USER_INTERESTS";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_USER + "(" +
                USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT, " +
                USER_EMAIL + " TEXT, " +
                USER_CONTACT + " TEXT, " +
                USER_CITY + " TEXT, " +
                USER_BUDGET_MIN + " TEXT, " +
                USER_BUDGET_MAX + " TEXT, " +
                USER_BIO + " TEXT, " +
                USER_INTERESTS + " TEXT)"; //No comma for the last column
        db.execSQL(sql);
        mDB = this;
    }


    public static DatabaseHandler getDB() {
        return mDB;
    }


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables again
        onCreate(db);
    }


    public void removeUser(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        String arg = String.valueOf(ID);
        String args[] = {arg};

        db.delete(TABLE_USER, USER_ID + " = ?", args);
        db.close();

    }

    // code to add the new restaurant
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getUserName());
        values.put(USER_EMAIL, user.getUserEmail());
        values.put(USER_CONTACT, user.getUserContact());
        values.put(USER_CITY, user.getUserCity());
        values.put(USER_BUDGET_MIN, user.getUserBudgetMin());
        values.put(USER_BUDGET_MAX, user.getUserBudgetMax());
        values.put(USER_BIO, user.getUserBio());
        values.put(USER_INTERESTS, user.getUserInterests());
        // Inserting Row
        db.insert(TABLE_USER, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();//results

        // Select All Query --
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);  //execute a query

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User r = new User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8)
                );
                userList.add(r);
            } while (cursor.moveToNext());


        }
        return userList;
    }

    // code to get the single contact
    public User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[]{USER_ID,
                        USER_NAME, USER_EMAIL, USER_CONTACT, USER_CITY, USER_BUDGET_MIN,
                        USER_BUDGET_MAX, USER_BIO, USER_INTERESTS}, USER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7), cursor.getString(8));
        // return contact
        return user;
    }
}
