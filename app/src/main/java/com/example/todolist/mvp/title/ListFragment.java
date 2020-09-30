package com.example.todolist.mvp.title;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.R;
import com.example.todolist.mvp.content.ContentActivity;
import com.example.todolist.mvp.content.ContentFragment;

public class ListFragment extends androidx.fragment.app.ListFragment implements ListContract.IView {

    private ListContract.Presenter presenter = new ListPresenter(this);

    private boolean isLandscape;

    private ArrayAdapter<String> listAdapter;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            View contentFrame = getActivity().findViewById(R.id.content);
            isLandscape = contentFrame != null && contentFrame.getVisibility() == View.VISIBLE;
            listAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item);
            setListAdapter(listAdapter);
            presenter.getTitleData();
        }
    }

    @Override
    public void setTitleData(String[] titleData) {
        if (getActivity() != null) {
            listAdapter.addAll(titleData);
            listAdapter.notifyDataSetChanged();
        }
        if (isLandscape) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            presenter.getData(0);
        }
    }
    @Override
    public void showContent(int position) {
        if (isLandscape) {
            getListView().setItemChecked(position, true);
            ContentFragment contentFragment = null;
            if (getFragmentManager() != null) {
                contentFragment = (ContentFragment) getFragmentManager().findFragmentById(R.id.content);
            }
            if (contentFragment == null || !contentFragment.getShowTitle().equals(getChooseTitle(position))) {
                contentFragment = ContentFragment.startAction(getChooseTitle(position));
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content, contentFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            ContentActivity.startAction(getContext(), getChooseTitle(position));
        }
    }


    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        presenter.getData(position);
    }

    private String getChooseTitle(int position) {
        String title = listAdapter.getItem(position);
        return title == null ? "" : title;
    }


}
