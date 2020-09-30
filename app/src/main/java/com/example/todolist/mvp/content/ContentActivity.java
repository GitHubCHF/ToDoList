package com.example.todolist.mvp.content;

import androidx.fragment.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.todolist.R;

public class ContentActivity extends AppCompatActivity {

    public FrameLayout fragment;

    public static void startAction(Context context, String title) {
        Intent intent = new Intent(context, ContentActivity.class);
        intent.putExtra(ContentFragment.TITLE, title);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        }
        initView();
    }

    private void initView() {
        fragment = findViewById(R.id.content);
        Fragment contentFragment = ContentFragment.startAction(getIntent().getStringExtra(ContentFragment.TITLE));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, contentFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
