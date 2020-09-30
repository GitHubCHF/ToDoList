package com.example.todolist.mvp.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.bean.ContentBean;

import java.util.List;

public class ContentFragment extends Fragment implements ContentContract.IView {

    public final static String TITLE = "title";

    public static ContentFragment startAction(String title) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    public String getShowTitle() {
        if (getArguments() != null) {
            return getArguments().getString(TITLE);
        } else {
            return "";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        initView(view);
        initData();
        return view;
    }

    private RecyclerView recyclerView;
    private ContentAdapter contentAdapter;
    private ContentContract.Presenter presenter = new ContentPresenter(this);

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.content_recycle_view);
        contentAdapter = new ContentAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(contentAdapter);
    }

    private void initData() {
        presenter.getContentData(getShowTitle());
    }

    @Override
    public void showContentList(List<ContentBean> list) {
        contentAdapter.setData(list);
    }
}
