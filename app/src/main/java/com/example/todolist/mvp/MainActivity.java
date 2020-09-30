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
        contentBean.setTitle("435475867643655" + new Random().toString());
        contentBean.setContent("1532645768798");
        new DBHelper().addData(contentBean);
    }
}