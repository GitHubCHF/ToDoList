package com.example.todolist.mvp.title;

public interface ListContract {

    interface IView {
        void showContent(int position);
        void setTitleData(String[] titleData);
    }

    interface Presenter {
        void getData(int position);
        void getTitleData();
    }
}
