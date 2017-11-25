package com.example.hristian.knowhowcom.posts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.IPostsPresenter;
import com.example.hristian.knowhowcom.Contracts.IPostsView;
import com.example.hristian.knowhowcom.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment implements IPostsView{
    private IPostsPresenter presenter;

    @Inject
    public PostsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_posts, container, false);

        return root;
    }

    @Override
    public void setPresenter(IPostsPresenter presenter) {
        this.presenter = presenter;
    }
}
