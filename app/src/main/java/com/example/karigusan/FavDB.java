package com.example.karigusan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FavDB extends SQLiteOpenHelper{
    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "ResortsDB";
    private static String TABLE_NAME = "favoriteTable";
    public static  String KEY_ID = "id";
    public static String ITEM_TITLE = "ItemTitle";
    public static String ITEM_IMAGE = "ItemImage";
    public static String FAVORITE_STATUS = "fStatus";

    private static String CREATE_TABLE ="CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " TEXT," + ITEM_TITLE + " TEXT,"
            + ITEM_IMAGE + " TEXT," + FAVORITE_STATUS+ "TEXT";



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertEmpty() {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        for (int x = 1; x < 11; x++) {
            cv.put(KEY_ID, x);
            cv.put(FAVORITE_STATUS, "0");

            db.insert(TABLE_NAME, null, cv);
        }
    }

    public void insertIntoTheDatabase(String item_title, int item_image, String id, String fav_status) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_IMAGE, item_title);
        cv.put(ITEM_IMAGE, item_image);
        cv.put(KEY_ID, id);
        cv.put(FAVORITE_STATUS, fav_status);
        db.insert(TABLE_NAME, null,cv);
        Log.d("FavDB Status", item_title + ", favstatus - "+fav_status+" - . "+cv);
    }

    public Cursor read_all_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " +TABLE_NAME + " where " + KEY_ID+ "="+id+"";
        return db.rawQuery(sql, null,null);

    }

    public void remove_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME +" SET  "+ FAVORITE_STATUS+"='0' WHERE"+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());
    }

    public Cursor select_all_favorite_list() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+"='1'";
        return db.rawQuery(sql, null, null);
    }



    public FavDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public FavDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public FavDB(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }


}
