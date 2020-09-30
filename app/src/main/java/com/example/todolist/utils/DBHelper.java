package com.example.todolist.utils;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.todolist.MyApplication;
import com.example.todolist.bean.ContentBean;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper() {
        super(MyApplication.context, "content", null, 1);
    }


    public boolean addData(ContentBean contentBean) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", contentBean.getTitle());
        values.put("content", contentBean.getContent());
        values.put("type", contentBean.getType());
        long status = db.insert("content_info", null, values);
        db.close();
        return status != -1;
    }

    @SuppressLint("Recycle")
    public List<ContentBean> getContentByTitle(String title) {
        List<ContentBean> contentBeanList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM content_info where title = '" + title + "'";
        Cursor result = db.rawQuery(sql, null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            ContentBean contentBean = new ContentBean();
            contentBean.setTitle(result.getString(result.getColumnIndex("title")));
            contentBean.setContent(result.getString(result.getColumnIndex("content")));
            contentBean.setType(result.getInt(result.getColumnIndex("type")));
            contentBeanList.add(contentBean);
        }
        db.close();
        return contentBeanList;
    }

    @SuppressLint("Recycle")
    public List<String> getTitleList() {
        List<String> titleList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT title FROM content_info";
        Cursor result = db.rawQuery(sql, null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            titleList.add(result.getString(result.getColumnIndex("title")));
        }
        db.close();
        return titleList;
    }

    public void cleanAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("content_info", null, null);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table content_info(title varchar(666)," +
                "content varchar(999)," +
                "type varchar(4)" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
