package com.example.todolist.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.todolist.R;
import com.example.todolist.bean.ContentBean;
import com.example.todolist.utils.DBHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentBean contentBean = new ContentBean();
        contentBean.setType(1);
        contentBean.setTitle("1233554");
        contentBean.setContent("153264576872141241241298111");
        contentBean.setFinish_time(12432463413L);
        contentBean.setCreate_time(132435465L);
        contentBean.setUpdate_time(15327877L);
        new DBHelper().addData(contentBean);

    }
}