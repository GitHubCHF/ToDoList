package com.example.todolist.mvp.content;

import com.example.todolist.bean.ContentBean;

import java.util.List;

public interface ContentContract {

    interface IView {
        void showContentList(List<ContentBean> list);
    }

    interface Presenter {

        void getContentData(String title);
    }
}
