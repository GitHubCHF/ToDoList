package com.example.todolist.mvp.content;


import com.example.todolist.bean.ContentBean;
import com.example.todolist.utils.DBHelper;

import java.util.List;

public class ContentPresenter implements ContentContract.Presenter {


    private ContentContract.IView iView;

    public ContentPresenter(ContentFragment fragment) {
        iView = fragment;
    }


    @Override
    public void getContentData(String title) {
        List<ContentBean> contentBeanList = new DBHelper().getContentByTitle(title);
        iView.showContentList(contentBeanList);
    }
}
