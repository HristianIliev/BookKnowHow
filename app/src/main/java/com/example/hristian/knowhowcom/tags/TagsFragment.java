package com.example.hristian.knowhowcom.tags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.ITagsPresenter;
import com.example.hristian.knowhowcom.Contracts.ITagsView;
import com.example.hristian.knowhowcom.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TagsFragment extends Fragment implements ITagsView{


    private ITagsPresenter presenter;

    @Inject
    public TagsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tags, container, false);

        return root;
    }

    @Override
    public void setPresenter(ITagsPresenter presenter) {
        this.presenter = presenter;
    }
}
