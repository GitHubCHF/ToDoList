package com.example.todolist.mvp.title;

import com.example.todolist.utils.DBHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListPresenter implements ListContract.Presenter {


    private ListContract.IView iView;

    public ListPresenter(ListFragment fragment) {
        iView = fragment;
    }


    @Override
    public void getData(int position) {
        iView.showContent(position);
    }

    @Override
    public void getTitleData() {
        List<String> titleList = new DBHelper().getTitleList();
        Set<String> set = new HashSet<>(titleList);
        String[] titles = set.toArray(new String[0]);
        iView.setTitleData(titles);
    }
}
