package com.example.todolist.bean;

import java.io.Serializable;

public class ContentBean implements Serializable {
    private String title;
    private String content;
    private int type; // 0未完成 1已完成

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
